package com.ssafy.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution1223 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int t=0; t<10; ++t) {
			int length = sc.nextInt();
			String exp = sc.next();
			char[] bitExp = exp.toCharArray();
			ArrayList<Character> tmp = postfixTrans(bitExp);
			//System.out.println(tmp);
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
				st.push(op1+op2);
			}
			else if(tmp.get(i) == '*') {
				op2 = st.pop();
				op1 = st.pop();				
				st.push(op1*op2);
			}
			else {
				st.push(tmp.get(i) - '0');
			}
				
			
		}
		
		return st.pop();
		
		
	}

	private static ArrayList<Character> postfixTrans(char[] bitExp) {
		Stack<Character> st = new Stack<>();
		ArrayList<Character> tmp = new ArrayList<>();
		for(int i=0; i<bitExp.length; ++i) {
			if(bitExp[i] == '+' || bitExp[i] == '*') {
				if(st.isEmpty())
					st.push(bitExp[i]);
				else if(isp(bitExp[i]) <= isp(st.peek())) {
					while(!st.isEmpty()&&isp(bitExp[i]) <= isp(st.peek()))
						tmp.add(st.pop());
					st.push(bitExp[i]);
				}
				else st.push(bitExp[i]);
			}
			
			else tmp.add(bitExp[i]);
				
		}
		while(!st.isEmpty()) {
			tmp.add(st.pop());
		}
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
