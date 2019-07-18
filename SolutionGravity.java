
public class SolutionGravity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = { 2, 3, 6, 2, 1, 0, 0, 0, 0 }; // 제일 길고 먼저 인덱스가 낮을수록 낙차가 큼. 자기 보다 큰수를 만나면 낙차가 멈춤.

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 9; ++i) {
			int nakcha = 0;
			for (int j = i + 1; j < 9; ++j) {
				if (data[i] > data[j]) {
					nakcha++;
					//System.out.println(nakcha);
				}

				if (max < nakcha)
					max = nakcha;
			}

		}
		System.out.println(max);
	}

}

/////////////////////////////////////////// 예제 답변.
/*import java.util.Scanner;

public class Gravity {
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cnt = N - (i + 1); // 오른쪽으로 돌리면 크기 N에서 내 인덱스+1 을 뺀게 최대 낙차
			for(int j = i + 1; j < N; j++) { 
				//내 오른쪽으로 나보다 키가 크거나 같은 친구가 있으면 최대낙차 - 1
				if(arr[j] >= arr[i])
					cnt--;
			}
			//cnt에 내 낙차 max에 현재까지 검사한 막대들 중 최대낙차
			if(max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}

}*/
