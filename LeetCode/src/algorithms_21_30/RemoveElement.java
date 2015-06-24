package algorithms_21_30;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums={1,3,4,2,5,2,3,7};
		int val=2;
		System.out.println(removeElement(nums, val));
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

    public static int removeElement(int[] nums, int val) {
    	int len=nums.length;//获取初始数组长度
    	int length=nums.length;//获取数组总长度
    	int left=0,right=0;//初始化左、右指针
        while(right<length){//当右指针小于length时，未遍历完毕
        	if(nums[right]==val){//当nums[right]==val时，找到了目标元素
        		len--;//非重复长度-1
        	}else{
        		nums[left]=nums[right];//将非目标元素放置在队列的正确位置
        		left++;//左指针右移一个单位
        	}
        	right++;//右指针右移一个单位
        }
        return len;//返回非重复数组长度
    }
}
