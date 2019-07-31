import java.util.Arrays;

//	1,2,3
//  2,1,3
//  2,3,1
//  3,2,1
//  3,1,2
//  1,3,2
//	nPr = n!/(n-r)!
// 3수중 3개를 선택 3!/0! = 3!
public class PermutationTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3};  //{1,2},{2,1}
		perm(arr,0);
		

	}

	private static void perm(int[] arr, int depth) {
//종료 , 실행, 자기호출
		if(arr.length == depth) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=depth; i<arr.length; ++i) {
			swap(arr, depth, i);
			perm(arr,depth+1);
			swap(arr, depth, i);
		}
		
		
	}
	static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}


