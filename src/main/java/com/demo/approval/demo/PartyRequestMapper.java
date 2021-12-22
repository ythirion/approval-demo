package com.demo.approval.demo;

import org.mapstruct.*;
import org.springframework.util.CollectionUtils;

@Mapper(builder = @Builder(disableBuilder = true))
public interface PartyRequestMapper {
    @BeanMapping(qualifiedByName = "toSF")
    @Mapping(source = ".", target = ".")
    @Mapping(source = "title", target = "salutation")
    @Mapping(source = "mnemonic", target = "mnemonic__c")
    @Mapping(source = "familyName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "birthName", target = "maidenName__pc")
    @Mapping(source = "gender", target = "finServ__Gender__pc")
    @Mapping(source = "birthDate", target = "personBirthdate")
    @Mapping(source = "birthCity", target = "cityOfBirth__pc")
    @Mapping(source = "birthCountryCode", target = "countryOfBirth__pc")
    @Mapping(source = "maritalStatus", target = "finServ__MaritalStatus__pc")
    @Mapping(source = "pepMep", target = "PEPMEPType__pc")
    @Mapping(source = "otherNationality.", target = "secondaryCitizenship__pc")
    SFPersonAccount individualDtoToSF(IndividualPartyRequestDto prospectDto);

    @Named("toSF")
    @AfterMapping
    default void mapSubEntitiesToSF(IndividualPartyRequestDto source,
                                    @MappingTarget SFPersonAccount target) {
        if (CollectionUtils.isEmpty(source.getIdentityDocument())) {
            return;
        }

        io.vavr.collection.List.ofAll(source.getIdentityDocument())
                .forEachWithIndex((element, index) -> {
                    if (index == 0) {
                        target.setLegalDocumentExpirationDate1__c(element.getIdentityDocumentExpirationDate());
                        target.setLegalDocumentIssuingCountry1__c(element.getIssuingCountryCode());
                        target.setLegalDocumentIssuingDate1__c(element.getIdentityDocumentIssueDate());
                        target.setLegalDocumentName1__c(element.getIdentityDocumentType());
                        target.setLegalDocumentNumber1__c(element.getIdentityDocumentNumber());
                    }
                    if (index == 1) {
                        target.setLegalDocumentExpirationDate2__c(element.getIdentityDocumentExpirationDate());
                        target.setLegalDocumentIssuingCountry2__c(element.getIssuingCountryCode());
                        target.setLegalDocumentIssuingDate2__c(element.getIdentityDocumentIssueDate());
                        target.setLegalDocumentName2__c(element.getIdentityDocumentType());
                        target.setLegalDocumentNumber2__c(element.getIdentityDocumentNumber());
                    }
                });
    }
}