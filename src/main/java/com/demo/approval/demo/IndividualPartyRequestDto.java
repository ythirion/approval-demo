package com.demo.approval.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualPartyRequestDto {
    private String title;
    private String mnemonic;
    private String familyName;
    private String firstName;
    private String middleName;
    private String birthName;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String birthCity;
    private String birthCountryCode;
    private String maritalStatus;
    private String spokenLanguage;
    private String pepMep;
    private String otherNationality;
    private List<IdentityDocumentDto> identityDocument;
}