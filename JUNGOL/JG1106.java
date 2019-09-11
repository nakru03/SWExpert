import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JG1106 {
	static int[][] board;
	static boolean[][] visited;
	static int N;
	static int M;
	static int dstY;
	static int dstX;
	static final int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	static final int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		dstY = Integer.parseInt(st.nextToken());
		dstX = Integer.parseInt(st.nextToken());
		
		bfs(startY, startX);
		
	}
	
	private static void bfs(int startY, int startX) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(startY, startX));
		visited[startY][startX] = true;
		int dist = 0;
		while(!q.isEmpty()) {			
			int qSize = q.size();
			dist++;
			for(int i=0; i<qSize; ++i) {
				Pair curr = q.poll();
				//System.out.println(curr.y + " " + curr.x);				
				for(int dir=0; dir<8; ++dir) {	
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					if(ny < 0 || nx < 0 || ny >= N || nx>= M) continue;
					if(visited[ny][nx]) continue;
					
					if(ny == dstY && nx == dstX) {
						System.out.println(dist);
						return;
					}
					
					q.offer(new Pair(ny,nx));
					visited[ny][nx] = true;
				}
			}
			
		}
		
	}
	
	static class Pair{
		int y;
		int x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}
