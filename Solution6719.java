import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution6719 {
	
	static int N;
	static int K;
	static ArrayList<Integer> list;
	static double sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			list = new ArrayList<>();
			
			s = br.readLine().split("\\s");
			for(int i=0; i<N; ++i) {
				list.add(Integer.parseInt(s[i]));
			}
			
			Collections.sort(list);
			System.out.println(list);
			for(int i=N-K; i<N; ++i) {
				sum = (sum+list.get(i))/2;
			}
			
			System.out.printf("#%d %.6f", t+1, sum);
			sum = 0;
		}
	}

}
