import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1494 {
	static int N;
	static ArrayList<Pair> list;
	static ArrayList<Pair> team1;
	static ArrayList<Pair> team2;
	
	static boolean[] visited;
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			visited = new boolean[N];
			
			
			team1 = new ArrayList<>();
			team2 = new ArrayList<>();
			
			for(int i=0; i<N; ++i) {
				String[] s = br.readLine().split("\\s");
				list.add(new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
			}
			//N/2까지 뽑아서 두 팀으로 나눔 스타트와링크처럼
			dfs(0,0);
			sb.append("#"+(t+1)+" "+min+"\n");
			min = Long.MAX_VALUE;
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int depth) {
		if(depth == N/2) {
			for(int i=0; i<N; ++i) {
				if(visited[i]) {
					
					team1.add(list.get(i));
				}
				else {
				
					team2.add(list.get(i));
				}
					
			}
			
			
			long x = 0;
			long y = 0;
			for(int i=0; i<N; ++i) {
				x += team2.get(i).x-team1.get(i).x;
				y += team2.get(i).y-team1.get(i).y;
			}
			
			min = Math.min(x*x+y*y, min);
			team2.clear();
			team1.clear();
			return;
		}
		for(int i=idx; i<N; ++i) {
			visited[i] = true;
			dfs(i+1, depth+1);
			visited[i] = false;
		}
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
