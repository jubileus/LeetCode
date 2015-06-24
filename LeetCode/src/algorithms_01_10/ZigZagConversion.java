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
        for(int i=0;i<numRows;i++){//ѭ����0-i�����и�ֵ
        	for(int j=i;j<s.length();j+=len){
        		builder.append(s.charAt(j));
        		if(i!=0&&i!=numRows-1){//���ǵ�һ�к����һ�У�����б���ϵ�Ԫ��
        			int index=j+len-2*i;
        			if(index<s.length())
        				builder.append(s.charAt(index));
        		}
        	}
        }
        return builder.toString();
    }
}
