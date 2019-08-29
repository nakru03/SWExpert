import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MSTPrimeTest {
	static ArrayList<Node>[] vertexList;
	public static void main(String[] args) {
		int V = 7;
		vertexList=new ArrayList[V+1];
		
		//인접리스트 초기화
        for(int i=0;i<V+1;i++) {
            vertexList[i]=new ArrayList<Node>();
        }
        int start, end, weight;
        Node av, av2;
        start = 5;
        end = 3;
        weight = 18;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);
        
        start = 1;
        end = 2;
        weight = 21;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 2;
        end = 6;
        weight = 25;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 0;
        end = 2;
        weight = 31;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 0;
        end = 1;
        weight = 32;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 3;
        end = 4;
        weight = 34;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 5;
        end = 4;
        weight = 40;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 2;
        end = 4;
        weight = 46;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 0;
        end = 6;
        weight = 51;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 4;
        end = 6;
        weight = 51;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);

        start = 0;
        end = 5;
        weight = 60;
        
        av=new Node(end, weight);
        av2=new Node(start, weight);
        vertexList[start].add(av);
        vertexList[end].add(av2);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] v = new boolean[V+1];
        int begin = 0;
        v[begin] = true;
        
        Iterator<Node> it = vertexList[begin].iterator();
        
        while(it.hasNext()) {
        	pq.offer(it.next());
        }
        Node tmp;
        int result = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
        	tmp = pq.poll();
        	
        	int idx = tmp.vertex;
        	if(v[idx]) continue;
        	
        	result += tmp.weight;
        	v[idx] = true;
        	cnt++;
        	
        	if(cnt == V-1) break;
        	
        	Iterator<Node> it2 = vertexList[idx].iterator();
        	while(it2.hasNext()) {
            	pq.offer(it2.next());
            }
        }
        System.out.println(result);
        
	}
	//한점에서 vertex로 가는 가중치
	static class Node implements Comparable<Node> {
	    int vertex;
	    int weight;
	    public Node(int vertex,int weight) {
	        // TODO Auto-generated constructor stub
	        this.vertex=vertex;
	        this.weight=weight;
	    }
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight>o.weight? 1 : -1;
		}
	}
}
