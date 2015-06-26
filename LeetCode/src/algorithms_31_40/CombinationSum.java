package algorithms_31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
	}

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> rs=new ArrayList<List<Integer>>();
    	
    	if(candidates==null||candidates.length==0){//������Ϊ������ʱ��ֱ�ӷ���
    		return rs;
    	}
        Arrays.sort(candidates);//������������зǵݼ�����
        List<Integer> current=new ArrayList<Integer>();
        combineByDFS(candidates, target, rs, current, 0);//������������㷨ͳ�ƽ����
        return rs;
    }
    
    private static void combineByDFS(int[] candidates, int target,List<List<Integer>> rs,List<Integer> current,int j){
    	if(target==0){//��target����0ʱ���������ӵ������
    		List<Integer> tmp=new ArrayList<Integer>(current);
    		rs.add(tmp);
    		return ;
    	}
    	for(int i=j;i<candidates.length;i++){
    		if(target<candidates[i]){
    			return ;
    		}
    		current.add(candidates[i]);
    		combineByDFS(candidates, target-candidates[i], rs, current, i);//������Ƚ�������
    		current.remove(current.size()-1);//�Ƴ����һ��Ԫ��
    	}
    }
}
