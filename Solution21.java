package com.ssafy.algo;

import java.util.Scanner;

public class Solution21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();		
		
		for(int t=0; t<tc; ++t) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			int strider = sc.nextInt();
			int count = 0;
			int[] dirSave = new int[strider]; //소금쟁이 x y 위치 dir 초기화.
			int[] xSave = new int[strider];
			int[] ySave = new int[strider]; 
			
			for(int i=0; i<strider; ++i) {
				ySave[i] = sc.nextInt();
				xSave[i] = sc.nextInt();
				dirSave[i] = sc.nextInt();				
			} //소금쟁이 초기화 .

			for(int i=0; i<strider; ++i) {
				board[ySave[i]][xSave[i]] = i+1;
				count = jumpStrider(board,ySave[i], xSave[i], dirSave[i]);
				if(count!=0)//count가 0이 아닐 경우 break;
					break;				
			}
			
			for(int i=0; i<board.length; ++i) {
				for(int j=0; j<board.length; ++j) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}//변한 후 프린팅.
			
			System.out.println("#"+(t+1)+" "+count);
		}
	}

	private static int jumpStrider(int[][] board, int i, int j, int k) {
		int[] dx = {0,1}; //하, 우
		int[] dy = {1,0};
		int by = i; //beforXY
		int bx = j;
		for(int step=3; step>0; --step) {//소금쟁이 스탭	 3 2 1		
			int ty = by+dy[k-1]*step;
			int tx = bx+dx[k-1]*step;			
			
			if(ty<0 || tx<0 || tx>=board.length || ty >= board.length) break; //바운더리 나가면 break;
			if(board[ty][tx]!=0) return board[by][bx]; //새 위치에 누군가 있다 리턴
			board[ty][tx] = board[by][bx]; //흔적 남기기.
			by = ty;
			bx = tx;
		}
		return 0;	//아무것도 안하면 0 리턴.
	}
}
