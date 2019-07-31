
public class PowerSetTest2 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		flags = new boolean[arr.length];
		doPowerSet(arr,0,arr.length);
	}

	private static void doPowerSet(int[] arr,int depth, final int MAX_SIZE) {
		//종료, 할일, 재귀호출.
		if(depth == MAX_SIZE) {
			printArr(arr);
			return;
		}
		flags[depth] = true;
		doPowerSet(arr, depth+1, MAX_SIZE);//선택했을때
		flags[depth] = false;
		doPowerSet(arr, depth+1, MAX_SIZE);//선택안됬을때
		
	}
	private static void printArr(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0; i<arr.length; ++i) {
			if(flags[i])
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static boolean[] flags = null;
}
