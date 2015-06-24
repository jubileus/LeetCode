package algorithms_11_20;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxArea(int[] height) {
        int max=0;
        int begin=0,end=height.length-1;//初始化两端的下标
        while(begin<end){
        	int volume=Math.min(height[begin], height[end])*(end-begin);
        	max=max<volume?volume:max;//判断新容积是否大于原来的最大容积
        	if(height[begin]<height[end])//判断那个边比较短，并将该边向里推进
        		begin++;
        	else
        		end--;
        }
        return max;
    }

//	//brute解法，时间复杂度O(n2)，效率过低
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
