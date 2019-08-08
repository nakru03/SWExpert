import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 링크드 리스트로 구현한 그래프 BFS
 */
public class BFSTest2 {

	public static void main(String[] args) {
		Graph graph = new Graph(datas.length);
		graph.addVer(1,2);
		graph.addVer(1,3);
		graph.addVer(1,4);
		
		graph.addVer(2,5);
		graph.addVer(2,6);
		
		graph.addVer(4,7);
		graph.addVer(4,8);
		graph.addVer(4,9);
		
		graph.bfs(1);
		
	}
	static char[] datas = {' ','A','B','C','D','E','F','G','H','I'};
	static boolean[] visited;
	static void bfs(int[][] graph, int start) {
		
	}
	static class Graph{
		int size;
		LinkedList<Integer>[] adj;
		
		public void addVer(int i, int j) {
			adj[i].add(j);
		}
		public void bfs(int start) {
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[size];
			q.offer(start);
			visited[start] = true;
			
			while(!q.isEmpty()) {
				int idx = q.poll();
				System.out.println(String.format("%s ", datas[idx]));
				Iterator<Integer> iterator = adj[idx].iterator();
				int point;
				while(iterator.hasNext()) {
					point = iterator.next();
					if(!visited[point]) {
						q.offer(point);
						visited[point] = true;
					}
					
				}
			}
			
		}
		public Graph(int size) {
			this.size = size;
			adj = new LinkedList[size];
			for(int i=0; i< size; ++i) {
				adj[i] = new LinkedList<Integer>();
			}
		}
		
		
	}

}
