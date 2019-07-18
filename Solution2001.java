import java.util.Scanner;



public class Solution2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=0; t<tc; ++t) {
			int n = sc.nextInt();
			int m = sc.nextInt();			
			m = m - 1;			
			int[][] arr = new int[n][n];
			int max = 0;
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<n; ++i) {				
				for(int j=0; j<n; ++j) {
					int pari = 0;
					if(i+m>=n || j+m>=n) continue;
					for(int k=i; k<=i+m; ++k) {
						for(int l=j; l<=j+m; ++l) {
							pari += arr[k][l];
						}
					}
					if(max<pari) {
						max = pari;
						
					}
						
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
		
	}

}