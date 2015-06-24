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
    	List<Integer> rs=new ArrayList<Integer>();//��ʼ�����
    	if(words.length==0)//��wordsΪ������ʱ��ֱ�ӷ���
    		return rs;
    	int step_length=words[0].length();//words��Ԫ�صĳ���
    	int count=words.length;//words��Ԫ�ص�����
    	int length=s.length();//�ַ���s�ĳ���
    	if(step_length>length)//��words��Ԫ�صĳ��ȴ����ַ���s�ĳ���ʱ��һ����ƥ�䣬ֱ�ӷ���
    		return rs;
    	HashMap<String, Integer> words_map=new HashMap<String, Integer>();//��words�е�Ԫ����Ϊkey����Ԫ�س��ִ�����Ϊvalue����words_map
    	for(int i=0;i<words.length;i++)
    		addValue(words_map, words[i]);
    	int start=0,current=0;//��ʼ������ָ��
    	while(start<=length-count*step_length){//��δ�������ʱ������ѭ��
    		HashMap<String, Integer> current_map=new HashMap<String, Integer>();
    		for(int i=0;i<count;i++){//ͳ��words�е�Ԫ��
    			String key=s.substring(current, current+step_length);
    			if(words_map.containsKey(key)){//��ǰkey��words�е�Ԫ�أ���Ӹ�key��current_map�г��ֵĴ���
    				addValue(current_map, key);
    				current+=step_length;//ָ��ǰ��step_length������
    			}else{
    				break;//��ǰkey����words�е�Ԫ�أ�����forѭ��
    			}
    		}
    		boolean validate =isValidate(words_map, current_map, words);//��Ȿ�ֽ���Ƿ�ƥ��
    		if(validate)
    			rs.add(start);//��ƥ�䣬�����ֵĿ�ʼ��ַ��������
    		start+=1;
			current=start;
    	}
    	return rs;//���ؽ��
    }
    
    private static void addValue(HashMap<String, Integer> map,String key){
    	if(map.containsKey(key))//��Hashmap�д��ڸ�keyʱ����Ӧvalue+1
    		map.put(key, map.get(key)+1);
		else
			map.put(key, 1);//��Hashmap�в����ڸ�keyʱ����Ӧvalue=1
    }
    
    private static boolean isValidate(HashMap<String, Integer> words_map,HashMap<String, Integer> current_map,String[] words){
    	boolean validate=true;//��ʼ���ԱȽ��
    	int current_count=current_map.size(),words_count=words_map.size();
    	if(current_count<words_count)//������HashmapԪ��������ͬʱ��һ����ƥ�䣬����false
    		return false;
    	for(int i=0;i<current_count;i++){
    		if(current_map.get(words[i])!=words_map.get(words[i])){//��ͬһ��key������Hashmap�е�ֵ��ͬʱ����ƥ�䣬����false
    			validate=false;
    			break;
    		}
    	}
    	return validate;//���ضԱȽ��
    }
}
