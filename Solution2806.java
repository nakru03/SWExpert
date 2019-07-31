package com.ssafy.test;

import java.util.Scanner;

public class Solution2806 {
	static int n;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; ++t) {
			count = 0;
			n = sc.nextInt();
			int[] board = new int[n];			
			nQueen(board, 0);
			System.out.println("#"+(t+1)+" " + count);
			
		}
		

	}
	
	private static void nQueen(int[] board, int depth) {		
		if(depth == n) { //기저
			count++;			
			return;   
		}
			
		for(int i=0; i<n; ++i) {
			board[depth] = i;
			if(isPromising(board,depth))			
				nQueen(board,depth+1);
		}
		

	}
	private static boolean isPromising(int[] board, int depth) {
		boolean flag = true;
		
		for(int i=0; i<depth; ++i) {
			if(board[depth]==board[i]) {
				flag = false;
				break;
			}
			if(Math.abs(board[depth]-board[i]) == depth-i) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

}
