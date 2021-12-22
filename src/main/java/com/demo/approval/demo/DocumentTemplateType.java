package com.demo.approval.demo;

import lombok.Getter;

@Getter
public enum DocumentTemplateType {

    DEERPP("DEER", SFRecordType.INDIVIDUAL_PROSPECT, "DEERPP", "DEERPP.ftl"),
    DEERPM("DEER", SFRecordType.LEGAL_PROSPECT, "DEERPM", "DEERPM.ftl"),
    AUTP("AUTP", SFRecordType.INDIVIDUAL_PROSPECT, "FSI1LSCI_CBS", "AUTP.ftl"),
    AUTM("AUTM", SFRecordType.LEGAL_PROSPECT, "FSI1LSCE_CBS", "AUTM.ftl"),
    SPEC("SPEC", SFRecordType.ALL, "SIGNSPEC", "SPEC.ftl"),
    GLPP("GLPP", SFRecordType.INDIVIDUAL_PROSPECT, "GUIDEPP", "GLPP.ftl"),
    GLPM("GLPM", SFRecordType.LEGAL_PROSPECT, "GUIDEPM", "GLPM.ftl");

    private final String documentType;
    private final SFRecordType recordType;
    private final String templateId;
    private final String templateFile;

    DocumentTemplateType(String documentType, SFRecordType recordType, String templateId, String templateFile) {
        this.documentType = documentType;
        this.recordType = recordType;
        this.templateId = templateId;
        this.templateFile = templateFile;
    }

    public static DocumentTemplateType fromDocumentTypeAndRecordType(String documentType, String recordType) {
        for (DocumentTemplateType dtt : DocumentTemplateType.values()) {
            if (dtt.getDocumentType().equalsIgnoreCase(documentType)
                    && dtt.getRecordType().equals(SFRecordType.valueOf(recordType))) {
                return dtt;
            } else if (dtt.getDocumentType().equalsIgnoreCase(documentType)
                    && dtt.getRecordType().equals(SFRecordType.ALL)) {
                return dtt;
            }
        }
        throw new IllegalArgumentException("Invalid Document template type or record type");
    }
}