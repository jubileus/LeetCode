package algorithms_41_50;

import java.nio.file.attribute.AclEntry.Builder;

public class MultiplyStrings {

	public static void main(String[] args) {
//		//测试两个个位数相加
//		int num1=5,num2=5;
//		int[] rs=addTwo(num1, num2);
//		System.out.println(rs[0]+"  "+rs[1]);
		
//		//测试两个个位数相乘
//		int num1=0,num2=5;
//		int[] rs=multiTwo(num1, num2);
//		System.out.println(rs[0]+"  "+rs[1]);
		
//		char num1='1';
//		char num2='2';
//		
//		int sum=Integer.parseInt(String.valueOf(num1))+Integer.parseInt(String.valueOf(num2));
		
//		StringBuilder builder=new StringBuilder();
//		builder.append("30");
//		multiTwo('9', '2', builder);
//		System.out.println("builder--->"+builder.toString());
		
		String num1="334";
		String num2="25";
//		System.out.println(num1.charAt(0));
//		multiply(num1, num2);
		System.out.println(multiply(num1, num2));
	}

    public static String multiply(String num1, String num2) {
    	if(num1.equals("0")||num2.equals("0")){
    		return "0";
    	}
    	
        //模拟手动乘法
    	int len1=num1.length();
    	int len2=num2.length();
    	String result="0";
    	StringBuilder zero=new StringBuilder();
    	for(int i=len2-1;i>=0;i--){
			StringBuilder builder=new StringBuilder();
			int last_quotient=0;
        	for(int j=len1-1;j>=0;j--){
        		last_quotient=multiTwo(num1.charAt(j), num2.charAt(i),last_quotient, builder);
        	}
        	if(last_quotient>0){
        		builder.insert(0, last_quotient);
        	}
        	builder.append(zero.toString());
        	zero.append("0");
        	//本轮的加数与上一轮结果相加
        	result=addTwoNumber(builder.toString(), result);
        }
    	return result;
    }
    
    private static String addTwoNumber(String number1,String number2){
    	int len1=number1.length();
    	int len2=number2.length();
    	int max=Math.max(len1, len2);
    	int min=Math.min(len1, len2);
    	
    	int zero_count=max-min;
    	StringBuilder zero=new StringBuilder();
    	for(int i=zero_count;i>0;i--){
    		zero.append("0");
    	}
    	//将两个数字的位数统一
    	if(len1>len2){
    		number2=zero.toString()+number2;
    	}else{
    		number1=zero.toString()+number1;
    	}
    	int index=max-1;
    	StringBuilder builder=new StringBuilder();
    	int last_quotient=0;
    	while(index>=0){
    		last_quotient=addTwo(number1.charAt(index), number2.charAt(index), last_quotient, builder);
        	index--;
    	}
    	if(last_quotient>0){
    		builder.insert(0, last_quotient);
    	}
    	return builder.toString();
    }
    
    private static int multiTwo(char num1,char num2,int last_quotient,StringBuilder builder){
    	int sum=toInt(num1)*toInt(num2)+last_quotient;
    	int remainder=sum%10;//余数
    	int quotient=sum/10;//商
    	builder.insert(0,toString(remainder));
    	return quotient;
    }
    
    private static int addTwo(char num1,char num2,int last_quotient,StringBuilder builder){
    	int sum=toInt(num1)+toInt(num2)+last_quotient;
    	int remainder=sum%10;//余数
    	int quotient=sum/10;//商
    	builder.insert(0,toString(remainder));
    	return quotient;
    }
    
    private static int toInt(char num){
    	return Integer.parseInt(String.valueOf(num));
    }
    
    private static String toString(int num){
    	return String.valueOf(num);
    }
    
}
