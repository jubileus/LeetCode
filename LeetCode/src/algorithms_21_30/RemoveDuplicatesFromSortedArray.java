package algorithms_21_30;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums={1,1,2,2,2,3,4,5};
		removeDuplicates(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]+" ");
		}
	}

    public static int removeDuplicates(int[] nums) {
        int length=nums.length;//获取未去重的数组元素个数
        if(length<=1)//数组元素不大于1时，直接返回当前数组元素的个数
        	return nums.length;
        int left=0,right=1;//初始化左、右指针
        while(right<nums.length){//当右指针小于nums.length时，说明数组没有遍历完毕
        	if(nums[left]==nums[right]){//当左右指针对应元素相等时，证明找到了重复元素
        		length--;//数组非重复长度-1
        		right++;//右指针右移一个单位
        	}else{//当左右指针对应元素相不等时，证明不是重复元素
        		nums[left+1]=nums[right];//让左指针的右侧元素=当前右指针对应元素
        		right++;//右指针右移一个单位
        		left++;//左指针右移一个单位
        	}
        }
        return length;//返回去重后的数组长度
    }
}
