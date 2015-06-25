package algorithms_31_40;

public class SearchForARange {

	public static void main(String[] args) {
		int[] nums={1};
		int target=1;
		int[] rs=searchRange(nums, target);
		System.out.println(rs[0]+"  "+rs[1]);
	}

    public static int[] searchRange(int[] nums, int target) {
        int[] rs=new int[2];
        rs[0]=rs[1]=-1;//初始化结果为-1，-1
        
        //寻找数组中是否有要寻找的元素
        int index=binarySearch(nums, 0, nums.length-1, target);
        if(index==-1){//数组中不存在target，直接返回
        	return rs;
        }else{
        	rs[0]=rs[1]=index;//将结果暂时赋值为index,index
        	
        	//向两端继续应用二分查找寻找target的最左和最右位置
        	int left_index=index-1;
        	int right_index=index+1;
        	int left_current=left_index;
        	int right_current=right_index;
        	boolean left_find=false;
        	boolean right_find=false;
        	
        	while(left_current!=-1){
        		left_current=binarySearch(nums, 0, left_current, target);
        		if(left_current==-1){
        			break;
        		}else{
        			left_index=left_current;
        			left_current--;
        			left_find=true;
        		}
        	}
        	while(right_current!=-1){
        		right_current=binarySearch(nums, right_current, nums.length-1, target);
        		if(right_current==-1){
        			break;
        		}else{
        			right_index=right_current;
        			right_current++;
        			right_find=true;
        		}
        	}
        	//寻找到最左或最右位置后，用left_index和right_index覆盖原先的结果
        	if(left_find){
        		rs[0]=left_index;
        	}
        	if(right_find){
        		rs[1]=right_index;
        	}
        }
        
        return rs;
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
