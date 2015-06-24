package algorithms_01_10;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s="PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}

	public static String convert(String s, int numRows) {
		if(s==null||s.length()==0||numRows<0)
			return "";
		else if(numRows==1)
			return s;
		int len=2*numRows-2;
		StringBuilder builder=new StringBuilder();
        for(int i=0;i<numRows;i++){//循环从0-i给该行赋值
        	for(int j=i;j<s.length();j+=len){
        		builder.append(s.charAt(j));
        		if(i!=0&&i!=numRows-1){//不是第一行和最后一行，处理斜线上的元素
        			int index=j+len-2*i;
        			if(index<s.length())
        				builder.append(s.charAt(index));
        		}
        	}
        }
        return builder.toString();
    }
}
