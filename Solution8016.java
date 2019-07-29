package swexpert_Algo;

import java.util.Scanner;

public class Solution8016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		
		for(int i=0; i<tc; ++i) {
			long stage = sc.nextInt();
			System.out.print("#"+(i+1) + " ");
			long a=(stage*(stage-2)*2+3);
			long b=2*stage*stage-1;
			if(stage==1)
				System.out.print(1 + " ");
			else if(stage==2)
				System.out.print(3 +" ");
			else {
				System.out.print(a +" ");
			}
				
			
			System.out.println(b);
		}
	}

}
//          1     		1일떄 1개 0,0
//        3 5 7   		2일떄 4개1,3
//     9 11 13 15 17  	3일떄 9개4,8
// 19 21 23 25 27 29 31 4일때 16 9, 15
//33 35 37 39 41 43 45 47 49 5층..
 