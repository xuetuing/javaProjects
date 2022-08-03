package com.company.algorithm.bitoperate;

/**
 * 位运算特性：
 * 1. n & n-1 == 0, n为2的幂次方
 * 2. 异或运算^, a^a==0, a^0==a, a^b^a==a^a^b==b
 */
public class BitOperationAlg {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 1, 5};
        System.out.println(hammingWeight(7));
    }

    /**
     * 题目：连续n个数的和， 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
     * （A?B:C）
     * 输入: n = 3
     * 输出: 6
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n -1)) > 0;
        return n;
    }

    /**
     * 题目： 判断给定整数是否是 2 的幂次方
     * 思路： n&n-1==0, 如4&3 == 0  记住规律
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0 ;
    }

    /**
     * 题目： 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出
     * 现了一次的元素
     * 输入: [2,2,1]
     * 输出: 1
     * @param nums
     * @return
     */
    public static int singleNum(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    /**
     * 题目：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * 输入: [3,0,1]
     * 输出: 2
     * @param nums
     * @return
     */
    public static int missingNum(int[] nums) {
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            rs ^= i ^ nums[i];
        }
        return rs ^ nums.length;
    }

    public static int missingNum1(int[] nums) {
        int len = nums.length;
        int rs = (len + 1) * len / 2;
        for (int v : nums) {
            rs -= v;
        }
        return rs;
    }

    /**
     * 题目： 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数
     * 输入： 11
     * 输出： 3
     * 思路： 使用掩码 做&运算
     * 数字： 00000101
     * 掩码： 00000001, 00000010, 000000100 依次左移一位
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int rs = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                rs++;
            }
            mask = mask << 1;
        }
        return rs;
    }
}
