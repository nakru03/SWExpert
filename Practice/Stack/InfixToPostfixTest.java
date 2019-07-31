import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
 * Infix ===>>> postfix 변환법
 *
 *	1. 토큰을 스택에 넣는다.
 *	2. 피연산자일 경우 출력하는 곳으로..
 *	3. 연산자에게 우선 순위를 부여. + - = 1 * / = 2 ( = 3     스택안의 우선순위, +- = 1 , =2 (=0 으로 설정.
 *	4. 스택의 top과 연산자의 우선순위를 비교하여 연산자가 더높으면 push
 *	5. ) 만나면 나머지 ( 만날때까지 pop…
 *	6. 또는 연산자의 우선순위가 낮을경우 높아질떄까지 나머지를 pop하여 출력.
 *	문자열이 끝나면 스택이 빌때까지 pop
 * 
 * '('의 우선순위는 제일 크기때문에 icp isp에 안넣고 '('개별처리로 항상 push하면 우선순위 하나로 풀 수도 있음.
 * 
 * 
 * postfix 계산법
 * 1. 피연산자면 push
 * 2. 연산자면 피연산자 2개 pop하고 연산한 결과 다시 push
 * 3. 수식이 끝나면 마지막 결과를 pop
 * 
 * 
 * 
 */
public class InfixToPostfixTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String exp = sc.next();
		char[] bitExp = exp.toCharArray();
		ArrayList<Character> postfix = transPostfix(bitExp);
		System.out.println(postfix.toString().replaceAll(", ",""));
		
		int result =  calcPostfix(postfix);
		System.out.println(result);

	}

	

	private static ArrayList<Character> transPostfix(char[] bitExp) {
		Stack<Character> st = new Stack<>();
		ArrayList<Character> answer = new ArrayList<>();
		
		for(int i=0; i<bitExp.length; ++i) {
			if(bitExp[i] == '*' || bitExp[i] == '/' || bitExp[i] == '+' ||
					bitExp[i] == '-' || bitExp[i] == '(' || bitExp[i] == ')') { //연산자 및 괄호 토큰이면.
				if(bitExp[i] == ')') {
					while(st.peek()!='(')
						answer.add(st.pop());//열린괄호까지 pop
					st.pop();//)제거
				}
				else if(st.isEmpty()) //스택비었을때.
					st.push(bitExp[i]);
				
				else if(icp(bitExp[i]) > isp(st.peek())) //연산자가 가 stack의 peek 보다 우선순위 높으면 push
						st.push(bitExp[i]);
				
				else {
					while(icp(bitExp[i])<isp(st.peek())) //icp가 높아질떄까지 pop.
						answer.add(st.pop());
					st.push(bitExp[i]);
				}
				
			}
			else answer.add(bitExp[i]); //피연산자일때 바로 출력
		}
		while(!st.isEmpty()) //스택이 안비었으면 전부pop.
			answer.add(st.pop());
		return answer;
	}
	
	private static int calcPostfix(ArrayList<Character> postfix) {
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<postfix.size(); ++i) {
			int opr1 = 0;
			int opr2 = 0;
			if(postfix.get(i) == '*') {
				opr2 = st.pop();
				opr1 = st.pop();
				st.push(opr1 * opr2);
			}
			else if(postfix.get(i) == '/') {
				opr2 = st.pop();
				opr1 = st.pop();
				st.push(opr1 / opr2);
			}
			else if(postfix.get(i) == '+') {
				opr2 = st.pop();
				opr1 = st.pop();
				st.push(opr1 + opr2);
			}
			else if(postfix.get(i) == '-') {
				opr2 = st.pop();
				opr1 = st.pop();
				st.push(opr1 - opr2);
			}
			else st.push(postfix.get(i)-'0');			
		
		}
		
		return st.pop();
	}
	
	//icp
	private static int icp(char c) {
		int icp = -1;
		switch(c) {
		case '*':
			icp = 2;
			break;
		case '/':
			icp = 2;
			break;
		case '+':
			icp = 1;
			break;
		case '-':
			icp = 1;
			break;
		case '(':
			icp = 3;
			break;
		default:
			icp = -1;
		}
		return icp;
		
	}
	//isp
	private static int isp(char c) {
		int isp = -1;
		switch(c) {
		case '*':
			isp = 2;
			break;
		case '/':
			isp = 2;
			break;
		case '+':
			isp = 1;
			break;
		case '-':
			isp = 1;
			break;
		case '(':
			isp = 0;
			break;
		default:
			isp = -1;
		}
		return isp;
		
	}

}
