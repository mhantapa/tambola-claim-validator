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

public class BottomLineValidatorTest {
    private TambolaHandler tambolaHandler;
    private Ticket ticket;

    @BeforeEach
    public void setup() {
        tambolaHandler = TambolaHandler.getTambolaHandler();
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(4, 16, null, null, 48, null, 63, 76, null),
                Arrays.asList(7, null, 23, 38, null, 52, null, null, 80),
                Arrays.asList(9, null, 25, null, null, 56, 64, null, 83)
        );
        ticket = new Ticket(numbers);
        tambolaHandler.setTicket(ticket);
    }


    @Test
    public void testBottomLineClaimAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(9, 25, 56, 64, 83);
        Assertions.assertEquals(ClaimStatus.ACCEPTED, tambolaHandler.validateClaim(ClaimType.BOTTOM_LINE, announcedNumbers));
    }

    @Test
    public void testBottomLineClaimRejectedDueToLateClaim() {
        List<Integer> announcedNumbers = Arrays.asList(9, 25, 56, 64, 83, 12);
        Assertions.assertEquals(ClaimStatus.REJECTED, tambolaHandler.validateClaim(ClaimType.BOTTOM_LINE, announcedNumbers));
    }
}
