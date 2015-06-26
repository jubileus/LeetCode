package algorithms_41_50;

public class TrappingRainWater {

	public static void main(String[] args) {
		//参考：http://www.cnblogs.com/springfor/p/3877101.html
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
        	//用i从左往右扫描最高左边
        	if(height[i]>tmp_left){
        		tmp_left=height[i];
        	}
        	max_left[i]=tmp_left;
        	//用j从右往左扫描最高右边
        	int j=len-1-i;
        	if(height[j]>tmp_right){
        		tmp_right=height[j];
        	}
        	max_right[j]=tmp_right;
        }
        
        int[] min=new int[len];//存放相同位置上max_left和max_right中较小的一个
        for(int i=0;i<len;i++){
        	min[i]=Math.min(max_left[i], max_right[i]);
        }
        
        //用min[i]-height[i],值为正说明该位置会存水，累加结果。
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
