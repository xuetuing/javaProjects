package com.company.algorithm.ArrayAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//数组算法相关
public class ArrayAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1, 2, 2, 1};
//        int[] result = twoSum(arr, 13);
//        int[] result = intersaction(arr, arr2);
//        int[] result = plus1(arr);
//        int[] result = rotate(arr, 3);
//        int len = removeElem(arr, 1);
//        int len = removeDuplicates(arr);
//        String prefix = longestCommonPrefix(arr);
        int profit = maxProfit1(arr);
        System.out.println(profit);

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

    /**
     * 题目： 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * 示例： 输入: [1,2,3,4,5,6,7] 和 k = 3
     *       输出: [5,6,7,1,2,3,4]
     * @param arr
     * @param k
     * @return
     */
    public static int[] rotate(int[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        return arr;
    }
    public static void reverse(int[] arr, int start, int end) {
        int sum = start + end;
        for (int i = start; i <= (sum / 2); i++) {
            int tmp = arr[i];
            arr[i] = arr[sum - i];
            arr[sum - i] = tmp;
        }
    }

    /**
     * 题目： 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的
     * 新长度
     * 说明：不使用额外的数组空间，不需要考虑数组中超出新长度后面的元素
     * 输入： nums = [3,2,2,3], val = 3
     * 输出： 2, nums= [2,2....]
     * @param arr
     * @param val
     * @return
     */
    public static int removeElem(int[] arr, int val) {
        int slow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[slow] = arr[i];
                slow++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return slow;
    }

    /**
     * 题目： 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次
     * 说明： 不使用额外的数组空间，不需要考虑数组中超出新长度后面的元素
     * 输入： nums = [1,1,2,2]
     * 输出： 2, nums = [1,2...]
     * @param arr
     * @return
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                arr[slow] = arr[i];
                slow++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return slow;
    }

    /**
     * 题目： 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
     * 输入： ["flower","flow","flight"]
     * 输出: "fl"
     * @param arr
     * @return
     */
    public static String longestCommonPrefix(String[] arr) {
        String prefix = arr[0];
        if (arr.length == 0) {
            return "";
        }
        for(String str: arr) {
            while (!str.startsWith(prefix) && prefix.length() >=0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /**
     * 题目： 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
     * 说明： 最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的
     * 最大利润。注意你不能在买入股票前卖出股票
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 方法： 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
