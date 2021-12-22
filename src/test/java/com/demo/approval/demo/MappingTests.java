package com.demo.approval.demo;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MappingTests {
    @Test
    void mapDTOtoSF() {
        final var prospectDto = DataBuilder.createProspectDto();
        final var mapper = Mappers.getMapper(PartyRequestMapper.class);

        final var sfPersonAccount = mapper.individualDtoToSF(prospectDto);
        assertThat(sfPersonAccount.getMnemonic__c()).isEqualTo("Johnny ?");
        assertThat(sfPersonAccount.getLastName()).isEqualTo("Capone");
        assertThat(sfPersonAccount.getFirstName()).isEqualTo("Al");
        assertThat(sfPersonAccount.getMaidenName__pc()).isEqualTo("Capone");
        assertThat(sfPersonAccount.getFinServ__Gender__pc()).isEqualTo("M");
        assertThat(sfPersonAccount.getPersonBirthdate()).isEqualTo("1908-02-09");
        assertThat(sfPersonAccount.getCityOfBirth__pc()).isEqualTo("Chicago");
        assertThat(sfPersonAccount.getCountryOfBirth__pc()).isEqualTo("US");
        assertThat(sfPersonAccount.getFinServ__MaritalStatus__pc()).isEqualTo("Divorced");
        assertThat(sfPersonAccount.getLegalDocumentIssuingCountry1__c()).isEqualTo("US");
        assertThat(sfPersonAccount.getLegalDocumentIssuingDate1__c()).isEqualTo("2020-02-02");
        assertThat(sfPersonAccount.getLegalDocumentName1__c()).isEqualTo("PI");
        assertThat(sfPersonAccount.getLegalDocumentIssuingCountry1__c()).isEqualTo("US");
        assertThat(sfPersonAccount.getLegalDocumentNumber1__c()).isEqualTo("090808988");
        assertThat(sfPersonAccount.getLegalDocumentExpirationDate1__c()).isEqualTo("2025-02-02");
    }

    @Test
    void mapDTOtoSF_with_approval() {
        final var mapper = Mappers.getMapper(PartyRequestMapper.class);
        final var prospectDto = DataBuilder.createProspectDto();

        Approvals.verify(mapper.individualDtoToSF(prospectDto));
    }
}