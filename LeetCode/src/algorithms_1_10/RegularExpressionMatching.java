package algorithms_1_10;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
		//ab  a*b
	}

	//�򻯰�
//	public static boolean isMatch(String s, String p) {
//		if(p.length()==0)//���ʽp����Ϊ0
//			return 0==s.length();
//		if(p.length()==1||p.charAt(1)!='*'){//p�ĳ���Ϊ1��������p�ĵڶ����ַ���*��ʱ��Ҳ������
//			if(s.length()<1||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))//s�ǿմ�����p��s�ĵ�һ���ַ���ƥ��
//				return false;
//			return isMatch(s.substring(1), p.substring(1));
//		}else{
//			int index=-1;//s�ĵ�ַ
//			while(index<s.length()&&(index<0||p.charAt(0)=='.'||s.charAt(index)==p.charAt(0))){//s�ĵ�ַС��s�ĳ��ȣ���p�ĵ�һ���ַ���s�ĵ�index+1���ַ�ƥ��
//				if(isMatch(s.substring(index+1), p.substring(2)))//���s�ĺ����Ӵ���p�ĺ����Ӵ�ƥ��
//					return true;
//				index++;
//			}
//			return false;
//		}
//	}
	
	//������
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0)//��p�ĳ���Ϊ0ʱ
			return s.length() == 0;
		if (p.length() == 1||p.charAt(1) != '*') {//p�ĳ��ȵ���1ʱ�����2���ַ�����*ʱ
			if (s.length() < 1)//s�ǿմ�ʱ������false
				return false;
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))//�жϵ�һ���ַ��Ƿ�ƥ��
				return false;
			else //ƥ��ʣ����ַ���
				return isMatch(s.substring(1), p.substring(1));
		}else {//���ڶ����ַ���*ʱ��Ϊ�������
			if (isMatch(s, p.substring(2))) //��*��û��ƥ���κ�Ԫ��ʱ
				return true;
			//��*��û��ƥ��1������Ԫ��ʱ
			int i = 0;
			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
}
