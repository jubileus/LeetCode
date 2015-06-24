package algorithms_11_20;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(3999));
	}

	public static String intToRoman(int num) {
		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        StringBuilder result = new StringBuilder();  
        for (int i = 0; i < values.length; i++) {  
            while (num >= values[i]) {  
                num -= values[i];  
                result.append(numerals[i]);  
            }  
        }  
        return result.toString();   
    }
}
