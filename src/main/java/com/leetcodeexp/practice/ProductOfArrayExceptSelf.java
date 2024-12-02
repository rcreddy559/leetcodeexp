package  com.leetcodeexp.practice;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        productExceptSelf(nums);
    }
    

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        result[0] = right[1];
        result[nums.length - 1] = left[nums.length - 2];        
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = left[i - 1] * right[i + 1];
        }

        System.out.println(Arrays.toString(productExceptSelf(nums)));
        return result;
    } 
    
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Step 1: Calculate left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] = leftProduct;  // Set the current output to the left product
            leftProduct *= nums[i];    // Update left product for next iteration
        }
        
        // Step 2: Calculate right products and update output
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct; // Multiply with the right product
            rightProduct *= nums[i]; // Update right product for next iteration
        }

        System.out.println(Arrays.toString(productExceptSelf2(nums)));
        return output;
    }
}
