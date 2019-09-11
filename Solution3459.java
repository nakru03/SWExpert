import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution3459 {
	static boolean alice;
	static long N;
	static ArrayList<Boolean> answerCheck;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			N = Long.parseLong(br.readLine());
			long ans = 1;
			long count = 4;
			alice = false;
			if(N==1) {
				System.out.println("#"+(t+1)+" "+"Bob");
			}
			else {
				while(ans<N) {
					ans += count;
					if(N<=ans) {
						System.out.println("#"+(t+1)+" "+"Alice");
						break;
					}
					ans += count;
					if(N<=ans) {
						System.out.println("#"+(t+1)+" "+"Bob");
						break;
					}
					count *= 4;
				}	
			}
					
		}
		
	}
	
}
