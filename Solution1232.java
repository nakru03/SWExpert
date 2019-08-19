import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1232 {

	static class Node1 {
		int idx;
		String data;
		Node1 left;
		Node1 right;
		
		Node1(String data){
			this.data = data;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<1; ++t) {
			int V = Integer.parseInt(br.readLine());			
			Node1[] tree = new Node1[V+1];
			for(int i=0; i<V; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.countTokens()==4) {
					int idx = Integer.parseInt(st.nextToken());
					String data = st.nextToken()+st.nextToken()+st.nextToken();
					tree[idx] = new Node1(data);
				}
				else {
					int idx = Integer.parseInt(st.nextToken());
					String data = st.nextToken();
					tree[idx] = new Node1(data);
				}				
			}
			System.out.println("#"+(t+1)+" "+(int)inOrder(tree, 1));
		}
					

	}
	static double inOrder(Node1[] tree, int idx) {
		if(idx >= tree.length) return 0;
		
		if(tree[idx].data.charAt(0) == '+') {
			return inOrder(tree, tree[idx].data.charAt(1)-'0') + inOrder(tree, tree[idx].data.charAt(2)-'0');			
		}
		else if(tree[idx].data.charAt(0) == '-') {
			return inOrder(tree, tree[idx].data.charAt(1)-'0') - inOrder(tree, tree[idx].data.charAt(2)-'0');			
		}
		else if(tree[idx].data.charAt(0) == '*') {
			return inOrder(tree, tree[idx].data.charAt(1)-'0') * inOrder(tree, tree[idx].data.charAt(2)-'0');			
		}
		else if(tree[idx].data.charAt(0) == '/') {
			return inOrder(tree, tree[idx].data.charAt(1)-'0') / inOrder(tree, tree[idx].data.charAt(2)-'0');			
		}
		else return Integer.parseInt(tree[idx].data);
	}

}
