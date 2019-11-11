import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution7701 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			TreeSet<String> treeset = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					
					return o1.length()==o2.length() ? o1.compareTo(o2) : o1.length()-o2.length();
				}
			});
			int N = Integer.parseInt(br.readLine());
			for(int i=0; i<N; ++i) {
				treeset.add(br.readLine());
			}
			sb.append("#" + (t+1)+"\n");
			Iterator<String> it = treeset.iterator();
			
			while(it.hasNext()) {
				sb.append(it.next()+"\n");
			}
		}
		System.out.print(sb);
	}

}
