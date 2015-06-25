package algorithms_31_40;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public static boolean isValidSudoku(char[][] board) {
    	HashSet<Character> set=new HashSet<Character>();
        //检查行
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.'){
    				continue;
    			}else{
    				if(set.contains(board[i][j])){
    					return false;
    				}else{
    					set.add(board[i][j]);
    				}
    			}
    		}
    		set.clear();
    	}
    	//检查列
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[j][i]=='.'){
    				continue;
    			}else{
    				if(set.contains(board[j][i])){
    					return false;
    				}else{
    					set.add(board[j][i]);
    				}
    			}
    		}
    		set.clear();
    	}
    	//检查九宫格
    	for(int k=0;k<9;k++){
    		for(int i=(k/3)*3;i<(k/3)*3+3;i++){
    			for(int j=(k%3)*3;j<(k%3)*3+3;j++){
    				if(board[i][j]=='.'){
        				continue;
        			}else{
        				if(set.contains(board[i][j])){
        					return false;
        				}else{
        					set.add(board[i][j]);
        				}
        			}
    			}
    		}
    		set.clear();
    	}
    	return true;
    }
}
