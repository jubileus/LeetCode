package algorithms_21_30;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums={1,3,4,2,5,2,3,7};
		int val=2;
		System.out.println(removeElement(nums, val));
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}

    public static int removeElement(int[] nums, int val) {
    	int len=nums.length;//��ȡ��ʼ���鳤��
    	int length=nums.length;//��ȡ�����ܳ���
    	int left=0,right=0;//��ʼ������ָ��
        while(right<length){//����ָ��С��lengthʱ��δ�������
        	if(nums[right]==val){//��nums[right]==valʱ���ҵ���Ŀ��Ԫ��
        		len--;//���ظ�����-1
        	}else{
        		nums[left]=nums[right];//����Ŀ��Ԫ�ط����ڶ��е���ȷλ��
        		left++;//��ָ������һ����λ
        	}
        	right++;//��ָ������һ����λ
        }
        return len;//���ط��ظ����鳤��
    }
}
