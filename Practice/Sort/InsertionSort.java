import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		int tmp;
		int j;
		for(int i=1; i<arr.length; ++i) {
			tmp = arr[i];
			for(j=i-1; j>=0; --j) {
				if(arr[j]<=tmp) {
					break;
				}
				arr[j+1] = arr[j];
			}
			arr[j+1] = tmp;
		}
	}
}
