package algorithms_41_50;

public class FirstMissingPositive {

	public static void main(String[] args) {
//		int[] nums={-4,3,2,1,0,-2,4,7,9,10,-3};
		int[] nums={0};
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		for(int i=0;i<nums.length;i++){//思路是将数组中在1-nums.length之间的数字放置到正确的位置上
			while(nums[i]!=i+1){
				if(nums[i]<=0||nums[i]>=nums.length||nums[i]==nums[nums[i]-1]){//当nums[i]是负数，或大于数组长度，或与正确位置上的数字相同时
					break;
				}
				//进行交换
				int tmp=nums[i];
				nums[i]=nums[nums[i]-1];
				nums[tmp-1]=tmp;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i+1){
				return i+1;
			}
		}
		return nums.length+1;//当数组恰巧都是1-nums.length之间的数字时，返回nums.length+1
    }
}
