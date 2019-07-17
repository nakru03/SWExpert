import java.util.Scanner;
import java.util.Stack;

public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; ++i) {
			int n = sc.nextInt();
			int l = sc.nextInt();
			int[] score = new int[1001];
			int[] kcal = new int[1001];
			int max = 0;
			
			for (int j = 0; j < n; ++j) {
				score[j] = sc.nextInt();
				kcal[j] = sc.nextInt();
			}
			
			Stack<Integer> s = new Stack<>();
			boolean[] visited = new boolean[1001];
			visited[0] = true;
			s.push(0);
			while (!s.empty()) {
				int currdir = s.peek();
				s.pop();
				for(int k=0; k<n; ++k) {
					int newdir = currdir + k;
					if (kcal[currdir] + kcal[newdir] > l || newdir>n || visited[newdir]==true)
						continue;
					visited[newdir] = true;
					int newScore = score[currdir]+score[newdir];
					int newKcal = score[currdir]+kcal[newdir];
					score[newdir]=newScore;
					kcal[newdir]=newKcal;
					if(max<newScore) {
						max = newScore;
						
					}
					System.out.println(max);
					
					s.push(newdir);
				}
				
			}
			//System.out.println(score[n]);
		}
		
	}

}