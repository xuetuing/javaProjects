package Questions;
/*
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ��������
 * ���Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز����ظ�����
 * nums = [2,7,11,15]	target = 9
 * ���� [0,1]
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
