We will make arrays which will store the which col is available and which diagonal is

import java.util.*;

public class Main
{
    public static void display(boolean[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]==false) System.out.print(". ");
                else System.out.print("Q ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void solve(boolean[][] board, boolean[] cols, boolean[] ndiag, boolean[] rdiag, int row){
        if(row==board.length){
            display(board);
            return;
        }
        for(int col=0; col<board.length; col++){
            if(board[row][col]==false && cols[col]==false && ndiag[row+col]==false && rdiag[row-col+board.length-1]==false){
                board[row][col]=true;
                cols[col]=true;
                ndiag[row+col]=true;
                rdiag[row-col+board.length-1]=true;
                solve(board,cols,ndiag,rdiag,row+1);
                // BackTrack now
                board[row][col]=false;
                cols[col]=false;
                ndiag[row+col]=false;
                rdiag[row-col+board.length-1]=false;
            }
        }
    }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		boolean[][] board=new boolean[n][n];
		boolean[] cols=new boolean[n];
		boolean[] ndiag=new boolean[2*n-1];
		boolean[] rdiag=new boolean[2*n-1];
		solve(board,cols,ndiag,rdiag,0);
	}
}
