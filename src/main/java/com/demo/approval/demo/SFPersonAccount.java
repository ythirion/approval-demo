package com.demo.approval.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor()
@NoArgsConstructor
@ToString(callSuper = true)
public class SFPersonAccount {
    @JsonProperty("Name")
    private transient String Name;
    @JsonProperty("LastName")
    private String LastName;
    @JsonProperty("FirstName")
    private String FirstName;
    @JsonProperty("Salutation")
    private String Salutation;
    @JsonProperty("MiddleName")
    private String MiddleName;
    @JsonProperty("PersonBirthdate")
    private LocalDate PersonBirthdate;
    @JsonProperty("PEPMEPType__pc")
    private String PEPMEPType__pc;
    @JsonProperty("FinServ__Gender__pc")
    private String FinServ__Gender__pc;
    @JsonProperty("FinServ__MaritalStatus__pc")
    private String FinServ__MaritalStatus__pc;
    @JsonProperty("Mnemonic__c")
    private String Mnemonic__c;
    @JsonProperty("EmployeeID__c")
    private String EmployeeID__c;
    @JsonProperty("EmploymentStatus__c")
    private String EmploymentStatus__c;
    @JsonProperty("MaidenName__pc")
    private String MaidenName__pc;

    /*PROSPECT PROPERTY*/
    @JsonProperty("CityOfBirth__pc")
    private String CityOfBirth__pc;
    @JsonProperty("ContractType__c")
    private String ContractType__c;
    @JsonProperty("ContractYear__c")
    private String ContractYear__c;
    @JsonProperty("CountryOfBirth__pc")
    private String CountryOfBirth__pc;
    @JsonProperty("CurrentEmploymentCountry__pc")
    private String CurrentEmploymentCountry__pc;
    @JsonProperty("DeclaredMonthlySalary__c")
    private String DeclaredMonthlySalary__c;
    @JsonProperty("MarketingInformationSendByEmail__c")
    private Boolean MarketingInformationSendByEmail__c = false;
    @JsonProperty("MarketingInfoViaBILNetOnlineBanking__c")
    private Boolean MarketingInfoViaBILNetOnlineBanking__c = false;
    @JsonProperty("FinServ__CurrentEmployer__pc")
    private String FinServ__CurrentEmployer__pc;
    @JsonProperty("FinServ__Occupation__pc")
    private String FinServ__Occupation__pc;
    @JsonProperty("FinServ__PrimaryLanguage__pc")
    private String FinServ__PrimaryLanguage__pc;
    @JsonProperty("FinServ__PersonalInterests__c")
    private String FinServ__PersonalInterests__c;
    //New EER
    @JsonProperty("SecondaryCitizenship__pc")
    private String SecondaryCitizenship__pc;
    @JsonProperty("LegalDocumentExpirationDate1__c")
    private LocalDate LegalDocumentExpirationDate1__c;
    @JsonProperty("LegalDocumentIssuingCountry1__c")
    private String LegalDocumentIssuingCountry1__c;
    @JsonProperty("LegalDocumentIssuingDate1__c")
    private LocalDate LegalDocumentIssuingDate1__c;
    @JsonProperty("LegalDocumentName1__c")
    private String LegalDocumentName1__c;
    @JsonProperty("LegalDocumentNumber1__c")
    private String LegalDocumentNumber1__c;
    @JsonProperty("LegalDocumentExpirationDate2__c")
    private LocalDate LegalDocumentExpirationDate2__c;
    @JsonProperty("LegalDocumentIssuingCountry2__c")
    private String LegalDocumentIssuingCountry2__c;
    @JsonProperty("LegalDocumentIssuingDate2__c")
    private LocalDate LegalDocumentIssuingDate2__c;
    @JsonProperty("LegalDocumentName2__c")
    private String LegalDocumentName2__c;
    @JsonProperty("LegalDocumentNumber2__c")
    private String LegalDocumentNumber2__c;
    @JsonProperty("OtherReasonforUSTaxability__c")
    private String OtherReasonforUSTaxability__c;
    @JsonProperty("PresenceofaGreenCard__c")
    private String PresenceofaGreenCard__c;
    @JsonProperty("FinServ__NumberOfChildren__pc")
    private Integer FinServ__NumberOfChildren__pc;
    @JsonProperty("FinancialLinkwithLuxembourg__c")
    private Boolean FinancialLinkwithLuxembourg__c;

    private String PrimaryCitizenship__pc;
    private LocalDate DeathDate__pc;
    private String NatureOfEmployment__c;
    private Boolean Minor__c;
    private Boolean IsGreatRegion__c;
}
