import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1244 {
	static ArrayList<Integer> num = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] tmp = st.nextToken().toCharArray();
			for(int i=0; i<tmp.length; ++i) {
				num.add(tmp[i]-'0');
			}
			int chance = Integer.parseInt(st.nextToken());
			doPerm(0, chance);
			
		}

	}
	static int max;
	private static void doPerm(int start) {
		if(start == num.size()) {
			for(int i=num.size()-1; i>=0; ++i) {
				
			}
			max = 
		}
		for(int i=0;)
	}

	

}
