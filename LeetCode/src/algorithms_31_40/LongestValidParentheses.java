package algorithms_31_40;

public class LongestValidParentheses {

	public static void main(String[] args) {
		//�㷨˼·�μ���http://blog.csdn.net/a83610312/article/details/8639790
		String s="((()))";
//		longestValidParentheses(s);
		
		System.out.println(longestValidParentheses(s));
	}

    public static int longestValidParentheses(String s) {
    	int len=s.length();
    	
    	if(len<=1)//������Ԫ��С�ڵ���1ʱ��ֱ�ӷ���0
    		return 0;
    	
        int[] longest=getLongest(s);//��ȡ��Զƥ��')'��λ������
        
        int max=0;//�ƥ���Ӵ�����
        int cur=0;//��ǰƥ���Ӵ�����
        for(int i=1;i<len+2;){//����longest���飬��ȡ���ƥ���Ӵ�����
        	if(longest[i]==-1){
        		max=Math.max(max, cur);
        		i++;
        		cur=0;//cur���㣬׼��ɨ������Ӵ�
        	}else{
        		cur+=longest[i]-i+1;
        		i=longest[i]+1;
        	}
        }
        
        return max;
    }
    
    private static int[] getLongest(String s){//��ȡ��Զƥ��')'��λ������
    	int len=s.length();
    	
    	StringBuilder builder=new StringBuilder();//��s��ǰ�����#�ַ�������ʡ�Ժ�����Խ����ж�
    	builder.append("#");
    	builder.append(s);
    	builder.append("#");
    	String str=builder.toString();
    	
    	int[] rs=new int[len+2];//��-1��ʼ���������
    	for(int i=0;i<len+2;i++){
    		rs[i]=-1;
    	}
    	
    	for(int i=len;i>0;i--){
    		if(str.charAt(i)=='('){//�����Ѿ�Ĭ�ϸ�'#'��')'��Ӧ��λ�ø�ֵΪ-1���˴����账���ַ�'('
    			int j=i+1;//j��ʾi���Ҳ�����Ԫ��
    			while(str.charAt(j)=='('&&rs[j]!=-1){//��j��ӦԪ��Ϊ'('�Ҹ�λ�õ���Զƥ��')'�����Ϊ-1ʱ��j��ֵ��������
    				j=rs[j]+1;
    			}
    			if(str.charAt(j)==')'){
    				rs[i]=j;
    			}
    		}
    	}
    	
    	return rs;
    }
}
