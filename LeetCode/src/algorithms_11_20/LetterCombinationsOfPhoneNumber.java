package algorithms_11_20;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {

	}

    public List<String> letterCombinations(String digits) {
        List<String> rs=new ArrayList<String>();
        if(digits==null||digits.length()==0)//digits�ǿմ�
        	return rs;
        String[] characters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] tmp=new char[digits.length()];
        findByDFS(characters,tmp,0,digits,rs);
        return rs;
    }
    
    private static void findByDFS(String[] characters,char[] tmp,int index,String digits,List<String> rs){
    	if(index==digits.length()){//�����ַ���������ϣ����м�����������
    		rs.add(new String(tmp));
    		return;
    	}
    	char current=digits.charAt(index);//��ȡ��ǰ�����ַ����ĵ�index���ַ�
    	for(int i=0;i<characters[current-'0'].length();i++){
    		tmp[index]=characters[current-'0'].charAt(i);
    		findByDFS(characters, tmp, index+1, digits, rs);
    	}
    }
}
