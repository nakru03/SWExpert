import java.util.Arrays;

public class PowerSetTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};//늘어나면 method1 동작불가능
		flags = new boolean[arr.length];
		//method1(arr);
		method2(arr);

	}
	//핵심.
	private static void method2(int[] arr) {
		int maxSize = 1 << arr.length;
		for(int i=0; i<maxSize; ++i) {
			Arrays.fill(flags, false);
			for(int j=0; j<arr.length; ++j) {
				if((i & 1<<j)!=0) {
					flags[j] = true;
					//System.out.println(arr[j]);
				}/*else {
					flags[j]=false;
				}*/
			}
			printArr(arr);
		}
		System.out.println(maxSize);
	}
	static boolean[] flags = null;
	
	static void printArr(int[] arr) {
		for(int i = 0; i<flags.length; ++i) {
			if(flags[i]) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		
	}
	
	static void method1(int[] arr) {
		for(int i=0; i<2; ++i) {
			flags[0] = i==0 ? true : false;
			for(int j=0; j<2; ++j) {
				flags[1] = j==0 ? true : false;
				for(int k=0; k<2; ++k) {
					flags[2] = k==0 ? true : false;
					for(int l=0; l<2; ++l) {
						flags[3] = l==0 ? true : false;
						printArr(arr);
					}
				}
			}
//			if(i==0) {
//				flags[0] = true;
//			}else {
//				flags[0] = false;
//			}
		}
	}

}
