package com.company.algorithm.ArrayAlgorithm;

import java.util.Arrays;
import java.util.List;

public class DynamicProgram {
    public static void main(String[] args) {
//        int n = climbStairs(4);
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[] arr = {2,7,9,3,1};
//        int[][] grid = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int n = rob(arr);
        System.out.println(n);
    }

    /**
     * 题目： 需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的
     * 方法可以爬到楼顶呢
     * 输入： n=2
     * 输出： 2 （1+1,2）
     * 方程： dp[n] = dp[n-1] + dp[n-2]
     * 特殊： dp[1] = 1, dp[2] = 2
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    /**
     * 题目： 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总
     * 和为最小, 每次只能向下或者向右移动一步
     * 输入： [
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]]
     * 输出： 7, 1-3-1-1-1
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][columns-1];
    }

    /**
     * 题目： 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回
     * 其最大和
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 思路： 以尾数开始分析，因为是连续的，到达当前数字有两种情况
     * 1. dp[cur - 1] + dp[cur] < dp[cur] 说明前面结果为付， 只取arr[cur]
     * 2. dp[cur - 1] + dp[cur] > cp[cur] 取 dp[cur - 1] + dp[cur]
     * 方程： max(dp[0], dp[1], dp[]......dp[n-1])
     * @param arr
     * @return
     */
    public static int maxSubArr(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i-1] <= 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i-1] + arr[i];
            }
        }
        int result = -1 << 31;
        for (int val : dp) {
            result = max(result, val);
        }
        return result;
    }
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    /**
     * 题目： 给定一个无序的整数数组，找到其中最长上升子序列的长度
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 思路：
     * 方程：
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        return 0;
    }

    /**
     * 题目： 三角形最小路径和， 每一步只能移动到下一行中相邻的结点上
     * 输入：[
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]]
     * 输出： 11
     * 状态定义： 自顶而下到达当前节点[i][j]时的最小和
     * 方程： dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
     * @param triangle
     * @return
     */
    public static int minTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        //特殊位置
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
        for (int j = 1; j < rows; j++) {
            dp[j][j] = dp[j-1][j-1] + triangle.get(j).get(j);
        }
        for (int i = 2; i < rows; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int rs = 1 << 31 - 1;

        for (int val : dp[rows-1]) {
            rs = min(rs, val);
        }
        return rs;
    }
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    /**
     * 题目： 打家劫舍，每间房内都藏有一定的现金，只能偷不相邻的两个房间
     * 输入: [1,2,3,1]
     * 输出: 4
     * 状态定义： 从前往后，偷至i房间时所能达到的最大金额，i房间不一定要偷
     * 方程： 至每个房间时最大金额： min(dp[i-1], dp[i-2]+nums[i]), 最好取dp[n-1]
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
}
