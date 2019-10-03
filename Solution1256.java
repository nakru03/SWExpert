import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution1256 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			ArrayList<String> list = new ArrayList<>();
			for(int i=0; i<s.length(); ++i) {
				list.add(s.substring(i));
			}
			Collections.sort(list);
			System.out.println("#"+(t+1) + " " + list.get(n-1));
		}
	}

}
