package algorithms_11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		int[] nums={1,0,-1,0,-2,2};
		int target=0;
		List<List<Integer>> rs=fourSum(nums, target);
		System.out.println(rs.size());
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rs=new ArrayList<List<Integer>>();
        if(nums==null||nums.length<4)//当nums为空数组或nums的元素不足4个时直接返回
            return rs;
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-3;i++){
            if(i!=0&&nums[i]==nums[i-1])//当前元素与前一元素相同，直接跳过
                continue;
            for(int j=i+1;j<length-2;j++){
                if(j!=i+1&&nums[j]==nums[j-1])//当前元素与前一元素相同，直接跳过
                    continue;
            	find(nums,nums[i],nums[j],j+1,length-1,target,rs);
            }
        }
        return rs;
    }
	
	private static void find(int[] nums,int first,int second,int low,int high,int target,List<List<Integer>> rs){
		while(low<high){
			if(first+second+nums[low]+nums[high]==target){//当四数之和等于目标时
				List<Integer> tmp=new ArrayList<Integer>();
				tmp.add(first);
				tmp.add(second);
				tmp.add(nums[low]);
				tmp.add(nums[high]);
				rs.add(tmp);
				while(low<high&&nums[low]==nums[low+1])
					low++;
				while(low<high&&nums[high]==nums[high-1])
					high--;
				low++;//地址下标变更
				high--;
			}else if(first+second+nums[low]+nums[high]<target)//当四数之和小于目标时，证明nums[low]太小，low++
				low++;
			else//当四数之和大于目标时，证明nums[high]太大，high++
				high--;
		}
	}
	
	
}
