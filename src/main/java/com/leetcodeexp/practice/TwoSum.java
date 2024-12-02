package com.leetcodeexp.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 11, 15, 7 };
        int target = 9;
        int[] result = solution(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }
        return new int[] {};
    }
    

    public static int[] solution1(int[] num, int target) {

        if (num == null || num.length < 2) {
            return new int[] {};
        }
        
        for (var i = 0; i < num.length - 1; i++) {
            for (var j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[]{};
    }
}
