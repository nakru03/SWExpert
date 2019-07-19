package com.ssafy.algo;
/*
 * 사람 점프 배팅.
 */
import java.util.Scanner;

public class Solution32 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; ++t) {
			int ySize = sc.nextInt();
			int xSize = sc.nextInt();
			int n = sc.nextInt();			
			int[][] board = new int[ySize+1][xSize+1];
			int[] yStart = new int[ySize+1];
			int[] xStart = new int[xSize+1];
			int[] chance = new int[101];
			int total = 0;
			total = -1000 * n; //사람 수만큼 참가비 받고 시작.
			
			for(int i=1; i<=ySize; ++i) {
				for(int j=1; j<=xSize; ++j) {
					board[i][j] = sc.nextInt();
					
				}
			}//보드 초기화

			
			for(int i=0; i<n; ++i) {
				yStart[i] = sc.nextInt();
				xStart[i] = sc.nextInt();
				chance[i] = sc.nextInt();
			}//사람에 대한 정보
			
			int trap = sc.nextInt();
			for(int i=0; i<trap; ++i) {
				int y = sc.nextInt();
				int x = sc.nextInt();			
				board[y][x] = 0;
			}//함정 초기화
			//System.out.println();
			
			for(int i=0; i<n; ++i) {
				total += playGame(board, xStart[i], yStart[i], chance[i]);
				
			}
			System.out.println("#"+(t+1)+" "+total);
		}	

	}

	private static int playGame(int[][] board, int x, int y, int chance) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1}; //4방향.
		int bx = x;
		int by = y;		
		int prize = 0;		
		for(int i=0; i<chance; ++i) {
			int dir = board[by][bx]/10; //방향
			int dis = board[by][bx]%10;	//거리	
			int ty = by+dy[dir-1]*dis; //새좌표 = 기존좌표 + 방향*거리
			int tx = bx+dx[dir-1]*dis;
			if(ty<1 || tx<1 || ty>=board[x].length || tx>= board.length || board[ty][tx]==0) return 0; //바운더리
			bx = tx; //이전위치 새로 갱신
			by = ty;
			
			
			
		}
		prize += 100 * board[by][bx];
		return prize;
	}

}
