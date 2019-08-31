import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * SWEA 1251 하나로
 * Kruskal algo.. 섬사이 최소 환경부담금 구하기
 * 환경부담금 E * L^2
 * 
 */
public class Solution1251 {
	
	static int N;
	static ArrayList<Island> iList = new ArrayList<>(); //클리어 필요
	static ArrayList<Edge> kList = new ArrayList<>();
	static double E;
	static int[] p;
	static long result;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			//입력
			N = Integer.parseInt(br.readLine());
			String[] xPos = br.readLine().split("\\s");
			String[] yPos = br.readLine().split("\\s");
			
			for(int i=0; i<N; ++i) {
				
				long x = Integer.parseInt(xPos[i]);
				long y = Integer.parseInt(yPos[i]);
				
				iList.add(new Island(x, y, i));
			}
			
			E = Double.parseDouble(br.readLine()); //세율
			
			//모든 정점이 이어지는 걸 생각..해서 모든 가중치를 구함.			
			for(int i=0; i<N; ++i) {
				for(int j=i+1; j<N; ++j) {
					kList.add(new Edge(iList.get(i).num, iList.get(j).num, dist(i,j)));
				}
			}
			//크루스칼..
			Collections.sort(kList);
			makeSet();
			for(Edge e : kList) {
				if(cnt == N-1) break;
				unionSet(e);
			}
						
			System.out.printf("#%d %.0f\n",(t+1),result*E);
			iList.clear();
			kList.clear();
			result = 0;
			cnt = 0;
		}
	}
	


	private static void unionSet(Edge e) {
		int x = findSet(e.i1);
		int y = findSet(e.i2);
		
		if(x!=y) {
			p[y] = x;
			result += e.weight;
			cnt++;
		}
	}



	private static int findSet(int x) {
		if(x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}



	private static void makeSet() {
		p = new int[N];
		for(int i=0; i<N; ++i) {
			p[i] = i;
		}
	}

	
	private static long dist(int i, int j) {
		Island i1 = iList.get(i);
		Island i2 = iList.get(j);
				
		return (long) (Math.pow(i2.x-i1.x,2) + Math.pow(i2.y-i1.y, 2));
	}

	
	static class Island{
		long x;
		long y;
		int num;
		
		public Island(long x2, long y2, int num) {
			this.x = x2;
			this.y = y2;
			this.num = num;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int i1;
		int i2;
		long weight;
		
		public Edge(int i1, int i2, long weight) {
			super();
			this.i1 = i1;
			this.i2 = i2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight >= o.weight ? 1 : -1;
		}		
		
	}

}

