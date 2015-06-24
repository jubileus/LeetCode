package algorithms_20_30;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend=-1010369383, divisor=-2147483648;
//		System.out.println(dividend/divisor);
		System.out.println(divide(dividend, divisor));
	}
	
    public static int divide(int dividend, int divisor) {
        if(divisor==1)//������Ϊ1ʱ������dividend
        	return dividend;
        if(divisor==-1){//������Ϊ-1ʱ������-dividend
        	int verify=Math.abs(dividend);
        	if(verify<0)//������Integer.MIN_VALUE����-1���Integer.MAX_VALUE��1��Խ��
        		return Integer.MAX_VALUE;
        	return -dividend;
        }
        if(dividend==0)//��������Ϊ0ʱ������0
        	return 0;
        boolean negative=false;//�жϽ����������
        if(dividend>0&&divisor<0||dividend<0&&divisor>0)//����һ��һ��ʱ�����Ϊ��
        	negative=true;
        long m_dividend=Math.abs((long)dividend);//��ȡ����ֵ���dividend��divisor����long�͵�m_dividend��m_divisor
        long m_divisor=Math.abs((long)divisor);
        if(m_dividend<m_divisor)//��m_dividend<m_divisor��������������С������0
        	return 0;
        long current=m_divisor,count=1;
        while(current<m_dividend){//��current�Ŵ�������m_dividend
        	current<<=1;//current<=dividendʱ��current��count����һλ(��current��count����2)
        	count<<=1;
        }
        long result=0;
        while(current>=m_divisor){//��current>=m_divisorʱ������ѭ��
        	while(current<=m_dividend){//��current<=m_dividendʱ����count�ۼ���result������m_dividend��ȥcurrent;
        		result+=count;
        		m_dividend-=current;
        	}
        	current>>=1;//current��count����һλ(��current��count����2)
        	count>>=1;
        }
        if(result>Integer.MAX_VALUE)//���������Integer.MAX_VALUEʱ������Integer.MAX_VALUE
        	return Integer.MAX_VALUE;
        if(negative)//���������ԣ�������Ӧ���
        	return -(int)result;
        return (int)result;
    }
}
