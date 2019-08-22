import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; ++i) {
			String s = br.readLine();
			
			int count=0;
			
			while(true) {
				boolean flag = true;
				count++;
				String s1=null;
				String s2=null;				
				 s1 = s.substring(0,count);
				 //System.out.println(s1);
				 s2 = s.substring(count,s1.length()*2);
				 //System.out.println(s2);
				 if(s1.equals(s2)) {
					 String tmp = s.replaceAll(s1, "");
					 String[] split = tmp.split("");
					 for(int j=0; j<split.length; ++j) {
						 if(s1.contains(split[j])) {
							 flag=true;
						 }
						 else
							 flag=false;
					 }
					 //System.out.println(tmp);
					 if(tmp.length()!=0 && !flag) {
						count++;
						continue;
					 }
					 else {
						 System.out.println("#"+(i+1)+" " + s1.length());							
						 break;
					 }
						
				}
				 
			}
			
		}
	}

}
