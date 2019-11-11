import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution4672 {
	static String s;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; ++t) {
			 s="";
			 String[] sl = br.readLine().split("");
			 Arrays.sort(sl);
			 for(int i=0; i<sl.length; ++i) {
				 s+=sl[i];
			 }
			 String tmp;
			 for(int i=0; i<s.length(); ++i) {
				 for(int j=i+1; j<=s.length(); ++j) {
					 tmp = s.substring(i,j);
					 System.out.println(tmp);
					 pcheck(tmp);
				 }				 
			 }
			 System.out.println("#"+(t+1)+" "+(answer));
			 answer = 0;
		}
		
	}
	private static void pcheck(String tmp) {
		int mid;
		String str1="";
		String str2="";
		if(tmp.length()==1) {
			answer++;
		}
		else if(tmp.length()%2==0) {
			mid = tmp.length()/2;
			for(int i=0; i<mid; ++i) str1+=tmp.charAt(i);
			for(int i=mid; i<tmp.length(); ++i) str2+=tmp.charAt(i);
			str2 = reverseString(str2);
			if(str1.equals(str2)) answer++;
			
		}else if(tmp.length()%2==1) {
			mid = tmp.length()/2;
			for(int i=0; i<mid; ++i) str1+=tmp.charAt(i);
			for(int i=mid+1; i<tmp.length(); ++i) str2+=tmp.charAt(i);
			str2 = reverseString(str2);
			if(str1.equals(str2)) answer++;
		}
	}
	
	  public static String reverseString(String s) {
		    return ( new StringBuffer(s) ).reverse().toString();
	  }
}
