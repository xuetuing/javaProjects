package Questions;
/*
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 * 可以假设每个输入只对应一种答案，且同样的元素不能重复利用
 * nums = [2,7,11,15]	target = 9
 * 返回 [0,1]
 */

public class SumOfNums {
	public static void main(String[] args) {
		int[] nums = {2,7,11,15,3,5};
		int target = 18;
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int sum = nums[i] + nums[j];
				if(sum == target)
					System.out.println("["+i+","+j+"]");
			}
		}
	}
}
