
public class RecursionTest {
	
	public static void main(String[] args) {
		//1부터 10까지의 숫잘 출력하라.
		//printNum(10);
		//printNum1(10);
		//1부터 10까지의 합을 구하는 재귀메소드를 생성하라
		//printSum(10,0);
		//임의의 자연수 값의 각 자라의 합을 구하여 출력하라.
		//doDigitSum(12345,0);
		//int num = factorial(0);
		//피보나치 수열 1,1,2,3,5,8...;
		//int num = fibo(8);
		//System.out.println(num);
		//특정 자리수의 2진수 문자열의 모든 경우를 출력하라
		//2자리 00, 01, 10, 11
		//3자리 000, 001, 010,011,100,101,110,111
		doMakeBinary(3,"");

	}

	private static void doMakeBinary(int size, String result) {
		if(size<1) {
			System.out.println(result);
			return; 
		} 
		doMakeBinary(size-1,result+"0");
		doMakeBinary(size-1,result+"1");
	}

	private static int fibo(int num) {
		if(num == 2)
			return 1;
		if(num == 1)
			return 1;
		return fibo(num-1)+fibo(num-2);
	}

	private static int factorial(int num) {
		if(num<=1) {
			return 1;
		}		
		return num*factorial(num-1);
	}

	private static void doDigitSum(int num, int sum) {
		if(num/10==0) {
			sum+=num;
			System.out.println(sum);
			return;
		}
		sum += num%10;
		doDigitSum(num/10,sum);
	}

	private static void printSum(int i, int sum) {
		
		if(i<1) {
			System.out.println(sum);
			return;
		}			
		sum+=i;
		printSum(i-1,sum);
	}
	private static int printSum1(int start) {
		if(start == 10) {
			return start;
		}
		return start + printSum1(start+1);
	}

	private static void printNum1(int num) {
		//base case 기저.
		if(num<1)
			return;
		System.out.println(11-num);
		
		printNum1(num-1);
	}

	private static void printNum(int num) {
		for(int i=1; i<=num; ++i) {
			System.out.println(i);
		}
	}

}
