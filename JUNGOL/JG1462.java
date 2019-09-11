import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JG1462 {
	static char[][] board;
	static boolean[][] visited;
	static int Y;
	static int X;
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		board = new char[Y][X];
		visited = new boolean[Y][X];
		for(int i=0; i<Y; ++i) {
			board[i] = br.readLine().toCharArray(); 
		}
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x] == 'W') continue;
				bfs(y,x);
				clearVisit();
			}
		}
		System.out.println(max);
	}
	
	static int max;
	private static void bfs(int y, int x) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(y, x));
		visited[y][x] = true;
		int level = -1;
		while(!q.isEmpty()) {			
			int qSize = q.size();
			for(int i=0; i<qSize; ++i) {
				Pair curr = q.poll();
				
				for(int dir = 0; dir<4; ++dir) {
					int ny = curr.y + dy[dir];
					int nx = curr.x + dx[dir];
					
					if(ny < 0 || nx < 0 || nx>= X || ny >= Y) continue;
					if(board[ny][nx] == 'W' || visited[ny][nx]) continue;
					q.offer(new Pair(ny, nx));
					visited[ny][nx] = true;
				}
			}
			level++;
		}
		max = Math.max(max, level);
	}
	static void clearVisit() {
		for(int i=0; i<Y; ++i) {
			for(int j=0; j<X; ++j) {
				visited[i][j] = false;
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
