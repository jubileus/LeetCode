package algorithms_01_10;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s="abbcaacbbacbcb";
		System.out.println("rs--->"+longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
        if(s==null||s.length()==0){//空字符串
        	return null;
        }else if(s.length()==1){//字符串长度为1
        	return s;
        }else{//字符串长度大于1
        	String longest=s.substring(0, 1);
        	for(int i=0;i<s.length()-1;i++){
        		String tmp=getLongestSubstring(s,i,i);
        		if(longest.length()<tmp.length())
        			longest=tmp;
        		tmp=getLongestSubstring(s,i,i+1);
        		if(longest.length()<tmp.length())
        			longest=tmp;
        	}
        	return longest;
        }
    }
	
	//获取以index_1,index_2为中心的最长回文串
	private static String getLongestSubstring(String s,int index_1,int index_2) {
        while(index_1>=0&&index_2<=s.length()-1&&s.charAt(index_1)==s.charAt(index_2)){
        	index_1--;
        	index_2++;
        }
        return s.substring(index_1+1, index_2);
    }
}
