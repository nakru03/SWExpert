import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4014 {
	static int N;
	static int X;
	static int[][] board;
	static int[][] board2;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			
			String[] s = br.readLine().split("\\s");
			
			N = Integer.parseInt(s[0]);
			X = Integer.parseInt(s[1]);
			board = new int[N][N];
			board2 = new int[N][N];
			
			for(int y=0; y<N; ++y) {
				s = br.readLine().split("\\s");
				for(int x=0; x<N; ++x) {
					board[y][x] = Integer.parseInt(s[x]);
					board2[x][y] = board[y][x];
				}
			}
		
			for(int i=0; i<N; ++i) {
				rowCheck(board[i]);
				rowCheck(board2[i]);				
			}
			System.out.println("#"+(t+1)+" "+answer);
			answer = 0;
		}
	}
	private static void rowCheck(int[] row) {
		boolean[] check = new boolean[N];
		
		for(int i=0; i<N-1; ++i) {
			if(Math.abs(row[i]-row[i+1])==1) {
				if(row[i]<row[i+1]) {// /경사
					for(int j=0; j<X; ++j) {
						if(i-j<0 || check[i-j] || row[i]!=row[i-j]) return; //기저
						
						check[i-j] = true; //활주로 건설
					}
				}else {//↘경사
					for(int j=1; j<=X; ++j) {
						if(i+j>=N || check[i+j] || row[i+1]!=row[i+j]) return;
						
						check[i+j] = true;
					}
				}
			}//경사로 설계가능..
			else if(row[i]-row[i+1]==0) {
				continue;
			}//가능성 유지
			else {
				return; 
			}//2이상 차이 가능성 X
			
		}
		answer++;
	}
}
