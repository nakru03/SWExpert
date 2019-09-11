import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;


public class Solution3124_2 {
	
	
	static ArrayList<Node>[] graph;
	static int V;
	static int E;
	static long result;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split(" ");
			V = Integer.parseInt(s[0]);
			E = Integer.parseInt(s[1]);
			graph = new ArrayList[V+1];
			
			for(int i=1; i<V+1; ++i) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; ++i) {
				s = br.readLine().split(" ");
				Node v1, v2;
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				int weight = Integer.parseInt(s[2]);
				
				v1 = new Node(end, weight);
				v2 = new Node(start, weight);
				
				graph[start].add(v1);
				graph[end].add(v2);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[V+1];
			int begin = 1;
			visited[begin] = true;
			
			Iterator<Node> it = graph[begin].iterator();
			
			while(it.hasNext()) {
				pq.offer(it.next());
			}
			
			while(!pq.isEmpty()) {
				Node curr = pq.poll();
				
				if(visited[curr.vertex]) continue; //다음 정점
				
				result += curr.weight;
				visited[curr.vertex] = true;
				cnt++;
				
				if(cnt == V-1) break;
				
				it = graph[curr.vertex].iterator();
	        	while(it.hasNext()) {
	            	pq.offer(it.next());
	            }
			}			
			
			System.out.println("#"+(t+1)+" "+result);
			result=0;
			cnt=0;
		}
	}
		
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}

}
