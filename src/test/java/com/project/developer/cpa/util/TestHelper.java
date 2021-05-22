package com.project.developer.cpa.util;

import com.project.developer.cpa.model.CreditCard;

public class TestHelper {

    public static final CreditCard getSuccessCreditCard() {
        return new CreditCard(4003600000000014L, "Deepalakshmi", 23423L, 0L);
    }

    public static final CreditCard getFailureCreditCard() {
        return new CreditCard(4003600000000013L, "Deepalakshmi", 23423L, 0L);
    }
}
