import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {5,2,7,8,3,1,1};
//					5,2,7,8,3,9,1
//					1,2,7,8,3,9,5...1
//					1,2,7,8,3,9,5...2
//					1,2,3,8,7,9,5...3
//					1,2,3,5,7,9,8...4
//					1,2,3,5,7,8,9...5
			doSelction(arr);
			System.out.println(Arrays.toString(arr));
		
		}

	private static void doSelction(int[] arr) { //재귀로 한번 만들어보기.
		
		for(int i=0; i<arr.length-1; ++i) {
			int min = i;
			for(int j=i+1; j<arr.length; ++j) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			if(i!=min) { //최소값이 min인 경우.
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
			
		}
		
	}
	

}
