package com.tambola.claim.validator.validators.impl;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.model.Ticket;
import com.tambola.claim.validator.validators.ClaimValidator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LineValidator implements ClaimValidator {

    protected abstract int getRowIndex();

    protected abstract ClaimStatus getClaimStatus(int crossedCount, boolean lastNumberContained);

    @Override
    public ClaimStatus validateClaim(Ticket ticket, List<Integer> announcedNumbers) {
        int rowIndex = getRowIndex();
        Set<Integer> rowSet = ticket.getTicketNumbers().get(rowIndex);
        AtomicInteger countCrossedNumbers = new AtomicInteger();
        announcedNumbers.forEach(number -> {
            if (rowSet.contains(number))
                countCrossedNumbers.getAndIncrement();
        });
        return getClaimStatus(countCrossedNumbers.get(), rowSet.contains(announcedNumbers.get(announcedNumbers.size() - 1)));
    }

}
