package com.strings;

public class PercentageOfUppercaseLettersLowercaseLetters {
    /**
     * Calculates the percentage of uppercase and lowercase letters in a given
     * string.
     *
     * @param input the input string
     * @return the percentage of uppercase letters
     */
    public static void main(String[] args) {
        String input = "Hello World! This is a Test String.";
        calculatePercentageOfUppercaseLetters(input);
    }

    public static void calculatePercentageOfUppercaseLetters(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Input string is null or empty.");
            return;
        }

        Long uppercaseCount = input.chars()
                .filter(Character::isUpperCase)
                .count();
        Long lowerCaseCount = input.chars()
                .filter(Character::isLowerCase)
                .count();

        Long totalCount = uppercaseCount + lowerCaseCount;
        if (totalCount == 0) {
            System.out.println("No alphabetic characters found.");
            return;
        }
        double uppercasePercentage = (uppercaseCount * 100.0) / totalCount;
        double lowercasePercentage = (lowerCaseCount * 100.0) / totalCount;

        System.out.println("Percentage of uppercase letters: " + uppercasePercentage + "%");
        System.out.println("Percentage of lowercase letters: " + lowercasePercentage + "%");

    }
}
