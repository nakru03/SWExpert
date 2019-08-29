
public class BSearchTest {

	public static void main(String[] args) {
		int[] arr = {2,2,2,2,2,2,2,2};
		
		int start, end;
		start = 0;
		end = arr.length;
		int mid;
		int idx =-1;
		int lSum, rSum  ;
		while(start < end ) {
			lSum = 0;			rSum = 0;
			mid = (start + end)/2;
			for(int i = start ; i < mid; i++) {
				lSum += arr[i];
			}
			if((end-start) %2 == 0) {
				for(int i = mid ; i <end; i++) {
					rSum += arr[i];
				}
				if(lSum > rSum) {					start = mid;
				}else if(lSum < rSum) {					end = mid;
				}else {					break;				}
			}else {				
				for(int i = mid ; i <end-1; i++) {
					rSum += arr[i];
				}
				if(lSum > rSum) {					start = mid;
				}else if(lSum < rSum) {					end = mid;
				}else {
					if(arr[start]!=arr[end-1]) {
						idx = end-1;
					}
					break;					
				}
				
			}
			System.out.println("sum " + lSum + " " + rSum );
			System.out.println("index : " + start + " " + end+ " " + idx );
			System.out.println("===================");

		}		
		System.out.println(idx==-1 ? idx : idx + 1);

	}

}
