package com.demo.approval.demo;

import lombok.Getter;

@Getter
public enum SFRecordType {
    INDIVIDUAL_PROSPECT("IndividualPersonProspect", "1001", "Individual Person Prospect"),
    LEGAL_PROSPECT("LegalEntityProspect", "2001", "Legal Entity Prospect"),
    ALL("All", "", "");

    private final String sfValue;
    private final String sector;
    private final String name;

    SFRecordType(String sfValue, String sector, String name) {
        this.sfValue = sfValue;
        this.sector = sector;
        this.name = name;
    }

    public static SFRecordType fromSfRecordTypeValue(String sfRecordType) {
        for (SFRecordType recordType : SFRecordType.values()) {
            if (recordType.getSfValue().equalsIgnoreCase(sfRecordType)) {
                return recordType;
            }
        }
        throw new IllegalArgumentException("Unknown record type");
    }

    public String getSfValue() {
        return sfValue;
    }
}