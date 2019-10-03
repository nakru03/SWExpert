import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Solution3074 {
	static int N; //심사대 개수
	static int M; // 사람수..
	static long[] time;
	static long maxtime = Long.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			N = Integer.parseInt(s[0]); // 심사대
			M = Integer.parseInt(s[1]);
		
		time = new long[N];
		for(int i=0; i<N; ++i) {
			time[i] = Integer.parseInt(br.readLine());
			if(maxtime<time[i]) {
				maxtime = time[i];
			}
		}
		
		long left = 0;
		long right = maxtime * M;
		long result = right;
		long mid = 0;
		
		while (left <= right) {
			
			mid = (left+right)/2;
			
			long total = 0;
			for(int i=0; i<time.length; ++i) {
				total += mid/time[i];
			}
			if(total>=M) {
				if(result>mid) result = mid;
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println("#"+(t+1)+" "+result);
		}
	}

}
