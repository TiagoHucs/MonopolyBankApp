package com.monopolybankapp.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static boolean isEqual(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) == 0;
    }

    public static boolean isGreaterThan(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) > 0;
    }

    public static boolean isLessThan(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) < 0;
    }

    public static boolean isGreaterThanOrEqual(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) >= 0;
    }

    public static boolean isLessThanOrEqual(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) <= 0;
    }
}
