import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1873 {
	
	static int Y;
	static int X;
	static char[][] board;
	static String command;
	static Tank tank;
	static final int[] dy = {-1,1,0,0};
	static final int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			Y = Integer.parseInt(s[0]);
			X = Integer.parseInt(s[1]);
			board = new char[Y][X];
			
			for(int y=0; y<Y; ++y) {
				board[y] = br.readLine().toCharArray();
			}
			
			findmyTank();
			
			
			int N = Integer.parseInt(br.readLine());
			command = br.readLine();
			for(int i=0; i<command.length(); ++i) {
				doCommand(command.charAt(i));
			}
			
			sb.append("#"+(t+1)+" ");
			for(int y=0; y<Y; ++y) {
				for(int x=0; x<X; ++x) {
					sb.append(board[y][x]);
				}
				sb.append("\n");
				
			}
			
			System.out.print(sb);
			sb.setLength(0);
		}
	}
	
	
	private static void findmyTank() {
		for(int y=0; y<Y; ++y) {
			for(int x=0; x<X; ++x) {
				if(board[y][x]=='^') {
					tank = new Tank(y,x,0);
				}
				else if(board[y][x]=='v') {
					tank = new Tank(y,x,1);
				}
				else if(board[y][x]=='<') {
					tank = new Tank(y,x,2);
				}
				else if(board[y][x]=='>') {
					tank = new Tank(y,x,3);
				}
			}
		}		
	}


	private static void doCommand(char com) {
		switch(com) {
		case 'U' :			
			tank.dir = 0;
			int ny = tank.y + dy[tank.dir];
			int nx = tank.x + dx[tank.dir];
			
			if(ny<0 || nx <0 || ny>=Y || nx>=X) {
				board[tank.y][tank.x] = '^';
				break;
			}
			
			if(board[ny][nx] == '.') {
				board[tank.y][tank.x] = '.';
				board[ny][nx] = '^';
				tank.y = ny;
				tank.x = nx;
			}
			
			else {
				board[tank.y][tank.x] = '^';
			}
			
			break;
		case 'D' :
			tank.dir = 1;
			ny = tank.y + dy[tank.dir];
			nx = tank.x + dx[tank.dir];
			
			if(ny<0 || nx <0 || ny>=Y || nx>=X) {
				board[tank.y][tank.x] = 'v';
				break;
			}
			
			if(board[ny][nx] == '.') {
				board[tank.y][tank.x] = '.';
				board[ny][nx] = 'v';
				tank.y = ny;
				tank.x = nx;
			}
			
			else {
				board[tank.y][tank.x] = 'v';
			}
			
			break;
		case 'L' : 
			tank.dir = 2;
			
			ny = tank.y + dy[tank.dir];
			nx = tank.x + dx[tank.dir];
			
			if(ny<0 || nx <0 || ny>=Y || nx>=X) {
				board[tank.y][tank.x] = '<';
				break;
			}
			
			if(board[ny][nx] == '.') {
				board[tank.y][tank.x] = '.';
				board[ny][nx] = '<';
				tank.y = ny;
				tank.x = nx;
			}
			
			else {
				board[tank.y][tank.x] = '<';
			}
			
			break;
		case 'R' :
			tank.dir = 3;
			
			ny = tank.y + dy[tank.dir];
			nx = tank.x + dx[tank.dir];
			
			if(ny<0 || nx <0 || ny>=Y || nx>=X) {
				board[tank.y][tank.x] = '>';
				break;
			}
			
			if(board[ny][nx] == '.') {
				board[tank.y][tank.x] = '.';
				board[ny][nx] = '>';
				tank.y = ny;
				tank.x = nx;
			}
			
			else {
				board[tank.y][tank.x] = '>';
			}
			
			break;
		case 'S' :
			int count = 0;
			while(true) {
				count++;
				ny = tank.y + dy[tank.dir]*count;
				nx = tank.x + dx[tank.dir]*count;
				
				if(ny<0 || nx <0 || ny>=Y || nx>=X)	break;
				if(board[ny][nx]=='#') break;
				
				if(board[ny][nx]=='*') {
					board[ny][nx] = '.';
					break;
				}
			}
			
			break;
		}
		
	}
	
	static class Tank{
		int y;
		int x;
		int dir;
		
		public Tank(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

}
