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
        if(candidates==null||candidates.length==0){//当数组为空数组时，直接返回
        	return rs;
        }
        Arrays.sort(candidates);//对输入数组进行非递减排序
        
        List<Integer> current=new ArrayList<Integer>();
        HashSet<List<Integer>> set=new HashSet<List<Integer>>();
        combineByDFS(candidates, target, set, current, 0);//运用深度优先算法统计结果HashSet
        
        Iterator<List<Integer>> iterator=set.iterator();//将存在HashSet中的结果放入结果集
        while(iterator.hasNext()){
        	rs.add(iterator.next());
        }
        return rs;
    }
    
    private void combineByDFS(int[] candidates,int target,HashSet<List<Integer>> set, List<Integer> current,int j){
    	if(target==0){//当target减至0时，如果结果未在HashSet中，将结果添加到HashSet
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
    		combineByDFS(candidates, target-candidates[i], set, current, i+1);//深度优先进行搜索
    		current.remove(current.size()-1);//移除最后一个元素
    	}
    }
}
