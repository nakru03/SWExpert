import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1258 {
	static int N;
	
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Pair> answer;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];
			
			for(int y=0; y<N; ++y) {
				String[] s = br.readLine().split("\\s");
				for(int x=0; x<N; ++x) {
					board[y][x] = Integer.parseInt(s[x]);
				}
			}
			answer = new ArrayList<Pair>();
			for(int sy=0; sy<N; ++sy) {
				for(int sx=0; sx<N; ++sx) {
					if(board[sy][sx]!=0)
						bfs(new Pair(sy, sx));
				}
			}
			Collections.sort(answer);
			sb.append("#"+(t+1)+" "+answer.size()+" ");
			for(int i=0; i<answer.size(); ++i) {
				Pair curr = answer.get(i);
				sb.append(curr.y + " "+curr.x + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	
	private static void bfs(Pair start) {
		
		Queue<Pair> q = new LinkedList<>();
	
		Pair last = new Pair(start.y, start.x);
		q.offer(start);
		board[start.y][start.x] = 0;
		
		while(!q.isEmpty()) {
			
			Pair curr = q.poll();
			
			for(int dir=0; dir<4; ++dir) {
				int ny = curr.y + dy[dir];
				int nx = curr.x + dx[dir];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if(board[ny][nx] == 0) continue;
	
				q.offer(new Pair(ny, nx));
				board[ny][nx] = 0;
				last.y = ny; last.x = nx;
				
			}
		}
		
		int answerY = last.y-start.y+1;
		int answerX = last.x-start.x+1;
		answer.add(new Pair(answerY, answerX, answerY * answerX ));
	}
	
	
	static class Pair implements Comparable<Pair>{
		int y;
		int x;
		int size;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		public Pair(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.size == o.size ? this.y-o.y : this.size - o.size;
		}		
		
	}

}
