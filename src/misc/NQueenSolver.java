package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueenSolver {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if (!s.trim().equals("")) {
			int n = Integer.parseInt(s);
			int[] board = new int[n];
			placeQueen(0,board,n);
		}
		
	}

	public static void placeQueen(int row, int[] board,int n) {
		if(row==n) {
			System.out.println(Arrays.toString(board));
		} else {
			for(int i=0;i<n;i++) {
				if(check(i,row,board)) {
					board[row]=i;
					placeQueen(row+1, board, n);
//					board[row] = -1;
				}
			}
		}
	}
	
	public static boolean check(int pos, int row, int[] board) {
		for(int i=0;i<row;i++) {
			if(board[i]==pos) {
				return false;
			}
			if(Math.abs(board[i]-pos)==Math.abs(i-row)) {
				return false;
			}
		}
		return true;
	}

}
