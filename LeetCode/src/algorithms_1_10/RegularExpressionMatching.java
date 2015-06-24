package algorithms_1_10;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
		//ab  a*b
	}

	//简化版
//	public static boolean isMatch(String s, String p) {
//		if(p.length()==0)//表达式p长度为0
//			return 0==s.length();
//		if(p.length()==1||p.charAt(1)!='*'){//p的长度为1是特例，p的第二个字符是*的时候也是特例
//			if(s.length()<1||(p.charAt(0)!='.'&&p.charAt(0)!=s.charAt(0)))//s是空串，或p与s的第一个字符不匹配
//				return false;
//			return isMatch(s.substring(1), p.substring(1));
//		}else{
//			int index=-1;//s的地址
//			while(index<s.length()&&(index<0||p.charAt(0)=='.'||s.charAt(index)==p.charAt(0))){//s的地址小于s的长度，或p的第一个字符与s的第index+1个字符匹配
//				if(isMatch(s.substring(index+1), p.substring(2)))//如果s的后续子串与p的后续子串匹配
//					return true;
//				index++;
//			}
//			return false;
//		}
//	}
	
	//易理解版
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0)//当p的长度为0时
			return s.length() == 0;
		if (p.length() == 1||p.charAt(1) != '*') {//p的长度等于1时，或第2个字符不是*时
			if (s.length() < 1)//s是空串时，返回false
				return false;
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))//判断第一个字符是否匹配
				return false;
			else //匹配剩余的字符串
				return isMatch(s.substring(1), p.substring(1));
		}else {//当第二个字符是*时，为复杂情况
			if (isMatch(s, p.substring(2))) //当*号没有匹配任何元素时
				return true;
			//当*号没有匹配1个或多个元素时
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
