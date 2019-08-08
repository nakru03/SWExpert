import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mirro2 {
	static int[][] map;
	static final int[] dx = {0,1,0,-1};
	static final int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		map = new int[][]{  
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}
		};
		
		int[][] dist = new int[map.length][map.length];
		for(int i=0; i<dist.length; ++i) {
			Arrays.fill(dist[i], -1);		
		}
		
		bfs(dist, 0);
		for(int i=0; i<dist.length; ++i) {
			System.out.println(Arrays.toString(dist[i]));
		}
		
		
	}
	
	private static void bfs(int[][] dist, int k) {
		
		Queue<Pair> q = new LinkedList<>();		
		q.offer(new Pair(0,0));
		dist[0][0] += 1;
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			for(int dir = 0; dir<4; ++dir) {
				int ny = curr.y+dy[dir];
				int nx = curr.x+dx[dir];
				
				if(ny<0 || nx<0 || nx>=map.length || ny>=map.length) continue;
				if(map[ny][nx] == 1 || dist[ny][nx] > -1) continue;
				q.offer(new Pair(ny,nx));
				dist[ny][nx] = dist[curr.y][curr.x] + 1;
			}
		}
	}
	static class Pair{
		int x;
		int y;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
			
		}
	}
}
