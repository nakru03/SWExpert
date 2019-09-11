import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution7699 {	
	
	static int R;	
	static int C;
	static String[][] board;
	static boolean[] visited;
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			
			String[] s = br.readLine().split("\\s");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			board = new String[R][C];
			
			ans = Integer.MIN_VALUE;
			
			for(int y=0; y<R; ++y) {
				board[y] = br.readLine().split("");
			}
			
			visited = new boolean[26]; //유물 탐색용
			visited[board[0][0].charAt(0) - 'A'] = true;	
			dfs(0,0,1);
				
			sb.append("#"+(t+1)+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int y, int x, int count) {
		if(ans < count)
			ans = count;
		if(count == 26)
			return;
		
		for(int dir=0; dir<4; ++dir) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];			
			if(ny<0 || nx<0 || ny>=R|| nx>=C) continue;
			if(visited[board[ny][nx].charAt(0) - 'A']) continue;
			visited[board[ny][nx].charAt(0) - 'A'] = true;		
			dfs(ny, nx, count+1);
			visited[board[ny][nx].charAt(0) - 'A'] = false;		
		}
		
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
