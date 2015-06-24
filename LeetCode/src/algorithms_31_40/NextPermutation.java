package algorithms_31_40;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums={5,5,1};
//		int[] nums={3,2,1};
		nextPermutation(nums);
	}

    public static void nextPermutation(int[] nums) {
        if(nums.length<=1)//空数组或者是只有一个元素，则跳出方法
        	return ;
        int length=nums.length;
        int left=length-2,right=length-1;//指定两个指针
        int target=-1;//该元素后面的元素为降序排列
        while(left>=0){//从后往前找到第一个使数组不再降序的元素
        	if(nums[left]>=nums[right]){
        		left--;
        		right--;
        	}else{
        		target=left;
        		break;
        	}
        }
        if(target==-1){//数组是降序排列，不存在下一个排列
        	Arrays.sort(nums);//将数组变为升序排列
        	return ;//退出方法
        }
        int next=length-1;
        while(next>target){//从后往前，找到target元素后第一个比target大的元素
        	if(nums[next]>nums[target])
        		break;
        	else
        		next--;
        }
        int tmp=nums[target];//交换target与next指针对应的元素
        nums[target]=nums[next];
        nums[next]=tmp;
        Arrays.sort(nums, target+1, length);//使target后的数组元素变为升序
    }
    
}
