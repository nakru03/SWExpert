/*
 * 원리: makeset을 통해 자기자신을 가지는 집합을 만듬
 * 		unionset을 통해 서로 다를경우 대표하는 집합을 설정하고 이들을 부모자식으로 연결
 * 		findset을 통해 부모를 찾아 올라감. 단 부모의 부모를 찾으면서 기존자식을 바로 최종 부모랑 연결.
 * 
 */
public class DisJointSetTest {
	static int[] parent;
	public static void main(String[] args) {
		int maxSize = 10;
		parent = new int[maxSize];
		makeSet(parent);
		unionSet(3,4);
		int p = findSet(3);
		System.out.println(findSet(3));
		System.out.println(findSet(4));
	}
	static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x != y) {
			parent[y] = x;
		}
	}
	private static int findSet(int x) {
		if(x == parent[x]) {//자기가 자기자신을 가리킬때
			return x;
		}else {
			int p = findSet(parent[x]); //누구가와 이미 union상태일때
			parent[x] = p;
			return p;
		}		
		
	}

	private static void makeSet(int[] parent) {
		for(int i=0; i<parent.length; ++i) {
			parent[i] = i; //자기가 자기 자신을 가리킨다.
		}
		
	}

}
