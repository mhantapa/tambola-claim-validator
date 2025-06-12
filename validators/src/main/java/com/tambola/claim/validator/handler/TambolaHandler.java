package com.tambola.claim.validator.handler;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.enums.ClaimType;
import com.tambola.claim.validator.factory.ClaimValidatorFactory;
import com.tambola.claim.validator.model.Ticket;
import com.tambola.claim.validator.validators.ClaimValidator;

import java.util.List;

public class TambolaHandler {
    private static TambolaHandler tambolaHandler;
    private Ticket ticket;
    private final ClaimValidatorFactory claimValidatorFactory;

    public TambolaHandler(ClaimValidatorFactory claimValidatorFactory) {
        this.claimValidatorFactory = claimValidatorFactory;
    }

    public static synchronized TambolaHandler getTambolaHandler() {
        if (tambolaHandler == null) {
            tambolaHandler = new TambolaHandler(new ClaimValidatorFactory());
        }
        return tambolaHandler;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ClaimStatus validateClaim(ClaimType claimType, List<Integer> announcedNumbers) {
        if (ticket == null) {
            throw new IllegalStateException("Ticket is not initialized.");
        }
        ClaimValidator claimValidator = ClaimValidatorFactory.getClaimType(claimType);
        return claimValidator.validateClaim(ticket, announcedNumbers);
    }
}
