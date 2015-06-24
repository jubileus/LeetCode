package algorithms_21_30;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums={1,1,2,2,2,3,4,5};
		removeDuplicates(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]+" ");
		}
	}

    public static int removeDuplicates(int[] nums) {
        int length=nums.length;//��ȡδȥ�ص�����Ԫ�ظ���
        if(length<=1)//����Ԫ�ز�����1ʱ��ֱ�ӷ��ص�ǰ����Ԫ�صĸ���
        	return nums.length;
        int left=0,right=1;//��ʼ������ָ��
        while(right<nums.length){//����ָ��С��nums.lengthʱ��˵������û�б������
        	if(nums[left]==nums[right]){//������ָ���ӦԪ�����ʱ��֤���ҵ����ظ�Ԫ��
        		length--;//������ظ�����-1
        		right++;//��ָ������һ����λ
        	}else{//������ָ���ӦԪ���಻��ʱ��֤�������ظ�Ԫ��
        		nums[left+1]=nums[right];//����ָ����Ҳ�Ԫ��=��ǰ��ָ���ӦԪ��
        		right++;//��ָ������һ����λ
        		left++;//��ָ������һ����λ
        	}
        }
        return length;//����ȥ�غ�����鳤��
    }
}
