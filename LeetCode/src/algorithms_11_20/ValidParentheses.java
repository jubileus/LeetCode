package algorithms_11_20;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s="]";
		System.out.println(isValid(s));
	}

    public static boolean isValid(String s) {
        boolean valid=true;
        Stack<Character> stack=new Stack<Character>();//初始化堆栈
        for(int i=0;i<s.length()&&valid;i++){
        	char current_item=s.charAt(i);//读取当前字符
        	if(current_item=='('||current_item=='['||current_item=='{'){//当字符是左括号时，字符入栈
        		stack.push(current_item);
        	}else{//当字符是右括号时，字符出栈
        		if(stack.isEmpty()){//栈为空，证明不匹配
        			valid=false;
        			break;
        		}
        		char old_item=stack.pop();
        		switch (current_item) {//检测出栈的字符与当前字符是否匹配
				case ')':
					if(old_item!='(')
						valid=false;
					break;
				case ']':
					if(old_item!='[')
						valid=false;
					break;
				case '}':
					if(old_item!='{')
						valid=false;
					break;
				}
        	}
        }
        if(!stack.isEmpty())//遍历完毕后，若堆栈不空，证明不匹配
        	valid=false;
        return valid;
    }
}
