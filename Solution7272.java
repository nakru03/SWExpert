import java.util.Scanner;

public class Solution7272 {
	static int[] abc = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				int tc = sc.nextInt();
		for(int t=0; t<tc; ++t) {
			String s = sc.next();
			String s2 = sc.next();
			char[] sArr=s.toCharArray();
			char[] sArr2=s2.toCharArray();
			
			boolean flag = checker(sArr, sArr2);
			if(!flag)
				System.out.println("#"+(t+1)+" DIFF");
			else
				System.out.println("#"+(t+1)+" SAME");
			
		}
	}

	private static boolean checker(char[] sArr, char[] sArr2) {
		boolean flag = false;
		if(sArr.length != sArr2.length)
			return flag = false;
		for(int i=0; i<sArr.length; ++i) {
			if(abc[sArr[i]-65] == abc[sArr2[i]-65]) {
				//System.out.println((int)(sArr[i]-65)+" "+((int)sArr2[i]-65));
				flag = true;
			}
			else {
				flag = false;
				break;
			}				
				
		}
		return flag;
	}

}
