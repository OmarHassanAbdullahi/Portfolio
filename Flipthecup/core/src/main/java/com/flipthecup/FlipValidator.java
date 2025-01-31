package com.flipthecup; // Defines the package for the game

import java.util.Arrays;
import java.util.List;

public class FlipValidator { // Class to validate if a flip is successful
    private static final int ROTATION_TOLERANCE = 10; // Tolerance level for rotation in degrees
    private static final int POSITION_TOLERANCE = 20; // Tolerance level for position in pixels

    public boolean isValidFlip(float rotation, float currentY, float initialY) {

        // Normalizing the rotation value to always be between 0 and 360
        int normalRotation = (int) ((rotation % 360 + 360) % 360);

        // List of valid rotation values where the cup should land upright
        List<Integer> validRotations = Arrays.asList(0, 360);

        // Checks if the current rotation falls within the tolerance range of a valid rotation
        boolean invalidRotation = validRotations.stream()
            .anyMatch(validRotation -> normalRotation >= validRotation - ROTATION_TOLERANCE &&
                normalRotation <= validRotation + ROTATION_TOLERANCE);

        // Convert floating-point Y positions to integers for easier comparison
        int intCurrentY = (int) currentY;
        int intInitialY = (int) initialY;

        // Checks if the current Y position is within the allowed tolerance range of the initial position
        boolean invalidPosition =
            (intCurrentY >= intInitialY - POSITION_TOLERANCE) &&
                (intCurrentY <= intInitialY + POSITION_TOLERANCE);

        // A flip is valid only if it does not fail the rotation or position check
        return !invalidRotation || !invalidPosition;
    }
}


