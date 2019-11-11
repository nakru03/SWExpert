import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5162 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			
			int divide = Math.min(A, B);
			
			int result = C/divide;
			
			System.out.println("#"+(t+1)+" "+result);
		}
	}

}
