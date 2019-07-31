
import java.util.Arrays;
import java.util.Scanner;
/*
 * 버블 소트
 * 시간 복잡도 : O(n^2)
 * 공간복잡도 좋음
 */
public class SolutionBubbleSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; ++i) { //0 1 2 3 4 5
			for (int j = 0; j < arr.length - i - 1; ++j) { //0-4 0-3 0-2 0-1
				if (arr[j] > arr[j + 1]) {
					int temp = 0;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}

	}

}
