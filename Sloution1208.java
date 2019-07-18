import java.util.Scanner;

public class Solution1208 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; ++i) {

			int dump = sc.nextInt();
			int result = 0;
			int[] boxes = new int[100];
			for (int j = 0; j < boxes.length; ++j) {
				boxes[j] = sc.nextInt();
			}

			for (int j = 0; j <= dump; j++) {

				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIndex = Integer.MIN_VALUE;
				int minIndex = Integer.MAX_VALUE;

				for (int k = 0; k < boxes.length; ++k) {

					if (max < boxes[k]) {
						max = boxes[k];
						maxIndex = k;
					}

					if (min > boxes[k]) {
						min = boxes[k];
						minIndex = k;
					}

				}			
				boxes[maxIndex]--;
				boxes[minIndex]++;
				result = max - min;
				if (result < 2) {
					break;
				}
			}

			System.out.println("#" + (i + 1) + " " + result);

		}

	}

}