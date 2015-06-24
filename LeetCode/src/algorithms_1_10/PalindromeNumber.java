package algorithms_1_10;

public class PalindromeNumber {

	public static void main(String[] args) {
		int x=12321;
		if(isPalindrome(x))
			System.out.println("yes");
		else 
			System.out.println("no");
	}
	
	public static boolean isPalindrome(int x) {
        if (x < 0)//负数不可能是回文数
            return false;
        int len = 1;
        while (x / len >= 10) {//获取数字的位数，如x=12321时len=10000
            len *= 10;
        }
        while (x != 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right)//首尾不等，返回false
                return false;
            x = (x % len) / 10;//将首、尾数字去除
            len /= 100;//每次循环减少2位数字
        }
        return true;
    }

}
