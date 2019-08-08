import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; ++i) {
			int tcnum = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			StringTokenizer tokenizer = new StringTokenizer(nums);
			for(int j=0; j<8; ++j) {
				q.offer(Integer.parseInt(tokenizer.nextToken()));
			}
			int minus = 1;
			while(true) {	
				int tmp = q.poll() - minus;
				if(tmp<=0) {
					tmp = 0;
					q.offer(tmp);
					break;
				}
				q.offer(tmp);
				minus++;
				if(minus>5) minus = 1;

			}
			System.out.print("#" + (i+1)+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() +" ");
			}
			System.out.println();
		}

	}

}
