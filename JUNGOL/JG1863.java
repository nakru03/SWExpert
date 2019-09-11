import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JG1863 {
	
	static int N;
	static int M;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\s");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		p = new int[N];
		makeSet();
		
		for(int i=0; i<M; ++i) {
			s = br.readLine().split("\\s");			
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1])-1;
			unionSet(x,y);
		}
		int answer = 0;
		System.out.println(Arrays.toString(p));
		for(int i=0; i<p.length; ++i) {
			if(p[i] == i)
				answer++;
		}
		System.out.println(answer);
		
	}
	
	private static void unionSet(int x, int y) {
		x = findSet(p[x]);
		y = findSet(p[y]);
		
		if(x != y) {
			p[y] = x;
		}
	}
	
	private static int findSet(int x) {
		if(p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}
	
	private static void makeSet() {
		for(int i=0; i<N; ++i) {
			p[i] = i;
		}
	}

}
