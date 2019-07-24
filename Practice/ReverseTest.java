
public class ReverseTest {
	public static void main(String[] args) {
		String s = "algorithm";
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();
		//s = reverseString(s);
		System.out.println(sb);
	}

	private static String reverseString(String s) {
		if(s==null) {
			System.out.println("null포인트에러");
			return null;
		}
		char[] datas = s.toCharArray();
		int len = datas.length;
		for(int i=0; i<len/2; ++i) {
			int idx = len-1-i;
			char tmp = datas[i];
			datas[i] = datas[idx];
			datas[idx] = tmp;
		}
		return new String(datas) ;
	}
}
