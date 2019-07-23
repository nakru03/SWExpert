package com.ssafy.algo;
/*
 * 빌딩 세우기.
 */
import java.util.Scanner;

public class Solution13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] dx = {1, 1, 0,-1,-1,-1, 0, 1};//우하좌상 대각선포함
		int[] dy = {0, 1, 1, 1, 0,-1,-1,-1};
		
		for(int t = 0; t<tc; ++t) {
			int n = sc.nextInt();
			int max = 0;
			String [][] land = new String[n][n]; //init
			int[][] building = new int[n][n];
			
			for(int i=0; i<land.length; ++i) {
				for(int j=0; j<land.length; ++j) {
					land[i][j] = sc.next();
				}
			}
			
			for(int i=0; i<land.length; ++i) {
				for(int j=0; j<land.length; ++j) {
					boolean flag=true;
					if(land[i][j].equals("G")) continue;
					for(int k = 0; k<8; ++k) {
						int ty = i + dy[k]; //target
						int tx = j + dx[k];
						
						if(ty<0||ty>=land.length||tx<0||tx>=land.length) continue;//바운더리 체크.
						else if(land[ty][tx].equals("G")) {
							building[i][j]=2;
							flag = false; //주변에 G발견 flag false.
						}							
						
					}
					if(flag) {
						for(int l=0; l<n; ++l) {
							if(land[i][l].equals("B"))
								building[i][j]++;
							if(land[l][j].equals("B"))
								building[i][j]++; //높이 올리기.						
						
						}
						building[i][j]--; //자기자신 2번 더해서 1빼기
					}
					
				}
			}
			for(int i=0; i<building.length; ++i) {
				for(int j=0; j<building.length; ++j) {
					if(max<building[i][j])
						max = building[i][j];
				}
			}
			System.out.println("#"+(t+1)+" "+max);
		}
		
	}

}
