package algorithms_11_20;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {

	}

    public List<String> letterCombinations(String digits) {
        List<String> rs=new ArrayList<String>();
        if(digits==null||digits.length()==0)//digits是空串
        	return rs;
        String[] characters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] tmp=new char[digits.length()];
        findByDFS(characters,tmp,0,digits,rs);
        return rs;
    }
    
    private static void findByDFS(String[] characters,char[] tmp,int index,String digits,List<String> rs){
    	if(index==digits.length()){//输入字符串遍历完毕，将中间结果存入结果集
    		rs.add(new String(tmp));
    		return;
    	}
    	char current=digits.charAt(index);//获取当前输入字符串的第index个字符
    	for(int i=0;i<characters[current-'0'].length();i++){
    		tmp[index]=characters[current-'0'].charAt(i);
    		findByDFS(characters, tmp, index+1, digits, rs);
    	}
    }
}
