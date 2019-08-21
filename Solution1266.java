import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1266 {
	static final int[] combi = {153, 816, 8568, 31824, 31824, 8568, 18};
	static final int[] prime = {2,3,5,7,11,13,17};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double perA = (double)Integer.parseInt(st.nextToken())/100;
			double perB = (double)Integer.parseInt(st.nextToken())/100;
			
			double sum1 =0.0;
			double sum2=0.0;
			for(int j=0; j<7; ++j) {
				sum1 += (double)combi[j] * Math.pow(perA,prime[j]) * Math.pow(1-perA, 18-prime[j]);
			}
			for(int j=0; j<7; ++j) {
				sum2 += (double)combi[j] * Math.pow(perB,prime[j]) * Math.pow(1-perB, 18-prime[j]);
			}
			System.out.printf("#%d %6f\n",(i+1),sum1+sum2-(sum1*sum2)); //벤다이어그램으로 생각. 교집합을 빼줘야됨.
		}
				
	}

}
