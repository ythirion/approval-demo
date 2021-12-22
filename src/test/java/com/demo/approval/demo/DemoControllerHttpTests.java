package com.demo.approval.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.scrubbers.Scrubbers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DemoControllerHttpTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void using_deserialized_object() throws Exception {
        final var result = this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        final var response = objectMapper.readValue(result.getResponse().getContentAsString(), IndividualPartyRequestDto.class);
        assertThat(response.getMnemonic()).isEqualTo("Johnny ?");
        assertThat(response.getFamilyName()).isEqualTo("Capone");
        assertThat(response.getFirstName()).isEqualTo("Al");
        assertThat(response.getBirthName()).isEqualTo("Capone");
        assertThat(response.getGender()).isEqualTo("M");
        assertThat(response.getBirthDate()).isEqualTo("1908-02-09");
        assertThat(response.getBirthCity()).isEqualTo("Chicago");
        assertThat(response.getBirthCountryCode()).isEqualTo("US");
        assertThat(response.getMaritalStatus()).isEqualTo("Divorced");
        assertThat(response.getIdentityDocument().size()).isEqualTo(1);
        assertThat(response.getIdentityDocument().get(0).getIdentityDocumentExpirationDate()).isEqualTo("2025-02-02");
        assertThat(response.getIdentityDocument().get(0).getIdentityDocumentNumber()).isEqualTo("090808988");
        assertThat(response.getIdentityDocument().get(0).getIdentityDocumentType()).isEqualTo("PI");
        assertThat(response.getIdentityDocument().get(0).getIssuingCountryCode()).isEqualTo("US");
        assertThat(response.getIdentityDocument().get(0).getIdentityDocumentIssueDate()).isEqualTo("2020-02-02");
    }

    @Test
    void using_json_path() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mnemonic", is("Johnny ?")))
                .andExpect(jsonPath("$.familyName", is("Capone")))
                .andExpect(jsonPath("$.firstName", is("Al")))
                .andExpect(jsonPath("$.birthName", is("Capone")))
                .andExpect(jsonPath("$.gender", is("M")))
                .andExpect(jsonPath("$.birthDate", is("1908-02-09")))
                .andExpect(jsonPath("$.birthCity", is("Chicago")))
                .andExpect(jsonPath("$.birthCountryCode", is("US")))
                .andExpect(jsonPath("$.maritalStatus", is("Divorced")))
                .andExpect(jsonPath("$.identityDocument[0].identityDocumentNumber", is("090808988")))
                .andExpect(jsonPath("$.identityDocument[0].identityDocumentType", is("PI")))
                .andExpect(jsonPath("$.identityDocument[0].issuingCountryCode", is("US")))
                .andExpect(jsonPath("$.identityDocument[0].identityDocumentIssueDate", is("2020-02-02")))
                .andExpect(jsonPath("$.identityDocument[0].identityDocumentExpirationDate", is("2025-02-02")));
    }

    @Test
    void using_approval() throws Exception {
        Approvals.verify(this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
        );
    }

    @Test
    void using_approval_json() throws Exception {
        Approvals.verifyJson(this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString()
        );
    }

    @Test
    void using_approval_with_scrubber() throws Exception {
        Approvals.verifyJson(this.mockMvc.perform(get("/dynamicData"))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString(),
                new Options(Scrubbers::scrubGuid)
        );
    }
}
