/*
 * 2차원 배열 회전시키기.
 */
public class ArrayTest4 {

	public static void main(String[] args) {
//		int a = 10;
//		int b = 20;
//		boolean c = a > 50 && ++b>10;
//		System.out.println("c : " + c + ", b :" + b); //shot circuit 숏서킷 연산 앞의 값이 false면 뒤의 논리 연산은 생략. 풀 서킷 하고 싶으면 &연산.
		int[][] arr = new int[4][4];
		
		int[][] brr = new int[arr.length][arr.length];
		int cnt = 0;
		
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr.length; ++j) {
				arr[i][j] = ++cnt;
			}
		}
		
//arr 배열을 90도 오른쪽으로 회전한 결과를 brr에 쓰시오?
//		for(int i=0; i<arr.length; ++i) {
//			for(int j=0; j<arr.length; ++j) {
//				brr[i][j] = arr[3-j][i];
//			}
//		}
//arr 배열을 180도 돌림.
//		for(int i=0; i<arr.length; ++i) {
//			for(int j=0; j<arr.length; ++j) {
//				brr[i][j] = arr[3-i][3-j];
//			}
//		}
//arr 배열 270도 돌림.
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr.length; ++j) {
				brr[i][j] = arr[3-i][j];
			}
		}
		
		for(int i=0; i<brr.length; ++i) {
			for(int j=0; j<brr.length; ++j) {
				System.out.print(brr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
