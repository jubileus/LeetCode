package algorithms_21_30;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n=3;
		List<String> rs=generateParenthesis(n);
		for(int i=0;i<rs.size();i++){
			System.out.println(rs.get(i));
		}
	}

    public static List<String> generateParenthesis(int n) {
    	if(n<1)//��n<1ʱ��ֱ�ӷ���null
    		return null;
    	List<String> rs=new ArrayList<String>();
    	String tmp=new String();
    	doDFS(rs, tmp, n, n);//Ӧ����������㷨��Ѱ�ҺϷ������ַ���
    	return rs;
    }
    
    private static void doDFS(List<String> rs,String tmp,int left,int right){
    	if(left>right)//�����ű������Ŷ࣬һ�����ǺϷ������ַ���
    		return;
    	if(right==0&&right==0)//����ȫ�����ţ��������ӵ��������
    		rs.add(tmp);
    	if(left>0)//������û���꣬ʹ��������
    		doDFS(rs, tmp+"(", left-1, right);
		if(right>0)//������û���꣬ʹ��������
    		doDFS(rs, tmp+")", left, right-1);
    }
}
