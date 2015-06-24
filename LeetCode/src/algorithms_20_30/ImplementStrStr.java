package algorithms_20_30;

public class ImplementStrStr {

	public static void main(String[] args) {
		//KMP�㷨���ɲο���http://kb.cnblogs.com/page/176818/��http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
		String haystack="mississippi";
		String needle="issis";
		System.out.println("location--->"+strStr(haystack, needle));
	}

	
    public static int strStr(String haystack, String needle) {
        int len_haystack=haystack.length(),len_needle=needle.length();//��ȡ�����ַ����ĳ���
        if(len_haystack<len_needle)//��needle���ȴ���haystackʱ��һ����ƥ��
        	return -1;
        if(len_needle==0)//��needleΪ���ַ���ʱ��һ��ƥ��
        	return 0;
        int i=0;
        int[] next=getNext(needle);//��ȡKMP�㷨�е�next[]
        while(i<=len_haystack-len_needle){//��ʣ���Ӵ���������ƥ��ʱ�������ʱ��δ�ҵ�ƥ���Ӵ���������ѭ��
        	boolean found=true;//��־λĬ����Ϊtrue
        	for(int j=0;j<len_needle;j++){//ѭ�����needle��ÿ���ַ�
        		if(haystack.charAt(i)!=needle.charAt(0)){//��һ���ַ��Ͳ�ƥ��
        			i++;//i��ǰ�ƶ�һ��λ��
        			found=false;
        			break;
        		}else if(haystack.charAt(i+j)!=needle.charAt(j)){//�����ַ���ƥ��
        			i+=j-next[j-1];//��ǰ��λ����λ��ʽΪ���ƶ�λ�� = ��ƥ����ַ��� - ���һ��ƥ���ַ��Ĳ���ƥ��ֵ
        			found=false;
        			break;
        		}
        	}
        	if(found)//�ӵ�i���ַ���ʼ���Ӵ���ƥ��ģ�i���ǵ�һ��ƥ���λ��
        		return i;
        }
        return -1;//û���ҵ�ƥ����ַ���������-1
    }
    
    public static int[] getNext(String needle) {//KMP�㷨������needle��ÿ���ַ��Ĳ���ƥ��ֵ������ƥ��ֵ��needle�����ͬǰ����׺�ĳ���
    	int length=needle.length();
    	int[] next=new int[length];
    	next[0]=0;//��һ���ַ��Ĳ���ƥ��ֵһ��Ϊ0
    	for(int i=1;i<length;i++){
    		int index=next[i-1];//Ҫ�Աȵ�λ��Ϊ��һ��Ԫ�صĲ���ƥ��ֵ
    		while(index>0&&needle.charAt(index)!=needle.charAt(i))//����ƥ��ֵ>0ʱ�������µ�Ҫ�Աȵ�λ��
    			index=next[index-1];
    		if(needle.charAt(index)==needle.charAt(i))//����i���ַ����index���ַ���ͬʱ�����ַ��Ĳ���ƥ��ֵ����һ���ַ�����ƥ��ֵ+1
    			next[i]=next[i-1]+1;
    		else
    			next[i]=0;//�������ƥ��ֵΪ0
    	}
    	return next;
    }
}
