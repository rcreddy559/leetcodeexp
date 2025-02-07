package com.collections.stream;

import java.util.stream.IntStream;

public class StreamUtils {
    public static void main(String[] args) {
        printAlternateElementsOfArray();
        // findMedianOfArray();
        }
    
       
        
    private static void printAlternateElementsOfArray() {
        int[] my_array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        IntStream.range(0, my_array.length).filter(i->i%2==0).map(i->my_array[i]).forEach(System.out::println);
    }
}
