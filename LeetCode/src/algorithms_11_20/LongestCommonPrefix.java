package algorithms_11_20;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs={"a","a","b"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder=new StringBuilder();
        if(strs==null||strs.length==0)//���ַ�������Ϊ��ʱ������""
        	return "";
        if(strs.length==1)//���ַ�������ֻ��һ��Ԫ��ʱ�����ظ�Ԫ��
        	return strs[0];
        boolean not_finish=true;
        int index=0;//��ÿ��String�ĵ�һ���ַ���ʼ�Ƚ�
        while(not_finish){//��δ�����ȫ���ַ�ʱ
        	char current;
        	if(index>strs[0].length()-1){//�����һ���ַ����ĳ���С�ڵ�ǰҪ���ʵ��ַ��±꣬����ѭ��
        		not_finish=false;
        		break;
        	}else
        		current=strs[0].charAt(index);//����һ���ַ����ĵ�index���ַ�����current
        	for(int i=1;i<strs.length;i++){
        		if(index>strs[i].length()-1){//�����i���ַ����ĳ���С�ڵ�ǰҪ���ʵ��ַ��±꣬����ѭ��
        			not_finish=false;
            		break;
        		}else{
            		if(current!=strs[i].charAt(index)){//����i���ַ����ĵ�index���ַ��뵱ǰcurrent��ͬʱ������ѭ��
            			not_finish=false;
            			break;
            		}
        		}
        	}
        	if(not_finish)//not_finish ֵΪtrue����ʾ���ַ����ǰ׺�е�
        		builder.append(current);
        	index++;//��ַ�±�+1
        }
        return builder.toString();
    }

}
