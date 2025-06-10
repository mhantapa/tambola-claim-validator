package com.tambola.claim.validator.validators.impl;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.model.Ticket;
import com.tambola.claim.validator.utils.Constants;
import com.tambola.claim.validator.validators.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class FullHouseValidator implements ClaimValidator {

    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        AtomicBoolean isLastAnnouncedNumberPresent = new AtomicBoolean(false);
        List<Set<Integer>> rows = ticket.getTicketNumbers();
        int totalTicketItems = Constants.ROW_SIZE * Constants.COLUMN_SIZE;
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            rows.forEach(row -> {
                if (row.contains(number)) {
                    countCrossedNumbers.getAndIncrement();
                    isLastAnnouncedNumberPresent.set(true);
                } else
                    isLastAnnouncedNumberPresent.set(false);
            });
        });
        boolean isValidated = (countCrossedNumbers.get() == totalTicketItems) && isLastAnnouncedNumberPresent.get();
        return ClaimStatus.isAccepted(isValidated);
    }

}
