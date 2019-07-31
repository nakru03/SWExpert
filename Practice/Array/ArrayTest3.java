
public class ArrayTest3 {

	public static void main(String[] args) {
		int[][] arr = {{3,12,5,8},
					   {3,4,7,9},
					   {2,8,6,9},
					   {3,5,20,3}};
		//지정된 위치의 상하 좌우 값을 구하여라.
		//1,2위치에서 시작.
//		int y=0; int x=0; //boundary condition 넘어가면 에러. 1. 인덱스가 -가되면 경계를판단해야함.
//						  //2. 메모리를 기존 데이터보다 1칸씩 넓게 잡으면 boundary가 넓어 에러가 안남.
//		int sum = 0;
//		sum = arr[y-1][x]+arr[y+1][x]+arr[y][x-1]+arr[y][x+1];
//		System.out.println(sum);
		
		//모든 지점에서 상하좌우값의 합 중에서 가장 큰 값과 그때의 위치를 찾아 찍으시오.
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int mx = -1, my = -1;
		int[] dx = {1, 0, -1, 0}; //우하좌상이 빨리 풀릴때가 많음.
		int[] dy = {0, 1, 0, -1};

		for(int i=0; i<arr.length; ++i) {
			for(int j=0; j<arr.length; ++j) {
				sum = 0;
				for(int k=0; k<4; ++k) {
					int ty = i +dy[k];
					int tx = j +dx[k];
					if(tx >= arr.length || ty >= arr.length || tx<0 || ty<0) continue; //boundary condition
					sum += arr[ty][tx];
				}
				if(max<sum) {
					max = sum;
					mx = j;
					my = i;
				}
					
					
			}
			
		}
		System.out.println(max+" " + mx+ " "+my);
		
	}

}
