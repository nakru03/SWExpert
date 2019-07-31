
public class FindTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "java coding algo";
		String p = "cod";
		//int idx = t.indexOf(p); //p찾아서 인덱스 리턴.
		//int idx = t.indexOf(p,6);//처음부터 아니라 6인덱스뒤애서 부터찾음
		int idx = t.lastIndexOf(p);//뒤에서 부터 찾음
		//int idx = findString(t,p);
		System.out.println(idx != -1 ? "찾음":"못찾음");
		System.out.println(idx);

	}

	private static int findString(String t, String p) {
		char[] trr = t.toCharArray();
		char[] prr = p.toCharArray();
		int tSize = trr.length;
		int pSize = prr.length;
		
		int idx = -1;
		for(int i = 0; i<=tSize-pSize; ++i) {//찾고자하는 패턴이 없으면 pSzie 만큼 탐색안해도됨.
			boolean flag = true;
			for(int j=0; j<pSize; ++j) {
				if(trr[i+j]!=prr[j]) {
					flag = false;
					break;
				}						
			}
			if(flag) {
				idx  = i;
				break;
			}
		}
		return idx;
	}

}
