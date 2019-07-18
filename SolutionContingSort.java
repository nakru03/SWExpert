import java.util.Arrays;
import java.util.Scanner;

/*
 * 카운팅소트
 * 시간 복잡도 : O(n+k) n은 리스트의 길이 k는 정수의 최대값. 
 * 공간 복잡도 : 크다 배열을 3개나 잡아야함.
 * 카운팅 소트는 k가 n보다 커버리면 의미가 없어진다.
 * 원리 : 1. counts 라는 새로운 배열 크기는 정수최대값인 k만큼 잡고 각 수의 갯수를 index에 누적.
 * 		2. count[i], count[i+1] = count[i]+count[i+1] 과 같이 누적.
 * 		3. data와 동인한 tmp 배열에 count[1]의 값  temp[count[1]의 값]에 값을 삽입.
 *
 * 
 */
public class SolutionContingSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<arr.length; ++i) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for(int i=0; i<arr.length; ++i) {
			if(max<arr[i])
				max = arr[i];
		}
		
		System.out.println(Arrays.toString(countSort(arr,max)));
	}

	private static int[] countSort(int[] arr, int max) {
		int size = max+1; //counts는 0부터 max까지 이므로 1더 있어야함.
		int[] counts = new int[size];
		int[] temp = new int[arr.length];
		
		for(int i=0; i<arr.length; ++i) {
			counts[arr[i]]++;
		}
		System.out.println(Arrays.toString(counts));
		for(int i=0; i<counts.length-1; ++i) {
			counts[i+1] = counts[i] + counts[i+1];
		}
		System.out.println(Arrays.toString(counts));
		for(int i=0; i<arr.length; ++i) { // 0->arr.length까지 하면 length와 비교하기 위해 계속 length를 call하기 때문에 최적화엔 좋지않다. int i = arr.length 에서 0으로 감소 하는것이 더효율적.
			temp[counts[arr[i]]-1] = arr[i];
			counts[arr[i]]--;
		}
		return temp;
	}

}
