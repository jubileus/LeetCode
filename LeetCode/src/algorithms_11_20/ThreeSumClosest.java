package algorithms_11_20;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums={-1,2,1,-4};
		int target=1;
		System.out.println(threeSumClosest(nums, target));
	}

    public static int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);//将nums进行非递减排序
        int length=nums.length;
        int closest=0;
        boolean closestIsNull=true;//是否是第一次比较
        for(int i=0;i<length-2;i++){
        	if(i!=0&&nums[i]==nums[i-1])
        		continue;
        	int low=i+1,high=length-1;//从两侧向目标值靠近
        	while(low<high){
        		int sum=nums[i]+nums[low]+nums[high];//计算三数之和
        		if(closestIsNull){//第一次进行比较
        			closest=sum;
        			closestIsNull=false;
        		}
        		if(Math.abs(sum-target)<Math.abs(closest-target))//当前三数之和比之前的最接近值更相近
        			closest=sum;
        		if(sum<target){//sum<target，说明nums[low]太小，low++
        			while(low<high&&nums[low]==nums[low+1])
        				low++;
        			low++;
        		}else{//sum>target，说明nums[high]太大，high--
        			while(low<high&&nums[high]==nums[high-1])
        				high--;
        			high--;
        		}
        	}
        }
        return closest;
    }
    
}
