package com.demo.approval.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class DynamicDataDto {
    private final UUID id;
    private final String firstName;
    private final String lastName;
}
