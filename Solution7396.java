import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution7396 {
	
	static int[] dy = {0,1};
	static int[] dx = {1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			
			String[] s = br.readLine().split("\\s");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			char[][] board = new char[N][M];
			String answer = "";
			
			for(int y=0; y<N; ++y) {
				board[y] = br.readLine().toCharArray();
			}
			
			boolean visited[][] = new boolean[N][M];
			Queue<Pair> q = new LinkedList<>();			
			
			visited[0][0] = true;
			q.offer(new Pair(0,0,board[0][0]));
			char ch = board[0][0];
			
			
			while(!q.isEmpty()) {
				answer+=ch;
				char next = 'z'+1;
				int qs = q.size();
				
				for(int i=0; i<qs; ++i) {
					Pair curr = q.poll();
					
					if(curr.c == ch) {
						for(int dir=0; dir<2; ++dir) {
							int ny = curr.y + dy[dir];
							int nx = curr.x + dx[dir];
							
							if(ny>=N || nx>=M || visited[ny][nx]) continue;
							
							
							if(next > board[ny][nx]) {
								next = board[ny][nx];
							}
							
							visited[ny][nx] = true;
							q.offer(new Pair(ny, nx, board[ny][nx]));
						}
					}					
										
				}
				ch = next;
				
			}
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	
	
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		char c;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Pair(int y, int x, char c) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.c-o.c;
		}
		@Override
		public String toString() {
			return c + " ";
		}
		
		
		
	}

}
