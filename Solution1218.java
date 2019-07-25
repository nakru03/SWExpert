import java.util.Scanner;
import java.util.Stack;

public class Solution1218 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; ++t) {
			int	maxSize = sc.nextInt();
			String s = sc.next();
			char[] charArr = s.toCharArray();
			System.out.println("#"+(t+1)+" " + (checkBrace(charArr) ? "1" : "0"));
		}

	}
	public static boolean checkBrace(char[] checkArr) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<checkArr.length; ++i) {
			switch(checkArr[i]) {
			case'(':
				stack.push(checkArr[i]);
				break;
			case'{':
				stack.push(checkArr[i]);
				break;
			case'[':
				stack.push(checkArr[i]);
				break;
			case'<':
				stack.push(checkArr[i]);
				break;
				
			case')':
				if(stack.isEmpty()) {
					return false;
				}				
				else {
					if(stack.pop()!='(')
						return false;
					else
						break;
				}				
			case'}':
				if(stack.isEmpty()) {
					return false;
				}				
				else {
					if(stack.pop()!='{')
						return false;
					else
						break;
				}
			case']':
				if(stack.isEmpty()) {
					return false;
				}				
				else {
					if(stack.pop()!='[')
						return false;
					else
						break;
				}
			case'>':
				if(stack.isEmpty()) {
					return false;
				}				
				else {
					if(stack.pop()!='<')
						return false;
					else
						break;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		else return true;
	}

}
