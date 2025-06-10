package com.tambola.claim.validator.validators.impl;

import com.tambola.claim.validator.enums.ClaimStatus;
import com.tambola.claim.validator.utils.Constants;

public class BottomLineValidator extends LineValidator {

    @Override
    protected int getRowIndex() {
        return Constants.BOTTOM_ROW;
    }

    @Override
    protected ClaimStatus getClaimStatus(int crossedCount, boolean lastNumberContained) {
        return ClaimStatus.isAccepted(crossedCount == Constants.COLUMN_SIZE && lastNumberContained);
    }
}
