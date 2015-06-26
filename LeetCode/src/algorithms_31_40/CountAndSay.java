package algorithms_31_40;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

    public static String countAndSay(int n) {
    	if(n==1){//��n=1ʱ��ֱ�ӷ���1
    		return "1";
    	}
    	String s="1"; 
    	for(int i=1;i<n;i++){//��n>1ʱ��ѭ��n-1��
    		s=generate(s);//�������ɵ�ֵ�������ֵ
    	}
    	return s;
    }
    
    private static String generate(String s){
        int len=s.length();//��ȡs�ĳ���
        char tmp=s.charAt(0);//��tmp��ֵΪs�ĵ�һ���ַ�
        
        int begin=0;//�趨beginָ��Ϊ0
        int current=1;//�趨currentָ��Ϊ1
        int count=1;//��������Ĭ�ϸ�ֵΪ1
        
        StringBuilder builder=new StringBuilder();
        while(begin<len){
        	if(current==len){//currentָ���ߵ�������⴦��
        		builder.append(count).append(tmp);
        		begin=current;
        		break;
        	}
        	if(tmp==s.charAt(current)){//��ǰ�ַ���ǰһ�ַ���ͬ
        		count++;//������+1
        		current++;//currentָ�����1����λ
        	}else{//��ǰ�ַ���ǰһ�ַ���ͬ
        		builder.append(count).append(tmp);//����ַ���ƴ��
        		tmp=s.charAt(current);//��tmp��ֵΪ���ַ�
        		begin=current;//beginָ��ָ��ǰcurrentָ��
        		current++;//currentָ��ǰ��1����λ
        		count=1;//������+1
        	}
        }
    	return builder.toString();
    }
}
