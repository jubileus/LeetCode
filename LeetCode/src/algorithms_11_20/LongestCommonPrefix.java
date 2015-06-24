package algorithms_11_20;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs={"a","a","b"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder=new StringBuilder();
        if(strs==null||strs.length==0)//当字符串数组为空时，返回""
        	return "";
        if(strs.length==1)//当字符串数组只有一个元素时，返回该元素
        	return strs[0];
        boolean not_finish=true;
        int index=0;//从每个String的第一个字符开始比较
        while(not_finish){//当未检查完全部字符时
        	char current;
        	if(index>strs[0].length()-1){//如果第一个字符串的长度小于当前要访问的字符下标，跳出循环
        		not_finish=false;
        		break;
        	}else
        		current=strs[0].charAt(index);//将第一个字符串的第index的字符当做current
        	for(int i=1;i<strs.length;i++){
        		if(index>strs[i].length()-1){//如果第i个字符串的长度小于当前要访问的字符下标，跳出循环
        			not_finish=false;
            		break;
        		}else{
            		if(current!=strs[i].charAt(index)){//当第i个字符串的第index个字符与当前current不同时，跳出循环
            			not_finish=false;
            			break;
            		}
        		}
        	}
        	if(not_finish)//not_finish 值为true，表示该字符是最长前缀中的
        		builder.append(current);
        	index++;//地址下标+1
        }
        return builder.toString();
    }

}
