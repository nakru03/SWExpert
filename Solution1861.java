import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution1861 {
	
	static int N;
	
	static int[][] board;
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static ArrayList<Pair> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			answer = new ArrayList<>();
			for(int y=0; y<N; ++y) {
				String[] s = br.readLine().split("\\s");
				for(int x=0; x<N; ++x) {
					board[y][x] = Integer.parseInt(s[x]);
				}
			}
			
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					dfs(new Pair(y, x));
				}
			}
			Collections.sort(answer);
			System.out.println("#"+(t+1)+" "+answer.get(0).y+" "+answer.get(0).x);
			
		}
	}
	private static void dfs(Pair start) {
		Stack<Pair> s = new Stack<>();
		int count = 1;
		s.push(start);
		
		while(!s.isEmpty()) {
			Pair curr = s.pop();
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || nx>=N || ny>=N) continue;
				if(board[ny][nx] != board[curr.y][curr.x]+1) continue;
				s.push(new Pair(ny, nx));
				count++;
 			}
		}		
		answer.add(new Pair(board[start.y][start.x], count));		
	}
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Pair o) {
			return o.x==this.x ? this.y-o.y : o.x-this.x;
		}
		
	}

}
