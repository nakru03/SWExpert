import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreePrefix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int V = Integer.parseInt(br.readLine());
		String[] graph = new String[(int) Math.pow(2, V)];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String parent;
		String child;
		parent = st.nextToken();
		child = st.nextToken();
		graph[1] = parent;
		graph[2] = child;		
		int idx=-1;
		while(st.hasMoreElements()) {
			parent = st.nextToken();
			child = st.nextToken();
			for(int i=1; i < graph.length; ++i) {
				if(graph[i].equals(parent)) {
					idx = i;
					break;
				}
			}
			idx = idx*2;
			if(graph[idx] == null) {
				graph[idx] = child;
			}
			else {
				graph[idx+1] = child;
			}
		}
		preOrder(graph, 1);
	}

	private static void preOrder(String[] graph, int level) {
		
		if(level >= graph.length) {
			return;
		}		
		if(graph[level] == null) {
			return;
		}
		System.out.println(graph[level] + " ");
		preOrder(graph, level*2);
		preOrder(graph, level*2+1);
	}
	
}
