package algorithms_1_10;
import java.util.HashMap;


public class TwoSum {

	public static void main(String[] args) {
		int[] nums={0,4,3,0};
		int target=0;
		
		int[] rs=twoSum(nums, target);
		System.out.println(rs[0]+" "+rs[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
        int[] rs=new int[2];
        HashMap<Integer, Integer> numbers=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(numbers.containsKey(target-nums[i])){
        		rs[0]=numbers.get(target-nums[i]);
        		rs[1]=i+1;
        		return rs;
        	}
        	if(numbers.get(nums[i])==null)
        		numbers.put(nums[i], i+1);
        }
        return rs;
    }
	
}
