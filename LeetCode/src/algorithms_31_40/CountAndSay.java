package algorithms_31_40;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

    public static String countAndSay(int n) {
    	if(n==1){//当n=1时，直接返回1
    		return "1";
    	}
    	String s="1"; 
    	for(int i=1;i<n;i++){//当n>1时，循环n-1次
    		s=generate(s);//用新生成的值替代旧数值
    	}
    	return s;
    }
    
    private static String generate(String s){
        int len=s.length();//获取s的长度
        char tmp=s.charAt(0);//将tmp赋值为s的第一个字符
        
        int begin=0;//设定begin指针为0
        int current=1;//设定current指针为1
        int count=1;//将计数器默认赋值为1
        
        StringBuilder builder=new StringBuilder();
        while(begin<len){
        	if(current==len){//current指针走到最后，特殊处理
        		builder.append(count).append(tmp);
        		begin=current;
        		break;
        	}
        	if(tmp==s.charAt(current)){//当前字符与前一字符相同
        		count++;//计数器+1
        		current++;//current指针后移1个单位
        	}else{//当前字符与前一字符不同
        		builder.append(count).append(tmp);//结果字符串拼接
        		tmp=s.charAt(current);//给tmp赋值为新字符
        		begin=current;//begin指针指向当前current指针
        		current++;//current指针前移1个单位
        		count=1;//计数器+1
        	}
        }
    	return builder.toString();
    }
}
