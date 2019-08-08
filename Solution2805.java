import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2805 {
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc < t; ++ tc ) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			for(int i=0; i<n; ++i) {
				String s =br.readLine();
				for(int j=0; j<n; ++j) {
					board[i][j] = s.charAt(j)-'0';
				}
			}
			int sum = bfs(board);
			System.out.println("#"+(tc+1)+" " + sum);
			
		}
		
		
		

	}
	private static int bfs(int[][] board) {
		int size = board.length;
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[size][size];
		int sum = 0;
		int level = 0;
		q.offer(new Pair(size/2, size/2)); //센터
		visited[size/2][size/2] = true;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for(int i=0; i<qSize; ++i) {
				Pair curr = q.poll();
				int currY = curr.y; //y
				int currX = curr.x; //x
				
				//System.out.println(board[currY][currX]);
				sum += board[currY][currX];
				
				for(int dir=0; dir<4; ++dir) {
					int ny = currY+dy[dir];
					int nx = currX+dx[dir];
					if(ny <0 || nx<0 || nx>=size || ny>=size) continue;
					if(visited[ny][nx]) continue;				
					q.offer(new Pair(ny,nx));
					visited[ny][nx] = true;
				}
			}
			level++;
			//System.out.println(level);
			if(level==(size/2+1)) break;
		}		
		return sum;
	}
	
	static class Pair{
		int y;
		int x;
		Pair(){};
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

}
