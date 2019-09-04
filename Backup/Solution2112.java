import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2112 {
	static int D;
	static int W;
	static int K;
	static int[][] board;
	static ArrayList<Integer> selectList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			String[] s = br.readLine().split("\\s");
			D = Integer.parseInt(s[0]);
			W = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);
			board = new int[D][W];
			
			for(int y=0; y<D; ++y) {
				s = br.readLine().split("\\s");
				for(int x=0; x<W; ++x) {
					board[y][x] = Integer.parseInt(s[x]);
				}
			}
			selectList = new ArrayList<>();
			for(int i=0; i<=D; ++i) { //D번만큼 약물투여
				dfs(0,0,i);
			}
		}
		
	}
	private static void dfs(int idx, int depth, int chemicalizing) {
		if(depth == chemicalizing) {
			
		}
		for(int i=idx; i<D; ++i) {
			selectList.add(i);
			
		}
	}

}
