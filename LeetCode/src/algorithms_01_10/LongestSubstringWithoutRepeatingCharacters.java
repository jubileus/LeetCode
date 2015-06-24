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
        for(int i=0;i<position.length;i++)//���ַ�������λ�ø�Ĭ��ֵ-1
        	position[i]=-1;
        while(cur < s.length()){//��ǰλ��С���ַ�������
            if(position[s.charAt(cur)] >= start)//���ַ���������Ӵ���
                start = position[s.charAt(cur)] + 1;//��ʼλ������Ϊ��ǰλ�õ���һ���ַ�  
            res = Math.max(cur-start+1, res);
            position[s.charAt(cur)] = cur;
            cur++;  
        }
        return res; 
    }
}
