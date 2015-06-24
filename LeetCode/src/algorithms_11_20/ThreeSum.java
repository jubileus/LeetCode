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
        Arrays.sort(nums);//�ȶ�������зǵݼ�����
        int length=nums.length;
        for(int i=0;i<length-2;i++){
        	if(i>0&&nums[i]==nums[i-1])//��ǰԪ����ǰһԪ����ͬ���ý���ǰһԪ����ͬ
        		continue;
        	find(nums,i+1,length-1,nums[i],rs);
        }
        return rs;
    }
    
    private static void find(int[] nums,int begin,int end,int target,List<List<Integer>> rs){
    	while(begin<end){
    		if(nums[begin]+nums[end]+target==0){//�ҵ���
    			List<Integer> tmp=new ArrayList<Integer>();
    			tmp.add(target);
    			tmp.add(nums[begin]);
    			tmp.add(nums[end]);
    			rs.add(tmp);//������ӵ������
    			while(begin<end&&nums[begin]==nums[begin+1])//��һԪ����nums[begin]��ͬ����Ҳ��ͬ
    				begin++;
    			while(begin<end&&nums[end]==nums[end-1])//ǰһԪ����nums[end]��ͬ����Ҳ��ͬ
    				end--;
    			begin++;
    			end--;
    		}else if(nums[begin]+nums[end]+target<0)//����֮��С��0��֤��nums[begin]̫С��begin++
    			begin++;
    		else//����֮�ʹ���0��֤��nums[end]̫��end--
    			end--;
    	}
    }
	
//    private static void quickSort(int[] nums,int low,int high){//��������
//    	if(low<high){
//    		int middle=getMiddle(nums, low, high);
//    		quickSort(nums,low,middle-1);
//    		quickSort(nums,middle+1,high);
//    	}
//    }
//    
//    private static int getMiddle(int[] nums,int low,int high){//��������ʱѰ�ҵ�ǰ����Ӧ���ڵ�λ��
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
