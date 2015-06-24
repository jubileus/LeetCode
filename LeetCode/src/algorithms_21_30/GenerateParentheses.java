package algorithms_21_30;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n=3;
		List<String> rs=generateParenthesis(n);
		for(int i=0;i<rs.size();i++){
			System.out.println(rs.get(i));
		}
	}

    public static List<String> generateParenthesis(int n) {
    	if(n<1)//当n<1时，直接返回null
    		return null;
    	List<String> rs=new ArrayList<String>();
    	String tmp=new String();
    	doDFS(rs, tmp, n, n);//应用深度优先算法，寻找合法括号字符串
    	return rs;
    }
    
    private static void doDFS(List<String> rs,String tmp,int left,int right){
    	if(left>right)//左括号比右括号多，一定不是合法括号字符串
    		return;
    	if(right==0&&right==0)//用完全部括号，将结果添加到结果集中
    		rs.add(tmp);
    	if(left>0)//左括号没用完，使用左括号
    		doDFS(rs, tmp+"(", left-1, right);
		if(right>0)//右括号没用完，使用右括号
    		doDFS(rs, tmp+")", left, right-1);
    }
}
