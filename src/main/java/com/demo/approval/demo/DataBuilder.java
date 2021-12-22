package com.demo.approval.demo;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class DataBuilder {
    public static IndividualPartyRequestDto createProspectDto() {
        return IndividualPartyRequestDto.builder()
                .birthCity("Chicago")
                .birthCountryCode("US")
                .birthDate(LocalDate.of(1908, 2, 9))
                .birthName("Capone")
                .familyName("Capone")
                .gender("M")
                .identityDocument(List.of(
                        IdentityDocumentDto.builder()
                                .identityDocumentExpirationDate(LocalDate.of(2025, 2, 2))
                                .identityDocumentIssueDate(LocalDate.of(2020, 2, 2))
                                .identityDocumentNumber("090808988")
                                .identityDocumentType("PI")
                                .issuingCountryCode("US")
                                .build()
                ))
                .firstName("Al")
                .maritalStatus("Divorced")
                .mnemonic("Johnny ?")
                .build();
    }
}
