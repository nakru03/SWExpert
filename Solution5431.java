import java.util.Scanner;

public class Solution5431 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; ++i) {
			int students = sc.nextInt();
			int[] arrStudents = new int[students+1];
			int goodstudents = sc.nextInt();
			for(int j=0; j<goodstudents; ++j) {
				int goodMan = sc.nextInt();
				arrStudents[goodMan]=1;
			}
			System.out.print("#"+(i+1)+" ");
			for(int j=1; j<arrStudents.length; ++j) {
				if(arrStudents[j]==0)
					System.out.print(+j+" ");
			}
			System.out.println();
		}

	}

}
