package algorithms_1_10;

public class StringToInteger {

	public static void main(String[] args) {
		String str="-2147483649";
		System.out.println(myAtoi(str));
	}

    public static int myAtoi(String str) {
    	if(str==null)//���ַ���
    		return 0;
    	str=str.trim();//��ȥ��ͷ��β�Ŀո�
    	if(str.length()==0)//��ȥ��ͷ��β�Ŀո���ַ���Ϊ��
    		return 0;
    	if(str.charAt(0)=='+'||str.charAt(0)=='-'||Character.isDigit(str.charAt(0))){//��һλ�ַ��������Ż�����
    		if(str.charAt(0)=='-')//��һλ�Ǹ���
    			if(str.length()==1)//�ַ�������Ϊ1��˵��������ַ�����"-"��ֱ�ӷ���0
    				return 0;
    			else 
    				if(Character.isDigit(str.charAt(1)))//���ź�ĵ�һλ�����֣���ʼ�������Ŷ�ȡ�����ַ�
    					return -1*getNumber(str.substring(1),true);
    				else//���ź�ĵ�һλ�������֣�ֱ�ӷ���0
    					return 0;
        	else if(str.charAt(0)=='+')//��һλ������
        		if(str.length()==1)//�ַ�������Ϊ1��˵��������ַ�����"+"��ֱ�ӷ���0
    				return 0;
    			else 
    				if(Character.isDigit(str.charAt(1)))//���ź�ĵ�һλ�����֣���ʼ�������Ŷ�ȡ�����ַ�
    					return getNumber(str.substring(1),false);
    				else//���ź�ĵ�һλ�������֣�ֱ�ӷ���0
    					return 0;
        	else//��һλ���������Ҳ�������
        		return getNumber(str,false);
    	}else{//��һλ���������Ż�����
    		return 0;
    	}
    }
    
    private static int getNumber(String str,boolean isNegative){//��λ��ȡ�ַ���֪������������������һ���������ַ�
    	long rs=0;
    	for(int i=0;i<str.length();i++){
    		if(Character.isDigit(str.charAt(i))){//�ַ��������ַ���������ȡ
    			rs=10*rs+str.charAt(i)-'0';
    			if(rs>Integer.MAX_VALUE&&!isNegative)
        			return Integer.MAX_VALUE;
        		else if(-1*rs<Integer.MIN_VALUE&&isNegative)
        			return Integer.MIN_VALUE;
    		}else//�ַ��Ƿ������ַ���ֹͣ��ȡ
    			break;
    	}
    	return (int)rs;
    }
}
