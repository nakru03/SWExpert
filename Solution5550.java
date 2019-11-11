import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5550 {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<tc; ++t) {
			String s = br.readLine();
			int[] sounded = new int[5];
			int result = 0;
			boolean flag = true;
			for(int i=0; i<s.length(); ++i) {
				switch(s.charAt(i)) {
				case 'c':
					sounded[0]++;
					break;
				case 'r':
					sounded[0]--;
					sounded[1]++;
					if(sounded[0]<0) {
						flag = false;
					}
					break;
				case 'o':
					sounded[1]--;
					sounded[2]++;
					if(sounded[1]<0) {
						flag = false;
					}
					break;
				case 'a':
					sounded[2]--;
					sounded[3]++;
					if(sounded[2]<0) {
						flag = false;
					}
					break;
				case 'k':
					sounded[3]--;
					if(sounded[3]<0) {
						flag = false;
					}
					break;
				}
				result = Math.max(result, sounded[0]+sounded[1]+sounded[2]+sounded[3]+sounded[4]); //개구리 다돔
			}
			if(sounded[0]!=0 || sounded[1]!=0 || sounded[2]!=0 || sounded[3]!=0 || sounded[4]!=0) flag = false;//다돌았는데도 남으면 false
			if(flag) System.out.println("#" + (t+1) + " " + result);
			else System.out.println("#"+(t+1)+" -1");
		}
	}
}
