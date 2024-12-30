package com.leetcodeexp.collections;

import java.util.ArrayList;
import java.util.TreeSet;

public class SortingDemos {

    public static void sorting1() {

        var listColors = new ArrayList<String>();
        listColors.add("Red");
        listColors.add("Blue");
        listColors.add("White");
        listColors.add("Green");
        listColors.add("Yellow");

        var hs = new TreeSet<String>(listColors);
        hs.forEach(System.out::println);
        listColors.stream().sorted().forEach(System.out::println);
        System.out.println("\n");

    }
}
