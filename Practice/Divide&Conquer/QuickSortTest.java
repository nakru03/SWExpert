import java.util.Arrays;

public class QuickSortTest {
	public static void main(String[] args) {
		int[] arr = {4,3,6,9,1,5,7,2,8,99};
		quickSort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		if(begin<end) {
			int pivot = partition(arr, begin, end);
			quickSort(arr, begin, pivot-1);
			quickSort(arr, pivot+1, end);
		}
		
	}

	private static int partition(int[] arr, int begin, int end) {
//		int pivot = begin;
//		int L,R;
//		L=begin+1;
//		R=end;
//		while(L<=R) {
//			while(arr[L] >= arr[pivot] && L < end) {
//				L++;
//			}
//			while(arr[pivot] <= arr[R] && R > begin) {
//				R--;
//			}
//			if(L<R)
//				swap(arr,L,R);
//			else {
//				swap(arr, R, pivot);
//				pivot = R;
//			}
//		
//		}
//		
//		return pivot;
		
		int pivot = (begin+end)/2;
		while(begin<end) {
			while(arr[begin]<arr[pivot] && begin<end) begin++;
			while(arr[end]>=arr[pivot] && begin<end) end --;
			if(begin<end) swap(arr, begin, end);
		}
		swap(arr, pivot, end);
		return end;
	}

	private static void swap(int[] arr, int begin, int end) {
		int tmp = arr[end];
		arr[end] = arr[begin];
		arr[begin] = tmp;
		
	}
}
