import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1229 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for(int i=0; i<10; ++i) {
			ArrayList<Integer> code = new ArrayList<>();			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j) {
				code.add(Integer.parseInt(tokenizer.nextToken()));
			}
			int command = Integer.parseInt(br.readLine());
			tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<command; ++j) {
				String command1 = tokenizer.nextToken();
				if(command1.equals("I")) {
					int index = Integer.parseInt(tokenizer.nextToken());
					int count = Integer.parseInt(tokenizer.nextToken());		
					ArrayList<Integer> addnum = new ArrayList<>();
					for(int k=0; k<count; ++k) {						
						addnum.add(Integer.parseInt(tokenizer.nextToken()));
					}
					insert(code, index, addnum);
				}
				else if(command1.equals("A")) {
					int count = Integer.parseInt(tokenizer.nextToken());		
					ArrayList<Integer> addnum = new ArrayList<>();
					for(int k=0; k<count; ++k) {						
						addnum.add(Integer.parseInt(tokenizer.nextToken()));
					}
					added(code, addnum);
				}
				else{
					int index = Integer.parseInt(tokenizer.nextToken());
					int count = Integer.parseInt(tokenizer.nextToken());	
					
					delete(code, index, count);
				}
			}
			System.out.print("#"+(i+1)+" ");
			for(int j=0; j<10; ++j) {
				System.out.print(code.get(j)+" ");
			}
			System.out.println();
		}
	}

	private static void added(ArrayList<Integer> code, ArrayList<Integer> addnum) {
		for(int j=0; j<addnum.size(); ++j)
			code.add(addnum.get(j));
		
	}

	private static void delete(ArrayList<Integer> code, int index,int count) {
		for(int i=0; i<count; ++i) {
			code.remove(index);
		}
	}

	private static void insert(ArrayList<Integer> code, int index, ArrayList<Integer> addnum) {
		for(int i=0; i<addnum.size(); ++i) {
			code.add(index+i, addnum.get(i));
		}		
	}

}
