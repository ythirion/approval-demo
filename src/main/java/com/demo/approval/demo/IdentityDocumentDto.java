package com.demo.approval.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentityDocumentDto {
    private String identityDocumentNumber;
    private String identityDocumentType;
    private String issuingCountryCode;
    private LocalDate identityDocumentIssueDate;
    private LocalDate identityDocumentExpirationDate;
}
