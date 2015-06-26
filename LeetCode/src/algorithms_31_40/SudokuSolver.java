package algorithms_31_40;

import java.util.HashSet;

public class SudokuSolver {

	public static void main(String[] args) {
		
	}

    public static void solveSudoku(char[][] board) {
    	solve(board);
    }
    
    private static boolean solve(char[][] board){
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.'){
    				for(char k='1';k<='9';k++){
    					board[i][j]=k;
    					if(isValid(board, i, j)&&solve(board)){
    						return true;
    					}
    					board[i][j]='.';
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    
    private static boolean isValid(char[][] board,int row,int column){//仅检测当前改变位置的行、列、九宫格是否符合条件
    	//检测行
    	for(int i=0;i<9;i++){
    		if(i!=row&&board[row][column]==board[i][column]){
    			return false;
    		}
    	}
    	//检测列
    	for(int i=0;i<9;i++){
    		if(i!=column&&board[row][column]==board[row][i]){
    			return false;
    		}
    	}
    	//检测九宫格
    	for(int i=(row/3)*3;i<(row/3)*3+3;i++){
    		for(int j=(column/3)*3;j<(column/3)*3+3;j++){
    			if(i!=row&&j!=column&&board[row][column]==board[i][j]){
    				return false;
    			}
    		}
    	}
		return true;
    }
}
