package algorithms_41_50;

public class FirstMissingPositive {

	public static void main(String[] args) {
//		int[] nums={-4,3,2,1,0,-2,4,7,9,10,-3};
		int[] nums={0};
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		for(int i=0;i<nums.length;i++){//˼·�ǽ���������1-nums.length֮������ַ��õ���ȷ��λ����
			while(nums[i]!=i+1){
				if(nums[i]<=0||nums[i]>=nums.length||nums[i]==nums[nums[i]-1]){//��nums[i]�Ǹ�������������鳤�ȣ�������ȷλ���ϵ�������ͬʱ
					break;
				}
				//���н���
				int tmp=nums[i];
				nums[i]=nums[nums[i]-1];
				nums[tmp-1]=tmp;
			}
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=i+1){
				return i+1;
			}
		}
		return nums.length+1;//������ǡ�ɶ���1-nums.length֮�������ʱ������nums.length+1
    }
}
