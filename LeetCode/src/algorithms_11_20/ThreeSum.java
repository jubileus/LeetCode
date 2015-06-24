package algorithms_11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums={-1,0,1,2,-1,-4};
		List<List<Integer>> rs=threeSum(nums);
		System.out.println(rs.size());
	}

    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> rs=new ArrayList<List<Integer>>();
    	if(nums==null||nums.length<3)
    		return rs;
        Arrays.sort(nums);//先对数组进行非递减排序
        int length=nums.length;
        for(int i=0;i<length-2;i++){
        	if(i>0&&nums[i]==nums[i-1])//当前元素与前一元素相同，该解与前一元素相同
        		continue;
        	find(nums,i+1,length-1,nums[i],rs);
        }
        return rs;
    }
    
    private static void find(int[] nums,int begin,int end,int target,List<List<Integer>> rs){
    	while(begin<end){
    		if(nums[begin]+nums[end]+target==0){//找到解
    			List<Integer> tmp=new ArrayList<Integer>();
    			tmp.add(target);
    			tmp.add(nums[begin]);
    			tmp.add(nums[end]);
    			rs.add(tmp);//将解添加到结果集
    			while(begin<end&&nums[begin]==nums[begin+1])//下一元素与nums[begin]相同，解也相同
    				begin++;
    			while(begin<end&&nums[end]==nums[end-1])//前一元素与nums[end]相同，解也相同
    				end--;
    			begin++;
    			end--;
    		}else if(nums[begin]+nums[end]+target<0)//三数之和小于0，证明nums[begin]太小，begin++
    			begin++;
    		else//三数之和大于0，证明nums[end]太大，end--
    			end--;
    	}
    }
	
//    private static void quickSort(int[] nums,int low,int high){//快速排序
//    	if(low<high){
//    		int middle=getMiddle(nums, low, high);
//    		quickSort(nums,low,middle-1);
//    		quickSort(nums,middle+1,high);
//    	}
//    }
//    
//    private static int getMiddle(int[] nums,int low,int high){//快速排序时寻找当前枢轴应该在的位置
//    	int tmp=nums[low];
//    	while(low<high){
//    		while(low<high&&tmp<=nums[high]){
//    			high--;
//    		}
//    		nums[low]=nums[high];
//    		while(low<high&&tmp>=nums[low]){
//    			low++;
//    		}
//    		nums[high]=nums[low];
//    	}
//    	nums[low]=tmp;
//    	return low;
//    }
}
