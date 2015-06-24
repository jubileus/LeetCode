package algorithms_1_10;

public class StringToInteger {

	public static void main(String[] args) {
		String str="-2147483649";
		System.out.println(myAtoi(str));
	}

    public static int myAtoi(String str) {
    	if(str==null)//空字符串
    		return 0;
    	str=str.trim();//除去开头结尾的空格
    	if(str.length()==0)//除去开头结尾的空格后字符串为空
    		return 0;
    	if(str.charAt(0)=='+'||str.charAt(0)=='-'||Character.isDigit(str.charAt(0))){//第一位字符是正负号或数字
    		if(str.charAt(0)=='-')//第一位是负号
    			if(str.length()==1)//字符串长度为1，说明输入的字符串是"-"，直接返回0
    				return 0;
    			else 
    				if(Character.isDigit(str.charAt(1)))//符号后的第一位是数字，开始跳过符号读取后续字符
    					return -1*getNumber(str.substring(1),true);
    				else//符号后的第一位不是数字，直接返回0
    					return 0;
        	else if(str.charAt(0)=='+')//第一位是正号
        		if(str.length()==1)//字符串长度为1，说明输入的字符串是"+"，直接返回0
    				return 0;
    			else 
    				if(Character.isDigit(str.charAt(1)))//符号后的第一位是数字，开始跳过符号读取后续字符
    					return getNumber(str.substring(1),false);
    				else//符号后的第一位不是数字，直接返回0
    					return 0;
        	else//第一位是整数，且不带正号
        		return getNumber(str,false);
    	}else{//第一位不是正负号或数字
    		return 0;
    	}
    }
    
    private static int getNumber(String str,boolean isNegative){//逐位读取字符，知道读到结束或遇到第一个非数字字符
    	long rs=0;
    	for(int i=0;i<str.length();i++){
    		if(Character.isDigit(str.charAt(i))){//字符是数字字符，继续读取
    			rs=10*rs+str.charAt(i)-'0';
    			if(rs>Integer.MAX_VALUE&&!isNegative)
        			return Integer.MAX_VALUE;
        		else if(-1*rs<Integer.MIN_VALUE&&isNegative)
        			return Integer.MIN_VALUE;
    		}else//字符是非数字字符，停止读取
    			break;
    	}
    	return (int)rs;
    }
}
