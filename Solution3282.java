import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3282 {
	static int N;
	static int K;
	static int[][] item; // 0번 부피 1번 가치
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t ) {
			String[] s = br.readLine().split("\\s");
			N = Integer.parseInt(s[0]); // 
			K = Integer.parseInt(s[1]);
			
			N++;
			item = new int[N][2];
			item[0][0] = 0;
			item[0][1] = 0;
			K++;
			
			for(int i=1; i<N; ++i) {
				s = br.readLine().split("\\s");
				item[i][0] = Integer.parseInt(s[0]);
				item[i][1] = Integer.parseInt(s[1]);
			}
			
			dp = new int[N][K];
			dp();
			for(int[] m : dp) {
				System.out.println(Arrays.toString(m));
			}
			System.out.println("#"+(t+1)+" "+dp[N-1][K-1]);
		}
	}

	private static void dp() {
		for(int i=1; i<N; ++i) {
			for(int w=1; w<K; ++w) {
				if(item[i][0]>w) {
					dp[i][w] = dp[i-1][w];
				}else {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-item[i][0]]+item[i][1]);
				}
			}
		}
	}

}
