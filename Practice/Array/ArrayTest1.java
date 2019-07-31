import java.util.Arrays;

public class ArrayTest1 {

	public static void main(String[] args) {
		int[][] arr = new int[4][];
		arr[0] = new int[5];
		arr[1] = new int[5];
		arr[2] = new int[5];
		arr[3] = new int[5];
		
		
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr[i].length; ++j) {
				arr[i][j] = 1;
				
			}
		}
		for(int i =0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}

}
