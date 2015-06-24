package algorithms_01_10;

public class ReverseInteger {

	public static void main(String[] args) {
		int x=-2147483648;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		String number=String.valueOf(x);
		StringBuilder builder=new StringBuilder();
		if(x>=0){
			for(int i=number.length()-1;i>=0;i--){
				builder.append(number.charAt(i));
	        }
		}else{
			builder.append("-");
			for(int i=number.length()-1;i>=1;i--){
				builder.append(number.charAt(i));
	        }
		}
		try {
			return Integer.parseInt(builder.toString());
		} catch (NumberFormatException e) {
			return 0;//溢出
		}
		
//		//方法二
//		long reverse = 0;
//        while(x != 0){
//        	reverse = reverse * 10 + x % 10;
//        	if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)//溢出
//        		return 0;
//        	x = x / 10;
//        }
//        return (int)reverse;
    }
}
