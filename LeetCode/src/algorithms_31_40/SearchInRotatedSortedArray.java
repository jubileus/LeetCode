package algorithms_31_40;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums={5,1,2,3,4};
		System.out.println(search(nums, 4));
	}

    public static int search(int[] nums, int target) {
    	int len=nums.length;
    	
    	if(len==0){//数组为空，直接返回-1
    		return -1;
    	}
    	
    	if(len==1){//数组只有一个元素，直接进行判断
    		return nums[0]==target?0:-1;
    	}
    	
    	//查找最小元素的地址
    	int min_index=getStartIndex(nums, 0, len-1);
    	
    	//判断最小元素是不是要找的target
    	if(nums[min_index]==target){
    		return min_index;
    	}
    	
    	//按位置进行二分查找
    	if(min_index==0){//最小元素是第一个元素，数组本身有序
    		return binarySearch(nums, 0, len-1, target);//直接二分查找
    	}else if(min_index==len-1){//最小元素是最后一个元素
    		return binarySearch(nums, 0, len-2, target);//已经判断过最小元素不是target，对除该元素以外的数组进行二分查找
    	}else{//最小元素在中间，分两段进行二分查找
    		int index_left=binarySearch(nums, 0, min_index-1, target);
    		int index_right=binarySearch(nums, min_index+1, len-1, target);
    		if(index_left!=-1){
    			return index_left;
    		}
    		if(index_right!=-1){
    			return index_right;
    		}
    		return -1;
    	}
    }
    
    private static int getStartIndex(int[] nums,int begin,int end){//利用二分查找的思想，查找数组中最小元素的地址
    	int len=nums.length;
    	
		if(nums[0]<nums[1]&&nums[0]<nums[len-1]){//判断最小元素是不是第一个元素
			return 0;
		}else if(nums[len-1]<nums[0]&&nums[len-1]<nums[len-2]){//判断最小元素是不是最后一个元素
			return len-1;
		}else{
			int middle=(begin+end)>>1;
			if(middle!=0&&middle!=len-1&&nums[middle]<nums[middle-1]&&nums[middle]<nums[middle+1]){//middle对应元素比它两侧的元素都小，middle就是要找的最小元素
				return middle;
			}else if(middle==0&&nums[middle]<nums[len-1]&&nums[middle]<nums[middle+1]){
				return middle;
			}else if(middle==len-1&&nums[middle]<nums[middle-1]&&nums[middle]<nums[0]){
				return middle;
			}else if(nums[middle]<nums[0]){//middle对应元素比第一个元素小，证明最小元素在middle的左侧
				return getStartIndex(nums, begin, middle-1);
			}else{//middle对应元素比第一个元素小，证明最小元素在middle的右侧
				return getStartIndex(nums, middle+1, end);
			}
		}
	} 
	
	private static int binarySearch(int[] nums,int begin,int end,int target){//二分查找
		int middle=(begin+end)>>1;
		if(begin<=end){
			if(nums[middle]==target){
				return middle;
			}else if(nums[middle]>target){
				return binarySearch(nums, begin, middle-1, target);
			}else{
				return binarySearch(nums, middle+1, end, target);
			}
		}
		return -1;
	} 
}
