import java.util.Arrays;
import java.util.Scanner;

/*
 * N Queen 문제
 * 가로세로 N의 정사각형에서 N개의 퀸을 놓을 수 있는 케이스.
 * 퀸은 한 줄에 한개밖에 못놓음.
 */
public class NQueenTest {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] board = new int[n];
		backtracking(board, 0);
		
	}
	static int cnt = 0;
	private static void backtracking(int[] board, int depth) {
		if(depth==n) {
			//체크 출력			
//			boolean flag = check(board);
//			if(flag)
			System.out.println(Arrays.toString(board) + cnt);
			return;
		}
		for(int i=0; i<n; ++i) {
			board[depth] = i;
			if(isPromising(board,depth)){
			backtracking(board, depth+1);
			}
		}
	}
	static boolean isPromising(int[] board, int depth) {
		cnt++;
		boolean flag = true;
		for(int i=0; i<depth; ++i) {
			if(board[i]==board[depth]) { //수직판별.
				flag = false;
				break;
			}
			if(board[depth]-board[i] == depth-i) { //인덱스와 j-i 저장값이 같으면 오른쪽대각 판별
				flag = false;
				break;
			}
			if(board[i]-board[depth] == depth-i) { //인덱스와 i-j 저장값이 같으면 왼쪽대각 판별
				flag = false;
				break;
			}
		}
		return flag;
	}
//	private static boolean check(int[] board) {
//		boolean flag = true;
//		outer:for(int i=0; i<board.length-1; ++i) {
//			for(int j=i+1; j<board.length; ++j) {
//				if(board[i]==board[j]) { //수직판별.
//					flag = false;
//					break outer;
//				}
//				if(board[j]-board[i] == j-i) { //인덱스와 j-i 저장값이 같으면 오른쪽대각 판별
//					flag = false;
//					break outer;
//				}
//				if(board[i]-board[j] == j-i) { //인덱스와 i-j 저장값이 같으면 왼쪽대각 판별
//					flag = false;
//					break outer;
//				}
//			}
//		}
//		return flag;
//	}

}
