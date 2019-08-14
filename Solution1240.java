import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1240 {
	static char[][] codes;
	static final String[] check = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111","0001011"}; //암호
	static int startY;
	static int startX;
	static ArrayList<Integer> code = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			codes = new char[N][M];
			
			for(int i=0; i<N; ++i) {
				codes[i] = br.readLine().toCharArray();
			}
			//뒤에서부터 1찾기
			out:for(int y = N-1; y>=0; --y) {
				for(int x=M-1; x>=0; --x) {
						if(codes[y][x] == '1') {
							startY = y;
							startX = x;
							break out;
					}						
				}
			}
			//뒤에서 부터 암호를 숫자로 변환해서 code에 저장.
			for(int i=0; i<8; ++i) {
				codeToNum();
				startX = startX - 7;
			}
			Collections.reverse(code); //code 뒤집기
			
			int sum = 0;
			if(((code.get(0) + code.get(2) + code.get(4) + code.get(6))*3
					+ (code.get(1)+code.get(3)+code.get(5)) + code.get(7)) % 10 == 0){
					for(int i=0; i<code.size(); ++i) {
						sum+=code.get(i);
					}
					System.out.println("#"+(t+1) +" "+sum);
			}
			else
				System.out.println("#"+(t+1) + " " + 0);
			
			code.clear();
		}
	}

	private static void codeToNum() {
		String num = "";
		for(int i=0; i<7; ++i) {
			num += codes[startY][startX-i];
		}
		num = new StringBuffer(num).reverse().toString(); //뒤집기..
		for(int i=0; i<10; ++i) {
			if(num.equals(check[i])) {
				code.add(i);
			}
		}
	}

}
