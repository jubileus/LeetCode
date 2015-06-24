package algorithms_11_20;


public class RomanToInteger {

	public static void main(String[] args) {
		String s="MCMXCVI";
		System.out.println(romanToInt(s));
	}

    public static int romanToInt(String s) {
        int num=0;
        int length=s.length();
        if(length==1)
        	return charToInt(s.charAt(0));
        for(int index=0;index<length-1;index++){
        	if(charToInt(s.charAt(index))<charToInt(s.charAt(index+1)))//是数字4，9，40，90，400，900等
        		num+=-charToInt(s.charAt(index));
    		else
        		num+=charToInt(s.charAt(index));
        }
    	num+=charToInt(s.charAt(length-1));//特殊处理最后一个字符
        return num;
    }
    
    private static int charToInt(char roman){
    	switch (roman) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
    }
}
