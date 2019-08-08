import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {

	public static void main(String[] args) {
		int[][] graph = new int[9+1][9+1];
		graph[1][2] = 1;
		graph[2][1] = 1;

		graph[3][1] = 1;
		graph[1][3] = 1;

		graph[4][1] = 1;
		graph[1][4] = 1;

		graph[2][5] = 1;
		graph[5][2] = 1;

		graph[2][6] = 1;
		graph[6][2] = 1;

		graph[4][7] = 1;
		graph[7][4] = 1;

		graph[4][8] = 1;
		graph[8][4] = 1;

		graph[4][9] = 1;
		graph[9][4] = 1;
		bfs(graph, 1);
	}
	static char[] datas = {' ','A','B','C','D','E','F','G','H','I'};
	static boolean[] visited;
 	static void bfs(int[][] graph, int start) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[graph.length];
		q.offer(start);
		while( !q.isEmpty() ) {
			int idx = q.poll();
			visited[idx] = true;
//			할일
			System.out.print(datas[idx] + " ");
			for(int i = 1; i < graph.length; i++) {
				if( !visited[i] && graph[idx][i] == 1) {
					q.offer(i);
//					visited[i] = true;
				}
			}
		}
		
	}
	
//	void aa() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}		
//		}).start();
//	}
////	Thread trd = new Thread() {
////		@Override
////		public void run() {
////			// TODO Auto-generated method stub
////			super.run();
////		}		
////	};
//	

}


















