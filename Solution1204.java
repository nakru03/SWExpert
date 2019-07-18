import java.util.Scanner;

public class Solution1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; ++i) {
			int num = -1;
			num = sc.nextInt();
			
			int[] students = new int[1000];
			int max =Integer.MIN_VALUE;
			int maxScore = Integer.MIN_VALUE;
			for(int j=0; j<students.length; ++j) {
				students[j] = sc.nextInt();
			}
			
			int[] counts = new int[101];
			for(int j=0; j<students.length; ++j) {
				counts[students[j]]++;
			}
			for(int j=0; j<counts.length; ++j) {
				if(max<counts[j]) {
					max = counts[j];
					maxScore=j;
				}
			}
			for(int j=0; j<counts.length; ++j) {
				if(max == counts[j]) {
					if(maxScore<j)
						maxScore = j;
				}
			}
			
			System.out.println("#"+num+" "+maxScore);
		}

	}

}
