package com.michael.carsensor.helper;

public class RepeatHelper {
    private static final long DEFAULT_TIME_MILLIS = 800;
    private static long lastTimeMillis = 0L;

    public static boolean isFastDoubleAction(long maxTimeMillis) {
        long currentTimeMillis = System.currentTimeMillis();
        long diff = currentTimeMillis - lastTimeMillis;
        if (diff < maxTimeMillis) {
            return true;
        } else {
            lastTimeMillis = currentTimeMillis;
            return false;
        }
    }

    public static boolean isFastDoubleAction() {
        return isFastDoubleAction(DEFAULT_TIME_MILLIS);
    }

}
