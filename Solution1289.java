package swexpert_Algo;

import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		
		int tc = 0;// 테스트케이스	
		
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt(); // 테스트케이스를 입력받았음.

		for (int i = 0; i < tc; ++i) {
			String memo = ""; // 메모리 현상태
			int cnt = 0;
			
			memo = sc.next();// 받는 정답.tc의 입력값
			char [] arr = memo.toCharArray(); //char array화
			char[] ans = new char[arr.length]; 

			for (int init = 0; init < ans.length; ++init) {
					ans[init] = '0';
			} // ans 초기화
			
			
			// check/
			for (int j = 0; j < arr.length; ++j) { // 배열 접근
				if (arr[j] != ans[j]) {
					cnt++;
					for (int k = j; k < arr.length; ++k) {
						ans[k] = arr[j];
						//System.out.println(ans[k]);
					}
					
				}
			}
			System.out.println("#"+(i+1)+" "+cnt);
		}
	}

}
