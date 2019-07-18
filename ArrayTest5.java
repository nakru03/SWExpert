import java.util.Random;

public class ArrayTest5 {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		Random rd = new Random();
		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr.length; ++j) {
				arr[i][j] = rd.nextInt(100);
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		for(int y=0; y<arr.length; ++y) {
			int sum = 0;
			for(int x=0; x<arr.length; ++x) {
				for(int dir=0; dir<4; ++dir) {
					int ty = y+dy[dir];
					int tx = x+dx[dir];
					if(tx>=arr.length || tx<0 || ty >= arr.length || ty<0) continue;
					sum += Math.abs(arr[ty][tx]-arr[y][x]);
				}
				System.out.println("arr"+"["+y+"]"+"["+x+"]:"+arr[y][x]+"합계:"+sum);
			}
		}

	}

}
