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
        	if(nums[middle]==target){//middle��ӦԪ�ص���target��ֱ�ӷ���middle
        		return middle;
        	}else if(nums[middle]>target){//middle��ӦԪ�ش���target������Ѱ��
        		j=middle-1;
        	}else{//middle��ӦԪ��С��target������Ѱ��
        		i=middle+1;
        	}
        }
        
        return i;
    }

	
//	//����һ��
//    public static int searchInsert(int[] nums, int target) {
//        int rs=binarySearch(nums, target, 0, nums.length-1);//�鿴target�Ƿ���������
//        if(rs==-1){
//        	return binaryInsert(nums, target, 0, nums.length-1);//target���������У�����Ҳ���λ��
//        }
//        return rs;
//    }
//    
//    private static int binaryInsert(int[]nums,int target,int begin,int end){
//    	int middle=(begin+end)>>1;
//    	if(begin<=end){
//    		if(nums[middle]<target){//middle��ӦԪ�ر�targetС��˵������λ����middle�ұ�
//    			if(middle+1>nums.length-1){//���middle�Ҳ಻����Ԫ�أ�middle+1���ǲ���λ��
//    				return middle+1;
//    			}
//    			if(nums[middle+1]>target){//���middle�Ҳ�����Ԫ�ر�target��Ļ���middle+1���ǲ���λ��
//    				return middle+1;
//    			}else{//��������Ѱ��
//    				return binaryInsert(nums, target, middle+1, end);
//    			}
//    		}else{//middle��ӦԪ�ر�target��˵������λ����middle���
//    			if(middle-1<0){//���middle��಻����Ԫ�صĻ���middle���ǲ���λ��
//    				return 0;
//    			}
//    			if(nums[middle-1]<target){//���middle�������Ԫ�ر�targetС�Ļ���middle���ǲ���λ��
//    				return middle;
//    			}else{//��������Ѱ��
//    				return binaryInsert(nums, target, begin, middle-1);
//    			}
//    		}
//    	}
//    	return 0;
//    }
//    
//    private static int binarySearch(int[]nums,int target,int begin,int end){//���ֲ���
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
