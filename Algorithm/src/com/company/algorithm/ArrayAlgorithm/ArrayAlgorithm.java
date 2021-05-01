package com.company.algorithm.ArrayAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayAlgorithm {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        int[] arr2 = {1, 2, 2, 1};
//        int[] result = twoSum(arr, 13);
//        int[] result = intersaction(arr, arr2);
        int[] result = plus1(arr);
        System.out.println(Arrays.toString(result));

    }

    /**
     * 题目： 给定两个数组，编写一个函数来计算它们的交集
     * 示例： 输入： nums1 = [1,2,2,1], nums2 = [2,2]
     *       输出: [2,2]
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] intersaction(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.get(arr1[i]) == null) {
                map.put(arr1[i], 1);
                continue;
            }
            int val = map.get(arr1[i]);
            map.put(arr1[i], ++val);

        }
        int h = 0;
        for (int j = 0; j < arr2.length; j++) {
            Integer val = map.get(arr2[j]);
            if (val != null && val.intValue() > 0) {
                int v = val.intValue();
                map.put(arr2[j], --v);
                arr2[h] = arr2[j];
                h++;
            }
        }

        return Arrays.copyOf(arr2, h);
    }

    /**
     * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     * 示例： 输入 nums = [2, 7, 11, 15], target = 9
     *       输出 [0, 1]
     * @param arr
     * @param target
     * @return
     */
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            if (map.get(val) != null) {
                return new int[]{map.get(val), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    /**
     * 题目： 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
     * 示例： 输入: [1,2,3]
     *       输出: [1,2,4]
     * @param arr
     * @return
     */
    public static int[] plus1 (int[] arr) {
        int[] result = new int[]{};
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] != 9) {
                arr[i] += 1;
                result = arr;
                break;
            } else {
                arr[i] = 0;
                if (i != 0) {
                    continue;
                } else {
                    int[] newArr = new int[arr.length + 1];
                    newArr[0] = 1;
                    System.arraycopy(arr, 0, newArr, 1, arr.length);
                    result = newArr;
                }

            }
        }
        return result;
    }
}
