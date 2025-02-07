package com.pros;

public class CodingExamples {
    public static void main(String[] args) {
        // findMedianOfArray();
        // System.out.println(factorial(5));
        generateFibonacci(10);
    }

    private static void generateFibonacci(int n) {
        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);

    }

    private static void findMedianOfArray() {
        int[] my_array = { 1, 2, 3, 4, 5, 6 };
        int n = my_array.length;
        double median;
        System.out.println((n % 2) + ", : " + my_array[n / 2] + ":" + my_array[n / 2 + 1]);
        if (n % 2 == 1) {
            median = my_array[n / 2];
        } else {
            median = (my_array[n / 2] + my_array[n / 2 + 1]) / 2d;
        }
        System.out.println("Median is:" + median);
    }
}
