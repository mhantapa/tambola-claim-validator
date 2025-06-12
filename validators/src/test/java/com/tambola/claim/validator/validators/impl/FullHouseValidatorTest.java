package com.tambola.claim.validator.validators.impl;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.enums.ClaimType;
import com.tambola.claim.validator.handler.TambolaHandler;
import com.tambola.claim.validator.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FullHouseValidatorTest {
    private TambolaHandler tambolaHandler;
    private Ticket ticket;

    @BeforeEach
    public void setup() {
        tambolaHandler = TambolaHandler.getTambolaHandler();
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(4, 16, 48, 63, 76),
                Arrays.asList(7, 23, 38, 52, 80),
                Arrays.asList(9, 25, 56, 64, 83)
        );

        ticket = new Ticket(numbers);
        tambolaHandler.setTicket(ticket);
    }

    @Test
    public void testFullHouseClaimAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83);
        Assertions.assertEquals(ClaimStatus.ACCEPTED, tambolaHandler.validateClaim(ClaimType.FULL_HOUSE, announcedNumbers));
    }

    @Test
    public void testFullHouseClaimRejectedDueToLateClaim() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83, 12);
        Assertions.assertEquals(ClaimStatus.REJECTED, tambolaHandler.validateClaim(ClaimType.FULL_HOUSE, announcedNumbers));
    }
}
