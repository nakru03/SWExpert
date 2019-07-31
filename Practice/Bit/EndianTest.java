
public class EndianTest {
	public static void main(String[] args) {
		int a = 654321;
		
//		big endian     endian
//		A  B  C  D    D  C  B  A
//		01 02 03 04   01 02 03 04
		byte[] arr = intToByteArr(a);
		int b = byteArrayToInt(arr);
		System.out.println(b);
	}
	//byte캐스팅을 하면 마지막 1바이트 만 남고 나머지 짤림
	static byte[] intToByteArr(int a) {
		byte[] res = new byte[4];
		res[0] = (byte)a; //D
		res[1] = (byte)(a>>8); //C
		res[2] = (byte)(a>>16); //B
		res[3] = (byte)(a>>24); //A
		return res;
	}
	//0 0 0 D
	//0 0 C 0
	//0 B 0 0
	//A 0 0 0
	//을 or 연산하면
	//A B C D가 나온다
	static int byteArrayToInt(byte[] arr) {
		int num = arr[3]<<24 | 
				(arr[2] & 0xff)<<16 | 
				(arr[1] & 0xff)<<8 | 
				(arr[0] & 0xff); //0b1111111 써야하는 이유 오른쪽 쉬프트는 부호비트가 들어오기떄문에 
		return num;
	}
}
