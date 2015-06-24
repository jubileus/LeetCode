package algorithms_31_40;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums={5,5,1};
//		int[] nums={3,2,1};
		nextPermutation(nums);
	}

    public static void nextPermutation(int[] nums) {
        if(nums.length<=1)//�����������ֻ��һ��Ԫ�أ�����������
        	return ;
        int length=nums.length;
        int left=length-2,right=length-1;//ָ������ָ��
        int target=-1;//��Ԫ�غ����Ԫ��Ϊ��������
        while(left>=0){//�Ӻ���ǰ�ҵ���һ��ʹ���鲻�ٽ����Ԫ��
        	if(nums[left]>=nums[right]){
        		left--;
        		right--;
        	}else{
        		target=left;
        		break;
        	}
        }
        if(target==-1){//�����ǽ������У���������һ������
        	Arrays.sort(nums);//�������Ϊ��������
        	return ;//�˳�����
        }
        int next=length-1;
        while(next>target){//�Ӻ���ǰ���ҵ�targetԪ�غ��һ����target���Ԫ��
        	if(nums[next]>nums[target])
        		break;
        	else
        		next--;
        }
        int tmp=nums[target];//����target��nextָ���Ӧ��Ԫ��
        nums[target]=nums[next];
        nums[next]=tmp;
        Arrays.sort(nums, target+1, length);//ʹtarget�������Ԫ�ر�Ϊ����
    }
    
}
