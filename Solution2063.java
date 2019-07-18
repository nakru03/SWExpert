import java.util.Arrays;
import java.util.Scanner;

public class Solution2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int[] arr = new int[n];
		
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println(arr[n/2]);
	}
}
//greedy 모든 케이스를 다하지 않고 어느 특정 케이스만 한다.