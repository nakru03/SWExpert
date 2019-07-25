import java.util.Scanner;
import java.util.Stack;


public class Solution5432 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; ++t) {
			Stack<Character> st = new Stack<>();
			int result = 0;
			String iron = sc.next();
			char[] ironArr = iron.toCharArray();			
			for (int i = 0; i < ironArr.length; ++i) {
				if (ironArr[i] == '(') {
					st.push(ironArr[i]);
				}
					// System.out.println(st.size()); //레이저
				if (ironArr[i] == ')' && ironArr[i - 1] == '(') {
					st.pop();
					result += st.size();
						System.out.print(st.size()+" ");
					}
				if (ironArr[i] == ')' && ironArr[i - 1] == ')') {// 레이저 아닐때 stack -1 res+1
					st.pop();
					result += 1;
					// System.out.print(st.size()+" ");
				}

			}
			System.out.println("#"+(t+1) + " " + result);
		}

	}

}
