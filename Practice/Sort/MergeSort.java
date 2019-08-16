import java.util.Arrays;

/*
 * 머지는 O(nlogn)이 보장된다.
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {69,10,30,2,16,8,31,22};
		temp=new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void mergeSort(int[] arr, int start, int end) {
		
		if(start >= end) {
			return;
		}
		int mid = (start+end)/2;
		
		mergeSort(arr,start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr,start, mid, end);
	}
	static int[] temp;
	static void merge(int[] arr, int start, int mid, int end) {
		int L, R, K;
		L=start;
		R = mid+1;
		K = start;
		while(L <= mid&&R <= end) {
			if(arr[L] < arr[R]) {
				temp[K++] = arr[L++];
			}else {
				temp[K++] = arr[R++];
			}
				
		}
		while(L <= mid) {
			temp[K++] = arr[L++];
		}
		while(R<=end) {
			temp[K++] = arr[R++];
		}
		for(int i=start; i<=end; ++i)
			arr[i] = temp[i];
	}
}
