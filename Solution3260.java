import java.util.Scanner;
import java.util.Stack;

public class Solution3260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=0; t<tc; ++t) {			
			String s1 = sc.next();
			String s2 = sc.next();
			String answer = "";
			if(s1.length()<s2.length()) {
				String tmp = s2;
				s2 = s1;
				s1 = tmp;
			}			
			
			
			char[] first = s1.toCharArray();
			char[] second = s2.toCharArray();
			
			Stack<Integer> st1 = new Stack<>();
			Stack<Integer> st2 = new Stack<>();
			
			for(int i=0; i<first.length; ++i) {
				st1.push(first[i]-'0');
			}
			for(int i=0; i<second.length; ++i) {
				st2.push(second[i]-'0');
			}
			boolean olim = false;
			int minLen = Math.min(st1.size(), st2.size());
			
			while(minLen>0) {			
				int result =st1.pop()+st2.pop();
				if(olim) {
					result++;
					olim=false;
				}				
				if(result>9) {
					result = result%10;
					olim = true;
				}
				answer+=result;	
				minLen--;
			}
			//////////대소비교
			while(!st1.isEmpty()) {
				int tmp=st1.pop();
				if(olim) {
					tmp++;
					olim=false;
				}
				if(tmp>9) {
					tmp = tmp%10;
					olim = true;
				}
				answer+=tmp;	
				
			}
			if(olim) answer+=1;
			String answerRe = new StringBuilder(answer).reverse().toString();
			System.out.println("#"+(t+1)+" "+answerRe);
		}
		
	}
}
