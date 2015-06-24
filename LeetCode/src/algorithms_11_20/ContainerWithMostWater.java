package algorithms_11_20;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxArea(int[] height) {
        int max=0;
        int begin=0,end=height.length-1;//��ʼ�����˵��±�
        while(begin<end){
        	int volume=Math.min(height[begin], height[end])*(end-begin);
        	max=max<volume?volume:max;//�ж����ݻ��Ƿ����ԭ��������ݻ�
        	if(height[begin]<height[end])//�ж��Ǹ��߱Ƚ϶̣������ñ������ƽ�
        		begin++;
        	else
        		end--;
        }
        return max;
    }

//	//brute�ⷨ��ʱ�临�Ӷ�O(n2)��Ч�ʹ���
//	public int maxArea(int[] height) {
//        int max=0;
//        for(int i=0;i<height.length;i++){
//            for(int j=i+1;j<height.length-1;j++){
//                int volume=(j-i)*Math.min(height[i], height[j]);
//                if(max<volume)
//                	max=volume;
//            }
//        }
//        return max;
//    }
}
