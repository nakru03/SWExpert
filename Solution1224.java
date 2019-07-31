package com.ssafy.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution1224 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0; t<10; ++t) {
			int length = sc.nextInt();
			String exp = sc.next();
			char[] bitExp = exp.toCharArray();
			ArrayList<Character> tmp = postfixTrans(bitExp);
			System.out.println(tmp);
			int result = postfixCalc(tmp);
			System.out.println("#"+(t+1)+" "+result);
			 
			
		}

	}

	private static int postfixCalc(ArrayList<Character> tmp) {
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<tmp.size(); ++i) {
			int op1 =0;
			int op2 =0;
			if(tmp.get(i) == '+') {
				op2 = st.pop();
				op1 = st.pop();
				//System.out.println("더하기실행");			
				st.push(op1+op2);
			}
			else if(tmp.get(i) == '*') {
				op2 = st.pop();
				op1 = st.pop();				
				st.push(op1*op2);
			}
			else {
				st.push(tmp.get(i) - '0');
				//System.out.println(tmp.get(i) - '0');
			}
				
			
		}
		
		return st.pop();
		
		
	}

	private static ArrayList<Character> postfixTrans(char[] bitExp) {
		Stack<Character> st = new Stack<>();
		ArrayList<Character> tmp = new ArrayList<>();
		
		for(int i=0; i<bitExp.length; ++i) {
			if(bitExp[i] == '(' | bitExp[i] == ')' |
					bitExp[i] =='*' | bitExp[i] =='+') {
				
				if(st.isEmpty()) st.push(bitExp[i]);
				
				else if(bitExp[i] == '(')
					st.push(bitExp[i]);
				
				else if(bitExp[i] ==')') {
					while(st.peek() !='(')
							tmp.add(st.pop());
					st.pop();
				}
				else if(isp(bitExp[i]) <= isp(st.peek())){
					while(!st.isEmpty() && isp(bitExp[i]) <= isp(st.peek())) {
						tmp.add(st.pop());
						//System.out.println(st.peek());
					}
											
					st.push(bitExp[i]);
				}
				else //isp > peek
					st.push(bitExp[i]);
			}
			else {
				tmp.add(bitExp[i]);
			}
		}
		while(!st.isEmpty()) //스택이 안비었으면 전부pop.
			tmp.add(st.pop());
		return tmp;
	}

	private static int isp(char c) {
		switch(c) {
		case '*':
			return 2;
		case '+':
			return 1;
		}
		return -1;
	}

}

