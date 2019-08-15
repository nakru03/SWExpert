import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution1244 {
	static ArrayList<Integer> num = new ArrayList<>();
	static int[] count;
	static int max;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<tc; ++t) {
			max = Integer.MIN_VALUE;
			boolean duplicateCheck = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] tmp = st.nextToken().toCharArray();
			for(int i=0; i<tmp.length; ++i) {
				num.add(tmp[i]-'0'); //ArrayList<Integer> 로 변환
			}
			
			//중복 체크를 위해 
			count = new int[10];
			for(int i=0; i<num.size(); ++i) {
				count[num.get(i)]++;

			}
			
			for(int i=0; i<count.length; ++i) {
				if(count[i]>=2)
					duplicateCheck = true;
			}
			
			int chance = Integer.parseInt(st.nextToken());
			//순열을 통해 max가 될 수 있는 모든 case 확인 chance가 숫자자리수 - 1 보다작을때까지
			if(chance<num.size()-1) {
				doPerm(0, 0, chance);
				
			}
			// 그 이후는 정렬.
			else {
				if(chance == num.size()-1) {
					Collections.sort(num, Collections.reverseOrder());
					max = arrToInt();					
				}
				else {
					if((chance - num.size()-1) % 2 == 0) { //남은 횟수가 짝수일때
						Collections.sort(num, Collections.reverseOrder());
						max = arrToInt();
					}
					else {//남은 횟수가 홀수지만 중복이 존재할때.
						if(duplicateCheck) {
							Collections.sort(num, Collections.reverseOrder());
							max = arrToInt();
						}
						else { //중복 수없으면 1의자리 10의 자리스왑
							Collections.sort(num, Collections.reverseOrder());
							swap(num.size()-1, num.size()-2);
							max = arrToInt();
						}						
					}
				}
				
			}
			
			
			System.out.println("#"+(t+1)+ " " +max);
			num.clear();
			
		}

	}
	
	private static void doPerm(int start, int depth, int chance) {
		
		if(depth == chance) {
			int tmp = arrToInt();
			max = Math.max(max, tmp);			
			return;
		}
		for(int i=start; i<num.size(); ++i) {
			for(int j=start; j<num.size(); ++j) {
				if(i==j) continue;
				swap(i,j);
				doPerm(i, depth+1 , chance);
				swap(i,j);
			}
		}
		
	}
	
	private static void swap(int i, int j) {
		Collections.swap(num, i, j);		
		
	}
	
	private static int arrToInt() {
		int value = 0;
		int idx = 0;
		for(int i=num.size()-1; i>=0; --i) {
			value += num.get(idx) * (int)Math.pow(10, i);
			idx++;
		}
		return value;
	}

	

}
