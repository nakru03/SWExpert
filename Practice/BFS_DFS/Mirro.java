/*
 * dfs
 */
public class Mirro {
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
			{1,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}
		};
		
		boolean[][] visited = new boolean[map.length][map.length];
		dfs(0,0,visited, 0);
		System.out.println(min != Integer.MAX_VALUE ? min : "-1");
		
	}
	//static boolean flag;
	static int min=Integer.MAX_VALUE;
	private static void dfs(int y, int x, boolean[][] visited, int cnt) {
	
		if(cnt>min) return; //가지치기 cnt가 min보다 크면 안가면 됨.
		if(x == map.length-1 && y == map.length-1) {			
			min = Math.min(min, cnt);
			//flag = true;
			//System.out.println(cnt);
			return;
		}
		visited[y][x] = true;
		for(int dir = 0; dir<4; ++dir) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];			
			if(ny<0 || nx<0 || nx>=map.length || ny>=map.length) continue;	
			if(visited[ny][nx] || map[ny][nx] == 1) continue;		
			
			dfs(ny,nx, visited, cnt+1);
			visited[ny][nx] = false;
			
		}
		
	}
}
















