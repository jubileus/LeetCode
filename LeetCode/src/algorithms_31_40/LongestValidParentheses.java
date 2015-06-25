package algorithms_31_40;

public class LongestValidParentheses {

	public static void main(String[] args) {
		//算法思路参见：http://blog.csdn.net/a83610312/article/details/8639790
		String s="((()))";
//		longestValidParentheses(s);
		
		System.out.println(longestValidParentheses(s));
	}

    public static int longestValidParentheses(String s) {
    	int len=s.length();
    	
    	if(len<=1)//当数组元素小于等于1时，直接返回0
    		return 0;
    	
        int[] longest=getLongest(s);//获取最远匹配')'的位置数组
        
        int max=0;//最长匹配子串长度
        int cur=0;//当前匹配子串长度
        for(int i=1;i<len+2;){//根据longest数组，获取最长的匹配子串长度
        	if(longest[i]==-1){
        		max=Math.max(max, cur);
        		i++;
        		cur=0;//cur清零，准备扫描后续子串
        	}else{
        		cur+=longest[i]-i+1;
        		i=longest[i]+1;
        	}
        }
        
        return max;
    }
    
    private static int[] getLongest(String s){//获取最远匹配')'的位置数组
    	int len=s.length();
    	
    	StringBuilder builder=new StringBuilder();//在s的前后添加#字符，方便省略后续对越界的判断
    	builder.append("#");
    	builder.append(s);
    	builder.append("#");
    	String str=builder.toString();
    	
    	int[] rs=new int[len+2];//用-1初始化结果数组
    	for(int i=0;i<len+2;i++){
    		rs[i]=-1;
    	}
    	
    	for(int i=len;i>0;i--){
    		if(str.charAt(i)=='('){//由于已经默认给'#'和')'对应的位置赋值为-1，此处仅需处理字符'('
    			int j=i+1;//j表示i的右侧毗邻元素
    			while(str.charAt(j)=='('&&rs[j]!=-1){//当j对应元素为'('且该位置的最远匹配')'结果不为-1时，j的值继续后移
    				j=rs[j]+1;
    			}
    			if(str.charAt(j)==')'){
    				rs[i]=j;
    			}
    		}
    	}
    	
    	return rs;
    }
}
