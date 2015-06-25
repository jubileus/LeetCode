package algorithms_31_40;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums={5,1,2,3,4};
		System.out.println(search(nums, 4));
	}

    public static int search(int[] nums, int target) {
    	int len=nums.length;
    	
    	if(len==0){//����Ϊ�գ�ֱ�ӷ���-1
    		return -1;
    	}
    	
    	if(len==1){//����ֻ��һ��Ԫ�أ�ֱ�ӽ����ж�
    		return nums[0]==target?0:-1;
    	}
    	
    	//������СԪ�صĵ�ַ
    	int min_index=getStartIndex(nums, 0, len-1);
    	
    	//�ж���СԪ���ǲ���Ҫ�ҵ�target
    	if(nums[min_index]==target){
    		return min_index;
    	}
    	
    	//��λ�ý��ж��ֲ���
    	if(min_index==0){//��СԪ���ǵ�һ��Ԫ�أ����鱾������
    		return binarySearch(nums, 0, len-1, target);//ֱ�Ӷ��ֲ���
    	}else if(min_index==len-1){//��СԪ�������һ��Ԫ��
    		return binarySearch(nums, 0, len-2, target);//�Ѿ��жϹ���СԪ�ز���target���Գ���Ԫ�������������ж��ֲ���
    	}else{//��СԪ�����м䣬�����ν��ж��ֲ���
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
    
    private static int getStartIndex(int[] nums,int begin,int end){//���ö��ֲ��ҵ�˼�룬������������СԪ�صĵ�ַ
    	int len=nums.length;
    	
		if(nums[0]<nums[1]&&nums[0]<nums[len-1]){//�ж���СԪ���ǲ��ǵ�һ��Ԫ��
			return 0;
		}else if(nums[len-1]<nums[0]&&nums[len-1]<nums[len-2]){//�ж���СԪ���ǲ������һ��Ԫ��
			return len-1;
		}else{
			int middle=(begin+end)>>1;
			if(middle!=0&&middle!=len-1&&nums[middle]<nums[middle-1]&&nums[middle]<nums[middle+1]){//middle��ӦԪ�ر��������Ԫ�ض�С��middle����Ҫ�ҵ���СԪ��
				return middle;
			}else if(middle==0&&nums[middle]<nums[len-1]&&nums[middle]<nums[middle+1]){
				return middle;
			}else if(middle==len-1&&nums[middle]<nums[middle-1]&&nums[middle]<nums[0]){
				return middle;
			}else if(nums[middle]<nums[0]){//middle��ӦԪ�رȵ�һ��Ԫ��С��֤����СԪ����middle�����
				return getStartIndex(nums, begin, middle-1);
			}else{//middle��ӦԪ�رȵ�һ��Ԫ��С��֤����СԪ����middle���Ҳ�
				return getStartIndex(nums, middle+1, end);
			}
		}
	} 
	
	private static int binarySearch(int[] nums,int begin,int end,int target){//���ֲ���
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
