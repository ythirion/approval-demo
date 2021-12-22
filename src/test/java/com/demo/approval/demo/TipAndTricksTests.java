package com.demo.approval.demo;

import org.approvaltests.Approvals;
import org.approvaltests.namer.NamedEnvironment;
import org.approvaltests.namer.NamerFactory;
import org.approvaltests.strings.Printable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.factory.Mappers;

class TipAndTricksTests {
    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, -145, Integer.MAX_VALUE})
    void isOdd_ParameterizedTest(int number) {
        try (NamedEnvironment en = NamerFactory.withParameters(number)) {
            Approvals.verify(isOdd(number));
        }
    }

    @Test
    void mapDTOtoSF_with_printable_wrapper() {
        final var mapper = Mappers.getMapper(PartyRequestMapper.class);
        final var prospectDto = DataBuilder.createProspectDto();
        final var result = mapper.individualDtoToSF(prospectDto);
        final var printableProspect = new Printable<>(result, person -> person.getFirstName() + "," + person.getLastName());

        Approvals.verify(printableProspect);
    }

    @Test
    void mapDTOtoSF_with_verify_json() {
        final var mapper = Mappers.getMapper(PartyRequestMapper.class);
        final var prospectDto = DataBuilder.createProspectDto();

        Approvals.verifyAsJson(mapper.individualDtoToSF(prospectDto));
    }
}