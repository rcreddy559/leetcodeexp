package com.collections;

import java.util.List;

public class OtherStringStreamApi {

    public static void main(String[] args) {
        maskMobileNumbers();
    }

    private static void filterNumbersOnly() {
        String[] arr = { "abc", "123", "a1b2", "456", "def" };

        List<String> strings = List.of(arr);
        strings.stream()
                .filter(s -> s.matches("\\d+"))
                .forEach(System.out::println);
    }

    private static void maskMobileNumbers() {
        List<String> mobileNumbers = List.of("1234567890",
                "0987654321",
                "5556667777",
                "4445556666",
                "3332221111",
                "1112223333",
                "9998887777",
                "7778889999");
        mobileNumbers.stream()
                .map(num -> num.replaceAll("\\d(?=\\d{3})", "*"))
                .forEach(System.out::println);
    }

}
