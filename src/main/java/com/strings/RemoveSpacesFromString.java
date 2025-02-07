package com.strings;

import java.util.stream.Collectors;

public class RemoveSpacesFromString {
    public static void main(String[] args) {

        String original = " remove spaces from string in java lang ";
        usingStreams(original);
        System.out.println("=================");
        usingReplaceAll(original);
        System.out.println("=================");
        usingIteration(original);
    }
    
    private static void usingIteration(String original) {
        StringBuffer noSpaces = new StringBuffer();

        for (int i = 0; i < original.length(); i++) {
            if (Character.isWhitespace(original.charAt(i))) {
                continue;
            }
            noSpaces.append(original.charAt(i));
        }
        System.out.println(original);
        System.out.println(noSpaces.toString());

    }

    private static void usingReplaceAll(String original) {
        String noSpaces = original.replaceAll("\\s", "");
        System.out.println(original);
        System.out.println(noSpaces);
    }
    
    static void usingStreams(String original) {
        String noSpaces = original.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c -> (char) c)
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(original);
        System.out.println(noSpaces);
    }
}
