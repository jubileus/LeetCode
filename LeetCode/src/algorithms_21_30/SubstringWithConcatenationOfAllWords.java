package algorithms_21_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		String s="lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words={"fooo","barr","wing","ding","wing"};
		List<Integer> rs=findSubstring(s, words);
		
		for(int i=0;i<rs.size();i++){
			System.out.println("rs "+(i+1)+"--->"+rs.get(i));
		}
		
		System.out.println("ok");
//		HashMap<String, Integer> words_map=new HashMap();
//		HashMap<String, Integer> current_map=new HashMap<String, Integer>();
//		words_map.put("foo", 1);
//		words_map.put("bar", 1);
//		current_map.put("foo", 1);
//		current_map.put("bar", 1);
//		System.out.println(isValidate(words_map, current_map, words));
	}

    public static List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> rs=new ArrayList<Integer>();//初始化结果
    	if(words.length==0)//当words为空数组时，直接返回
    		return rs;
    	int step_length=words[0].length();//words中元素的长度
    	int count=words.length;//words中元素的数量
    	int length=s.length();//字符串s的长度
    	if(step_length>length)//当words中元素的长度大于字符串s的长度时，一定不匹配，直接返回
    		return rs;
    	HashMap<String, Integer> words_map=new HashMap<String, Integer>();//将words中的元素作为key，该元素出现次数作为value存入words_map
    	for(int i=0;i<words.length;i++)
    		addValue(words_map, words[i]);
    	int start=0,current=0;//初始化查找指针
    	while(start<=length-count*step_length){//当未查找完毕时，进入循环
    		HashMap<String, Integer> current_map=new HashMap<String, Integer>();
    		for(int i=0;i<count;i++){//统计words中的元素
    			String key=s.substring(current, current+step_length);
    			if(words_map.containsKey(key)){//当前key是words中的元素，添加该key在current_map中出现的次数
    				addValue(current_map, key);
    				current+=step_length;//指针前移step_length个长度
    			}else{
    				break;//当前key不是words中的元素，跳出for循环
    			}
    		}
    		boolean validate =isValidate(words_map, current_map, words);//检测本轮结果是否匹配
    		if(validate)
    			rs.add(start);//若匹配，将本轮的开始地址存入结果集
    		start+=1;
			current=start;
    	}
    	return rs;//返回结果
    }
    
    private static void addValue(HashMap<String, Integer> map,String key){
    	if(map.containsKey(key))//当Hashmap中存在该key时，对应value+1
    		map.put(key, map.get(key)+1);
		else
			map.put(key, 1);//当Hashmap中不存在该key时，对应value=1
    }
    
    private static boolean isValidate(HashMap<String, Integer> words_map,HashMap<String, Integer> current_map,String[] words){
    	boolean validate=true;//初始化对比结果
    	int current_count=current_map.size(),words_count=words_map.size();
    	if(current_count<words_count)//当两个Hashmap元素数量不同时，一定不匹配，返回false
    		return false;
    	for(int i=0;i<current_count;i++){
    		if(current_map.get(words[i])!=words_map.get(words[i])){//当同一个key在两个Hashmap中的值不同时，则不匹配，返回false
    			validate=false;
    			break;
    		}
    	}
    	return validate;//返回对比结果
    }
}
