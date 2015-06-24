package algorithms_20_30;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend=-1010369383, divisor=-2147483648;
//		System.out.println(dividend/divisor);
		System.out.println(divide(dividend, divisor));
	}
	
    public static int divide(int dividend, int divisor) {
        if(divisor==1)//当除数为1时，返回dividend
        	return dividend;
        if(divisor==-1){//当除数为-1时，返回-dividend
        	int verify=Math.abs(dividend);
        	if(verify<0)//被除数Integer.MIN_VALUE，除-1后比Integer.MAX_VALUE大1，越界
        		return Integer.MAX_VALUE;
        	return -dividend;
        }
        if(dividend==0)//当被除数为0时，返回0
        	return 0;
        boolean negative=false;//判断结果的正负性
        if(dividend>0&&divisor<0||dividend<0&&divisor>0)//输入一正一负时，结果为负
        	negative=true;
        long m_dividend=Math.abs((long)dividend);//将取绝对值后的dividend，divisor存入long型的m_dividend，m_divisor
        long m_divisor=Math.abs((long)divisor);
        if(m_dividend<m_divisor)//当m_dividend<m_divisor，被除数被除数小，返回0
        	return 0;
        long current=m_divisor,count=1;
        while(current<m_dividend){//将current放大至大于m_dividend
        	current<<=1;//current<=dividend时，current与count左移一位(即current与count乘以2)
        	count<<=1;
        }
        long result=0;
        while(current>=m_divisor){//当current>=m_divisor时，进入循环
        	while(current<=m_dividend){//当current<=m_dividend时，将count累加至result，并将m_dividend减去current;
        		result+=count;
        		m_dividend-=current;
        	}
        	current>>=1;//current与count右移一位(即current与count除以2)
        	count>>=1;
        }
        if(result>Integer.MAX_VALUE)//当结果大于Integer.MAX_VALUE时，返回Integer.MAX_VALUE
        	return Integer.MAX_VALUE;
        if(negative)//根据正负性，返回相应结果
        	return -(int)result;
        return (int)result;
    }
}
