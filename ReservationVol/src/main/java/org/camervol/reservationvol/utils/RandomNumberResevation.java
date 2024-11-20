package org.camervol.reservationvol.utils;

import java.security.SecureRandom;

public class RandomNumberResevation {
    private static final String ALPHANUMERIC_CHARACTERS = "0123456789";
    private static final int IDENTIFIER_LENGTH = 8;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateNumeroReservation() {
        StringBuilder builder = new StringBuilder("CV");
        for (int i = 0; i < IDENTIFIER_LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(ALPHANUMERIC_CHARACTERS.length());
            builder.append(ALPHANUMERIC_CHARACTERS.charAt(randomIndex));
        }
        return builder.toString();
    }
}

