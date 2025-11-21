package com.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 9, 5, 2, 6, 8, 9 };
        sort(arr, 0, arr.length - 1);
    }

    static void sort(int[] a, int l, int r) {

        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }

    }

    private static void merge(int[] a, int l, int m, int r) {
       
    }
}
