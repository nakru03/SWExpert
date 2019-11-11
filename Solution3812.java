import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3812 {
	static int X;
	static int Y;
	static int Z;
	static int A;
	static int B;
	static int C;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			X=Integer.parseInt(s[0]);
			Y=Integer.parseInt(s[1]);
			Z=Integer.parseInt(s[2]);
			A=Integer.parseInt(s[3]);
			B=Integer.parseInt(s[4]);
			C=Integer.parseInt(s[5]);
			N=Integer.parseInt(s[6]);
			
			
		}
		
	}
}
