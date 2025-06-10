package com.tambola.claim.validator.enums;

public enum ClaimStatus {
    ACCEPTED,
    REJECTED;

    public static ClaimStatus isAccepted(boolean isAccepted) {
        return isAccepted ? ACCEPTED : REJECTED;
    }
}
