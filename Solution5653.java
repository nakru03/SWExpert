import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.StringTokenizer;

public class Solution5653 {
	
	static int N;
	static int M;
	static int K;
	
	static int[][] board;
	static boolean[][] visited;
	static LinkedList<Cell> unActive;
	static LinkedList<Cell> active;
	
	static final int[] dy = {0,1,0,-1};
	static final int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			
			board = new int [400][400];			
			unActive = new LinkedList<>();
			active = new LinkedList<>();
			
			
			for(int y=200; y<200+N; ++y) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x=200; x<200+M; ++x) {
					board[y][x] = Integer.parseInt(st.nextToken());
					if(board[y][x] != 0) {
						unActive.add(new Cell(y,x,board[y][x], false));
						
					}
				}
			}
			
			for(int time=1; time<=K; ++time) {
				
				Iterator<Cell> it = unActive.iterator();
				while(it.hasNext()) {
					Cell curr = it.next();
					curr.life--;
					if(curr.life==-1) {							
						active.add(new Cell(curr.y, curr.x, board[curr.y][curr.x], false));
						it.remove();
						//System.out.println(active);
					}					
				}
				
				Collections.sort(active);
				Iterator<Cell> it2 = active.iterator();
				while(it2.hasNext()) {
					Cell curr = it2.next();
					if(!curr.bunsic) {
						for(int dir=0; dir<4; ++dir) {
							int ny = curr.y + dy[dir];
							int nx = curr.x + dx[dir];
							
							if(board[ny][nx]!=0) continue;
							unActive.add(new Cell(ny, nx, board[curr.y][curr.x], false));
							board[ny][nx] = board[curr.y][curr.x];							
																				
						}
						curr.life--;
						curr.bunsic = true;
						if(curr.life<=0) {
							it2.remove();
						}
					}
					else {
						curr.life--;
						if(curr.life<=0) {
							it2.remove();
						}								
					}
				}
				//print();
			}
			
			System.out.println("#"+(t+1) + " "+(unActive.size()+active.size()));
			
		}
		
	}
	static void print() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		for(int i=300; i<500; ++i) {
			for(int j=300; j<500; ++j) {
				//if(board[i][j]==0) continue;
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	static class Cell implements Comparable<Cell>{
		int y;
		int x;
		int life;
		boolean bunsic;
		
		public Cell(int y, int x, int life, boolean bunsic) {
			super();
			this.y = y;
			this.x = x;
			this.life = life;
			this.bunsic = bunsic;
		}
		@Override
		public int compareTo(Cell o) {
			return o.life-this.life;
		}
		@Override
		public String toString() {
			return "Cell [y=" + y + ", x=" + x + ", life=" + life + ", bunsic=" + bunsic + "]";
		}
		
	}

}
