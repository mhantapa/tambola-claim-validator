package com.tambola.claim.validator.factory;

import com.tambola.claim.validator.enums.ClaimType;
import com.tambola.claim.validator.validators.ClaimValidator;
import com.tambola.claim.validator.validators.impl.BottomLineValidator;
import com.tambola.claim.validator.validators.impl.EarlyFiveValidator;
import com.tambola.claim.validator.validators.impl.FullHouseValidator;
import com.tambola.claim.validator.validators.impl.MiddleLineValidator;
import com.tambola.claim.validator.validators.impl.TopLineValidator;

import java.util.EnumMap;

public class ClaimValidatorFactory {
    private static final EnumMap<ClaimType, ClaimValidator> claimValidatorMap = new EnumMap<>(ClaimType.class);

    static {
        claimValidatorMap.put(ClaimType.TOP_LINE, new TopLineValidator());
        claimValidatorMap.put(ClaimType.MIDDLE_LINE, new MiddleLineValidator());
        claimValidatorMap.put(ClaimType.BOTTOM_LINE, new BottomLineValidator());
        claimValidatorMap.put(ClaimType.EARLY_FIVE, new EarlyFiveValidator());
        claimValidatorMap.put(ClaimType.FULL_HOUSE, new FullHouseValidator());
    }

    public static ClaimValidator getClaimType(ClaimType claimType) {
        return claimValidatorMap.get(claimType);
    }
}
