import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 창룡마을 무리의개수
 * 유니온 파인드..
 * 다리를 거쳐 관계를 가지면.. 한무리. 무리의 개수는?
 */
public class Solution7465 {
	static int N;
	static int M;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split(" ");
			
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			p = new int[N+1];
			
			makeSet();
			for(int i=0; i<M; ++i) {
				s = br.readLine().split(" ");
				
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				
				unionSet(x,y);
			}
			
			
			int count = 0;
			for(int i=1; i<N+1; ++i) {
				if(i==p[i]) {
					count++;
				}
			}
			
			System.out.println("#"+(t+1)+" "+count);
		}
	}
	
	private static void makeSet() {
		for(int i=0; i<p.length; ++i) {
			p[i] = i;
		}		
	}

	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		
		if(x!=y) {
			p[y] = x;
		}
		
	}

	private static int findSet(int x) {
		if(p[x] == x)
			return x;		
		
		return p[x] = findSet(p[x]);
	}
	

}
