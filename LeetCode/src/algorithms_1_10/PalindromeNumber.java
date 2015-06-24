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
        if (x < 0)//�����������ǻ�����
            return false;
        int len = 1;
        while (x / len >= 10) {//��ȡ���ֵ�λ������x=12321ʱlen=10000
            len *= 10;
        }
        while (x != 0) {
            int left = x / len;
            int right = x % 10;
            if (left != right)//��β���ȣ�����false
                return false;
            x = (x % len) / 10;//���ס�β����ȥ��
            len /= 100;//ÿ��ѭ������2λ����
        }
        return true;
    }

}
