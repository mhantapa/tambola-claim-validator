package com.tambola.claim.validator.validators;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.model.Ticket;

import java.util.List;

public interface ClaimValidator {
    ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers);
}
