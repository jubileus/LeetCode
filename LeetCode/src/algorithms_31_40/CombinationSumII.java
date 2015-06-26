package algorithms_31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {

	}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> rs=new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0){//������Ϊ������ʱ��ֱ�ӷ���
        	return rs;
        }
        Arrays.sort(candidates);//������������зǵݼ�����
        
        List<Integer> current=new ArrayList<Integer>();
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        combineByDFS(candidates, target, set, current, 0);//������������㷨ͳ�ƽ��HashSet
        
        Iterator<List<Integer>> iterator=set.iterator();//������HashSet�еĽ����������
        while(iterator.hasNext()){
        	rs.add(iterator.next());
        }
        return rs;
    }
    
    private void combineByDFS(int[] candidates,int target,HashSet<List<Integer>> set, List<Integer> current,int j){
    	if(target==0){//��target����0ʱ��������δ��HashSet�У��������ӵ�HashSet
    		if(!set.contains(current)){
    			List<Integer> tmp=new ArrayList<Integer>(current);
        		set.add(tmp);
    		}
    		return ;
    	}
    	for(int i=j;i<candidates.length;i++){
    		if(target<candidates[i]){
    			return ;
    		}
    		current.add(candidates[i]);
    		combineByDFS(candidates, target-candidates[i], set, current, i+1);//������Ƚ�������
    		current.remove(current.size()-1);//�Ƴ����һ��Ԫ��
    	}
    }
}
