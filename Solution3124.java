import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution3124 {
	
	
	static ArrayList<Edge> eList;
	static int V;
	static int E;
	static int[] p;
	static long result;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split(" ");
			V = Integer.parseInt(s[0]);
			E = Integer.parseInt(s[1]);
			eList = new ArrayList<>();
			
			for(int i=0; i<E; ++i) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				int weight = Integer.parseInt(s[2]);
				
				eList.add(new Edge(x, y, weight));
			}
			
			//가중치 순으로 소팅
			sort();
			//부모배열
			p = new int[V+1];
			//메이크셋
			makeSet();
			//유니온셋
			for(Edge e : eList) {
				if(cnt==V-1) break;
				unionSet(e);
			}
			System.out.println("#"+(t+1)+" "+result);
			result=0;
			cnt=0;
		}
	}
		
	private static void unionSet(Edge edge) {
		int x = findSet(edge.x);
		int y = findSet(edge.y);
		
		if(x!=y) {
			p[y] = x;
			result += edge.weight;
			cnt++;
		}
		
	}

	
	private static int findSet(int x) {
		if(x==p[x]) return x;		
		
		return p[x] = findSet(p[x]);
	}

	private static void makeSet() {
		for(int i=1; i<V+1; ++i) {
			p[i] = i;
		}
	}
	static void sort() {
		Collections.sort(eList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
			
		});
	}
	static class Edge{
		int x;
		int y;
		int weight;
		
		public Edge(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
	}

}
