import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1233 {
	static int N;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; ++t) {
			N = Integer.parseInt(br.readLine());
			str = new String[N+1];
			for(int i=0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.countTokens()==4) {
					int idx = Integer.parseInt(st.nextToken());
					str[idx] =  st.nextToken() + "@" + st.nextToken() + "@" + st.nextToken();
					//System.out.println(str[idx]);
				}
				else {
					int idx = Integer.parseInt(st.nextToken());
					str[idx] = st.nextToken();
				}
				
			}
			System.out.print("#"+(t+1)+" ");
			check(1);
			if(!flag)
				System.out.println(1);
			else
				System.out.println(0);
			flag = false;
		}
		
	}
	static boolean flag = false;
	private static void check(int idx) {
		if(flag)
			return;
		
		if(idx>=N+1) {
			return;
		}
		
		if(str[idx].contains("@")) {
			String tmp = str[idx];
			String[] split = tmp.split("@");
			//System.out.println(split[0]);
			if(Character.isDigit(split[0].charAt(0))){ //연산기호 가 아닌 부모
				flag=true;
				return;
			}
			else {
				check(Integer.parseInt(split[1]));
				check(Integer.parseInt(split[2]));
			}
		}
		else {
			if(!Character.isDigit(str[idx].charAt(0))){ //연산기호 가 아닌 부모
				flag = true;
				return;
			}
			else {
				return;
			}
				
		
		}		
		return;
	}

}
