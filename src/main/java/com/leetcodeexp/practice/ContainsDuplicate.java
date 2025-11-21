package com.leetcodeexp.practice;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(solution(nums));
    }

    public static boolean solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashSet<Integer> numsSet = new HashSet<>(nums.length);
        for (var i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (numsSet.contains(nums[i]))
                return true;
            numsSet.add(nums[i]);
        }
        return false;
    }

    public static boolean solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        for (var i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
