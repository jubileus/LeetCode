package algorithms_41_50;

public class TrappingRainWater {

	public static void main(String[] args) {
		//�ο���http://www.cnblogs.com/springfor/p/3877101.html
		int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

    public static int trap(int[] height) {
    	int len=height.length;
    	if(len==0){
    		return 0;
    	}
    	int[] max_left=new int[len];
    	int[] max_right=new int[len];
    	
    	int tmp_left=height[0];
    	int tmp_right=height[len-1];
    	max_left[0]=tmp_left;
    	max_right[len-1]=tmp_right;
    	
        for(int i=1;i<len;i++){
        	//��i��������ɨ��������
        	if(height[i]>tmp_left){
        		tmp_left=height[i];
        	}
        	max_left[i]=tmp_left;
        	//��j��������ɨ������ұ�
        	int j=len-1-i;
        	if(height[j]>tmp_right){
        		tmp_right=height[j];
        	}
        	max_right[j]=tmp_right;
        }
        
        int[] min=new int[len];//�����ͬλ����max_left��max_right�н�С��һ��
        for(int i=0;i<len;i++){
        	min[i]=Math.min(max_left[i], max_right[i]);
        }
        
        //��min[i]-height[i],ֵΪ��˵����λ�û��ˮ���ۼӽ����
        int volume=0;
        for(int i=0;i<len;i++){
        	int tmp=min[i]-height[i];
        	if(tmp>0){
        		volume+=tmp;
        	}
        }
        return volume;
    }
}
