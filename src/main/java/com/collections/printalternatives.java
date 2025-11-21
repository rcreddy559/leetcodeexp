package com.collections;

import java.util.stream.IntStream;

public class printalternatives {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream.range(0, array.length).filter(i -> i % 2 == 10).map(i -> array[i]).forEach(System.out::println);
    }
}
