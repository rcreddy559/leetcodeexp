package com.strings;

public class ReversOfString {
    public static void main(String[] args) {
        String str = "Hello World";
        String reversedStr = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedStr);
    }

    private static String reverseString(String str) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reversing: " + str);
        if (str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }

    }
}
