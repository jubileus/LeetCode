package algorithms_11_20;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s="]";
		System.out.println(isValid(s));
	}

    public static boolean isValid(String s) {
        boolean valid=true;
        Stack<Character> stack=new Stack<Character>();//��ʼ����ջ
        for(int i=0;i<s.length()&&valid;i++){
        	char current_item=s.charAt(i);//��ȡ��ǰ�ַ�
        	if(current_item=='('||current_item=='['||current_item=='{'){//���ַ���������ʱ���ַ���ջ
        		stack.push(current_item);
        	}else{//���ַ���������ʱ���ַ���ջ
        		if(stack.isEmpty()){//ջΪ�գ�֤����ƥ��
        			valid=false;
        			break;
        		}
        		char old_item=stack.pop();
        		switch (current_item) {//����ջ���ַ��뵱ǰ�ַ��Ƿ�ƥ��
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
        if(!stack.isEmpty())//������Ϻ�����ջ���գ�֤����ƥ��
        	valid=false;
        return valid;
    }
}
