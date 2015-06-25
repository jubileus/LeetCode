package algorithms_31_40;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums={1};
		int target=0;
//		System.out.println(binarySearch(nums, target, 0, nums.length-1));
		System.out.println(searchInsert(nums, target));
	}
	
	public static int searchInsert(int[] nums, int target) {
		int i=0;
        int j=nums.length-1;
        
        while(i<=j){
        	int middle=(i+j)>>1;
        	if(nums[middle]==target){//middle对应元素等于target，直接返回middle
        		return middle;
        	}else if(nums[middle]>target){//middle对应元素大于target，向左寻找
        		j=middle-1;
        	}else{//middle对应元素小于target，向右寻找
        		i=middle+1;
        	}
        }
        
        return i;
    }

	
//	//方法一：
//    public static int searchInsert(int[] nums, int target) {
//        int rs=binarySearch(nums, target, 0, nums.length-1);//查看target是否在数组中
//        if(rs==-1){
//        	return binaryInsert(nums, target, 0, nums.length-1);//target不在数组中，则查找插入位置
//        }
//        return rs;
//    }
//    
//    private static int binaryInsert(int[]nums,int target,int begin,int end){
//    	int middle=(begin+end)>>1;
//    	if(begin<=end){
//    		if(nums[middle]<target){//middle对应元素比target小，说明插入位置在middle右边
//    			if(middle+1>nums.length-1){//如果middle右侧不再有元素，middle+1就是插入位置
//    				return middle+1;
//    			}
//    			if(nums[middle+1]>target){//如果middle右侧毗邻元素比target大的话，middle+1就是插入位置
//    				return middle+1;
//    			}else{//继续向右寻找
//    				return binaryInsert(nums, target, middle+1, end);
//    			}
//    		}else{//middle对应元素比target大，说明插入位置在middle左边
//    			if(middle-1<0){//如果middle左侧不再有元素的话，middle就是插入位置
//    				return 0;
//    			}
//    			if(nums[middle-1]<target){//如果middle左侧毗邻元素比target小的话，middle就是插入位置
//    				return middle;
//    			}else{//继续向左寻找
//    				return binaryInsert(nums, target, begin, middle-1);
//    			}
//    		}
//    	}
//    	return 0;
//    }
//    
//    private static int binarySearch(int[]nums,int target,int begin,int end){//二分查找
//    	int middle=(begin+end)>>1;
//    	if(begin<=end){
//    		if(nums[middle]==target){
//    			return middle;
//    		}else if(nums[middle]>target){
//    			return binarySearch(nums, target, 0, middle-1);
//    		}else{
//    			return binarySearch(nums, target, middle+1, end);
//    		}
//    	}
//    	return -1;
//    }
}
