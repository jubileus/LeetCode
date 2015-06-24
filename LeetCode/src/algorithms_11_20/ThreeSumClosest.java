package algorithms_11_20;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums={-1,2,1,-4};
		int target=1;
		System.out.println(threeSumClosest(nums, target));
	}

    public static int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);//��nums���зǵݼ�����
        int length=nums.length;
        int closest=0;
        boolean closestIsNull=true;//�Ƿ��ǵ�һ�αȽ�
        for(int i=0;i<length-2;i++){
        	if(i!=0&&nums[i]==nums[i-1])
        		continue;
        	int low=i+1,high=length-1;//��������Ŀ��ֵ����
        	while(low<high){
        		int sum=nums[i]+nums[low]+nums[high];//��������֮��
        		if(closestIsNull){//��һ�ν��бȽ�
        			closest=sum;
        			closestIsNull=false;
        		}
        		if(Math.abs(sum-target)<Math.abs(closest-target))//��ǰ����֮�ͱ�֮ǰ����ӽ�ֵ�����
        			closest=sum;
        		if(sum<target){//sum<target��˵��nums[low]̫С��low++
        			while(low<high&&nums[low]==nums[low+1])
        				low++;
        			low++;
        		}else{//sum>target��˵��nums[high]̫��high--
        			while(low<high&&nums[high]==nums[high-1])
        				high--;
        			high--;
        		}
        	}
        }
        return closest;
    }
    
}
