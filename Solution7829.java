import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7829 {
	static int max;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; ++i) {
				int tmp = Integer.parseInt(st.nextToken());
				min = Math.min(min, tmp);
				max = Math.max(max, tmp);
			}
			System.out.println("#"+(t+1)+" "+min*max);
		}

	}

}
