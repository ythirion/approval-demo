package com.demo.approval.demo;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.Document;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TemplateRetrieverTests {
    @Test
    void given_glpp_and_individual_prospect_should_return_glpp() {
        final var result = DocumentTemplateType.fromDocumentTypeAndRecordType("GLPP", "INDIVIDUAL_PROSPECT");
        assertThat(result).isEqualTo(DocumentTemplateType.GLPP);
    }

    @Test
    void given_glpp_and_legal_prospect_should_throws_IllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> DocumentTemplateType.fromDocumentTypeAndRecordType("GLPP", "LEGAL_PROSPECT"));
    }

    @Test
    void combinationTests() {
        CombinationApprovals.verifyAllCombinations(
                DocumentTemplateType::fromDocumentTypeAndRecordType,
                new String[]{"AUTP", "AUTM", "DEERPP", "DEERPM", "SPEC", "GLPP", "GLPM"},
                new String[]{"INDIVIDUAL_PROSPECT", "LEGAL_PROSPECT", "ALL"}
        );
    }

    @Test
    void combinationTestsV2() {
        CombinationApprovals.verifyAllCombinations(
                DocumentTemplateType::fromDocumentTypeAndRecordType,
                Arrays.stream(DocumentTemplateType.values()).map(Enum::name).toArray(String[]::new),
                Arrays.stream(SFRecordType.values()).map(Enum::name).toArray(String[]::new)
        );
    }
}
