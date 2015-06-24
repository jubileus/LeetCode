package algorithms_01_10;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s="abcabcbb";
		System.out.println("length--->"+lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null || s.isEmpty()==true)  
            return 0;  
        int res = 0;  
        int start = 0, cur = 0;  
        int position[] = new int[128];  
        for(int i=0;i<position.length;i++)//给字符最后出现位置赋默认值-1
        	position[i]=-1;
        while(cur < s.length()){//当前位置小于字符串长度
            if(position[s.charAt(cur)] >= start)//该字符出现在最长子串中
                start = position[s.charAt(cur)] + 1;//起始位置设置为当前位置的下一个字符  
            res = Math.max(cur-start+1, res);
            position[s.charAt(cur)] = cur;
            cur++;  
        }
        return res; 
    }
}
