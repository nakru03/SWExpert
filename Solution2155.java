import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2155 {
	static int N, M, C;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Integer> honey1;
	static ArrayList<Integer> honey2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			C = Integer.parseInt(s[2]);
			honey1 = new ArrayList<>();
			honey2 = new ArrayList<>();
			board = new int[N][N];
			
			for(int y=0; y<N; ++y) {
				s = br.readLine().split("\\s");
				for(int x=0; x<N; ++x) {
					board[y][x] = Integer.parseInt(s[x]);
				}
			}
			for(int y=0; y<N; ++y){
				for(int x=0; x<N; ++x) {
					visited = new boolean[N][N];	
					select(y,x);
				}
			}
			
			
		}
	}

	private static void select(int sy, int sx) {
		for(int i=0; i<M; ++i) {
			int nx = sx+i;
			if(nx>=N) {
				honey1.clear();
				return;//선택한 범위가 벗어난다면..
			}
			visited[sy][nx]=true;
			honey1.add(board[sy][nx]);
		}
		
		for(int y=0; y<N; ++y){
			out :for(int x=0; x<N; ++x) {
				if(visited[y][x]) continue;
				for(int i=0; i<M; ++i) {
					int nx = x+i;
					if(nx>=N) {
						honey2.clear();
						continue out;//선택한 범위가 벗어난다면..
					}
					visited[y][nx]=true;
					honey2.add(board[y][nx]);
				}
				check(honey1);
				System.out.println(honey1);
				check(honey2);
				System.out.println(honey2);
				honey1.clear();
				honey2.clear();
			}
		}
			
	}
	private static void check(ArrayList<Integer> honey12) {
		
	}
	static class Pair{
		int y;
		int x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
