
public class SearchTest {

	public static void main(String[] args) {
		int[] arr = {4,9,11,23,2,19,7};
		int key = 2;
		int idx = searchKey(arr,key);
		System.out.println(idx!=-1 ? "찾음":"못찾음");

	}

	private static int searchKey(int[] arr, int key) {
		int idx=-1;
		for(int i=0; i<arr.length; ++i) {
			if(arr[i]==key) {
				idx = i;
				break;				
			}
				//return i;
		}
		return idx;
	}

}
