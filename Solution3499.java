import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution3499 {
	static ArrayList<String> deck1;
	static ArrayList<String> deck2;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			int n = Integer.parseInt(br.readLine());
			deck1 = new ArrayList<>();
			deck2 = new ArrayList<>();			
			StringTokenizer  tokenizer = new StringTokenizer(br.readLine());
			if(n%2==0) {
				for(int i=1; i<=n; ++i) {
					if(i<=n/2)
						deck1.add(tokenizer.nextToken());
					else
						deck2.add(tokenizer.nextToken());
				}
			}
			else {
				for(int i=1; i<=n; ++i) {
					if(i<=n/2+1)
						deck1.add(tokenizer.nextToken());
					else
						deck2.add(tokenizer.nextToken());
				}
			}
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<deck1.size(); ++i) {
				System.out.print(deck1.get(i)+" ");
				if(i<deck2.size())
					System.out.print(deck2.get(i)+" ");
			}
			System.out.println();
		}
	}

}
