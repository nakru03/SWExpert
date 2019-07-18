
public class ArrayTest2 {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int cnt = 0;
		for(int i=0; i<5; ++i) {
			for(int j=0; j<5; ++j) {
				arr[i][j] = ++cnt;
			}
		}

		for(int i=0; i<5; ++i) { //입출력은 나눠라! //행우선
			for(int j=0; j<5; ++j) {
				System.out.print(arr[j][i]+"\t"); //**[i][j] 행우선 [j][i] 열우선**
			}
			System.out.println();
		}
		int idxj = 0;
		int flag = 1;
		for(int i=0; i<5; ++i) { //입출력은 나눠라! //행우선
			for(int j=0; j<5; ++j) {
				System.out.print(arr[i][idxj]+"\t"); //**[i][j] 행우선 [j][i] 열우선**
				idxj += flag;
			}
			flag *= -1;
			System.out.println();
		}
	}

}
