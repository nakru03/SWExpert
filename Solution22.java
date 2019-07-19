package com.ssafy.algo;
/*
 * 소금쟁이 소금쟁이 3번 뛰고 2번뛰고 1번뜀. 뛸때마다 도착위치에 있는지 Check.
 */
import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		
		for(int t=0; t<tc; ++t) {
			int n = sc.nextInt();
			int[][] board = new int[n][n];
			int strider = sc.nextInt();
			int count = 0;
			boolean live = false;
			int[] dirSave = new int[strider]; //소금쟁이 넘버와 인덱스의 일치.
			int[] xSave = new int[strider];
			int[] ySave = new int[strider];
			
			for(int i=0; i<strider; ++i) {				
				ySave[i] = sc.nextInt();
				xSave[i] = sc.nextInt();
				dirSave[i] = sc.nextInt();
				board[ySave[i]][xSave[i]] = 1; //소금쟁이에게 초기위치
			}
//			for(int i=0; i<board.length; ++i) {
//				for(int j=0; j<board.length; ++j) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println();
			for(int i=0; i<strider; ++i) {
				live = jumpStrider(board,ySave[i], xSave[i], dirSave[i]);
				
				if(live == true)
					count++;
				
			}
//			for(int i=0; i<board.length; ++i) {
//				for(int j=0; j<board.length; ++j) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
			
			System.out.println("#"+(t+1)+" "+count);
		}
		

	}

	private static boolean jumpStrider(int[][] board, int i, int j, int k) {
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		int by = i; //beforXY
		int bx = j;
		for(int step=3; step>0; --step) {
			
			int ty = by+dy[k-1]*step;
			int tx = bx+dx[k-1]*step;			
			
			board[by][bx]=0; //이전위치 0
			if(ty<0 || tx<0 || tx>=board.length || ty >= board.length) return false; //바운더리탈출
			if(board[ty][tx]!=0) return false; //새 위치에 누군가 있다
			board[ty][tx] = 1; //점프 위치 1
			by = ty;
			bx = tx;
		}
		return true;
	
	}

}
