import java.util.Scanner;

public class Solution1217 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=0; t<10; ++t) {
			int n = sc.nextInt();
			int base = sc.nextInt();
			int exp = sc.nextInt();
			int result = pow(base,exp);
			System.out.println("#"+(t+1)+" "+result);
			
		}
	}

	private static int pow(int base, int exp) {
		if(exp == 0) //기저
			return 1;
		if(exp == 1 )
			return base;
		int num = pow(base, exp/2);
		if(exp%2 == 0)
			return num*num;
		else
			return num*num*base;
	}
}
