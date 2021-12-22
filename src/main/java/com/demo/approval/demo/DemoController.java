package com.demo.approval.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<IndividualPartyRequestDto> getProspect() {
        return ResponseEntity.ok(DataBuilder.createProspectDto());
    }

    @GetMapping("/dynamicData")
    public ResponseEntity<DynamicDataDto> getDynamicData() {
        return ResponseEntity.ok(
                DynamicDataDto.builder()
                        .id(UUID.randomUUID())
                        .firstName("Jacques")
                        .lastName("Mesrine")
                        .build()
        );
    }
}
