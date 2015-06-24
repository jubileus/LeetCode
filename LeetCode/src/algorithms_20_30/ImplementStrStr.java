package algorithms_20_30;

public class ImplementStrStr {

	public static void main(String[] args) {
		//KMP算法，可参考：http://kb.cnblogs.com/page/176818/与http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
		String haystack="mississippi";
		String needle="issis";
		System.out.println("location--->"+strStr(haystack, needle));
	}

	
    public static int strStr(String haystack, String needle) {
        int len_haystack=haystack.length(),len_needle=needle.length();//获取两个字符串的长度
        if(len_haystack<len_needle)//当needle长度大于haystack时，一定不匹配
        	return -1;
        if(len_needle==0)//当needle为空字符串时，一定匹配
        	return 0;
        int i=0;
        int[] next=getNext(needle);//获取KMP算法中的next[]
        while(i<=len_haystack-len_needle){//当剩余子串个数不足匹配时，如果此时还未找到匹配子串，则跳出循环
        	boolean found=true;//标志位默认置为true
        	for(int j=0;j<len_needle;j++){//循环检测needle的每个字符
        		if(haystack.charAt(i)!=needle.charAt(0)){//第一个字符就不匹配
        			i++;//i向前移动一个位置
        			found=false;
        			break;
        		}else if(haystack.charAt(i+j)!=needle.charAt(j)){//后续字符不匹配
        			i+=j-next[j-1];//向前移位，移位公式为：移动位数 = 已匹配的字符数 - 最后一个匹配字符的部分匹配值
        			found=false;
        			break;
        		}
        	}
        	if(found)//从第i个字符开始的子串是匹配的，i就是第一个匹配的位置
        		return i;
        }
        return -1;//没有找到匹配的字符串，返回-1
    }
    
    public static int[] getNext(String needle) {//KMP算法，计算needle的每个字符的部分匹配值，部分匹配值是needle最大相同前、后缀的长度
    	int length=needle.length();
    	int[] next=new int[length];
    	next[0]=0;//第一个字符的部分匹配值一定为0
    	for(int i=1;i<length;i++){
    		int index=next[i-1];//要对比的位置为上一个元素的部分匹配值
    		while(index>0&&needle.charAt(index)!=needle.charAt(i))//当该匹配值>0时，查找新的要对比的位置
    			index=next[index-1];
    		if(needle.charAt(index)==needle.charAt(i))//当第i个字符与第index个字符相同时，该字符的部分匹配值是上一个字符部分匹配值+1
    			next[i]=next[i-1]+1;
    		else
    			next[i]=0;//否则，最大匹配值为0
    	}
    	return next;
    }
}
