import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution6808 {
	static ArrayList<Integer> deck1;
	static ArrayList<Integer> deck2;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; ++i) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			deck1 = new ArrayList<>();
			deck2 = new ArrayList<>();
			boolean[] check = new boolean[18+1];
			for(int j=0; j<9; ++j) {
				int card = Integer.parseInt(tokenizer.nextToken());
				check[card] = true;
				deck1.add(card);
			}
			for(int j=0; j<check.length; ++j) {
				if(j==0) continue;
				else if(!check[j]) deck2.add(j);
			}
			//System.out.println(deck1);
			//System.out.println(deck2);
			doPerm(0);
			System.out.println("#"+(i+1)+" "+winCount +" " + loseCount);
			winCount = 0;
			loseCount = 0;
			
		}
	}

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int deck1Score;
	static int deck2Score;
	static int winCount ;	
	static int loseCount;	
	static boolean[] visited = new boolean[9+1];
	private static void doPerm(int depth) {
		if(depth == deck2.size()) {
			//System.out.println(result);
			//비교하고 승자 골라서 count.
			for(int i=0; i<deck1.size(); ++i) {
				if(deck1.get(i)>result.get(i)) {
					deck1Score += deck1.get(i)+result.get(i);					
				}
				else deck2Score += deck1.get(i) + result.get(i);
			}			
			if(deck1Score > deck2Score)
				winCount++;
			else if(deck1Score<deck2Score)
				loseCount++;
			
			deck1Score = 0;
			deck2Score = 0;
			return;
		}
		//permutation만들기
		for(int i=0; i<deck2.size(); ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			result.add(deck2.get(i));
			doPerm(depth+1);
			visited[i] = false;
			result.remove(result.size()-1);
		}
	}

}
