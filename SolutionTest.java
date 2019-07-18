
public class SolutionTest {

	public static void main(String[] args) {
		
		int[] arr = new int[7];
		int[] brr = /*new int[]가 생략되있다*/{1,2,3,4,5};
		int[][] crr = {{1,2},{1,2}};
		for(int i=0; i<brr.length; ++i) {
			System.out.println(brr[i]);
		}
		//최대값 구하기
		int max = Integer.MIN_VALUE;
		for(int i=0; i<brr.length; ++i) {
			if(max<brr[i]) max = brr[i];
		}
		System.out.println("max :" + max);
		//교환 알고리즘
//		int temp, a, b;
//		a = 10;
//		b = 20;
//		temp = a;
//		a = b;
//		b = temp;
		//aa(new int[] {1,2,3,4,5}); //변수없이 바로 배열을 만들어서 넘김.
	}

}
/*private static void aa(int[] aaa) {
	System.out.println(aaa);
}*/