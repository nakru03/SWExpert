/*
 * 20190724
 * 비트 연산자 테스팅
 */
public class test {
	public static void main(String[] args) {
		//비트연산자
		//7=>00000000 00000000 00000000 00000111
		//13=> 00001101
		//-1=> 11111111 모든 비트가 1이면 -1임.
		
		int a = 7;
		int b = 13;		
		int c = a ^ b;
		
		c = ~a; //0은1로 1은0으로 0000111
							// 1 111000 앞자리 사인비트
							// 2의 보수법은 1의 보수를 취하고 1더함
							//1 001000 따라서 -8이 출력		
		c= 1000* 23; //연산속도는 위가 빠름. 1000을 23번 더함. 23을 1000번더함.
					//그러나 컴파일러가 대소관계 비교해서 더하기때문에 우리는 못느낌.
		c= 23*1000;
				
		c= a*1024;
		c=a<<10; //같은값이지만 위의값보다 비트연산이 훨씬빠름.
		System.out.println(c);
		//왼쪽으로 한비트씩이동할때마다 *2씩됨.
		//오른쪽 한비트이동시 /2됨
		c=a<<35; //인트는 32비트인데 35이동시키면?
		c=a<<35%32;//자바c는 32를 나눈 나머지만큼 내부적으로 이동시키때문에 a<<3과 같음.
		a = -7; //11111000 
		c = a>>1; //양수때와 음수때의 값이 달라짐.
		//오른쪽쉬프트 댈때 채워지는 비트는 부호비트와 같다. >>>세개짜리는 그냥 비트나열로보고 0이들어온다.
		System.out.println(c);
		
		c = 0b0010011; //0b 붙이면 2진법 사용가능.
		
		int d = c & 0b00010000; //4번째 비트가 1인지 0인지 판별.
		//          =0x08
		if((c & 0x08) != 0) {
			System.out.println("켜짐");
		}else {
			System.out.println("꺼짐");
		}
		//byte<short,char(2byte)<int(4)<long(8byte)<float(4byte)<double(8byte)
		//short
		//-31768~31767
		//char(유니코드 때메 2바이트 부호 표현X)
		//0~65535
		int n = 10;
		int num = 1<<n;
		//1을 n번 쉬프트 하면 2의n승이된다.	
		System.out.println(num);
	}

}
