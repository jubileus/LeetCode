package algorithms_31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
	}

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> rs=new ArrayList<List<Integer>>();
    	
    	if(candidates==null||candidates.length==0){//当数组为空数组时，直接返回
    		return rs;
    	}
        Arrays.sort(candidates);//对输入数组进行非递减排序
        List<Integer> current=new ArrayList<Integer>();
        combineByDFS(candidates, target, rs, current, 0);//运用深度优先算法统计结果集
        return rs;
    }
    
    private static void combineByDFS(int[] candidates, int target,List<List<Integer>> rs,List<Integer> current,int j){
    	if(target==0){//当target减至0时，将结果添加到结果集
    		List<Integer> tmp=new ArrayList<Integer>(current);
    		rs.add(tmp);
    		return ;
    	}
    	for(int i=j;i<candidates.length;i++){
    		if(target<candidates[i]){
    			return ;
    		}
    		current.add(candidates[i]);
    		combineByDFS(candidates, target-candidates[i], rs, current, i);//深度优先进行搜索
    		current.remove(current.size()-1);//移除最后一个元素
    	}
    }
}
