
public class DivideTest {
	public static void main(String[] args) {
		int base = 2;
		int exp = 10;
		int result = pow3(base,exp);
		System.out.println(result);
		//int result = Math.pow(2,10);
	}
	static int pow3(int base, int exp) {
		if(exp == 0) {
			return 1;
		}
		if(exp == 1) {
			return base;
		}
		int num = pow3(base, exp/2);
		if(exp % 2 == 0) {
			return num* num;
		}
		else {
			return num*num*base;
		}
	}

	static int pow2(int base, int exp) {
		if(exp==0)
			return 1;		
		if(exp==1){
			return base;
		}
		return base * pow2(base, exp-1);
	}
	private static int pow(int base, int exp) {
		int result = 1;
		for(int i =0; i<exp; ++i) {
			result = result * base;
		}
		return result;
	}

}
