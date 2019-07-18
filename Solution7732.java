import java.util.Arrays;
import java.util.Scanner;
/*
 * 점심시간 알고리즘!
 * SWExpert 7732 시간개념.
 */
public class Solution7732 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t;
		
		t=sc.nextInt();
				
		for(int i=0; i<t; ++i) {
			String s = sc.next();
			String s2 = sc.next();
			char[] nowTime = s.toCharArray();
			int nowTimeSecond = ((int)nowTime[6])*10+nowTime[7];
			int nowTimeMinute = ((int)nowTime[3])*10+nowTime[4];;
			int nowTimeHour = ((int)nowTime[0])*10+nowTime[1];
			char[] appoTime = s2.toCharArray();
			int appoTimeSecond = ((int)appoTime[6])*10+appoTime[7];
			int appoTimeMinute = ((int)appoTime[3])*10+appoTime[4];
			int appoTimeHour = ((int)appoTime[0])*10+appoTime[1];
			int second = 0;
			int minute = 0;
			int hour = 0;			
			String hourPrint ="";
			String minutePrint="";
			String secondPrint="";
			
			hour = appoTimeHour - nowTimeHour;
			if(hour<0) {
				hour = 24-nowTimeHour+appoTimeHour;
			}
			minute = appoTimeMinute - nowTimeMinute;
			if(minute<0) {
				minute = 60-nowTimeMinute+appoTimeMinute;
				hour--;
				if(hour<0)
					hour+=24;
			}
			second = appoTimeSecond - nowTimeSecond;
			if(second<0) {
				second = 60-nowTimeSecond+appoTimeSecond;
				minute--;
			}
			
			if(hour<10)
				hourPrint = "0"+hour;
			else
				hourPrint = hour+"";
			if(minute<10)
				minutePrint = "0"+minute;
			else
				minutePrint = minute+"";
			if(second<10)
				secondPrint = "0"+second;
			else
				secondPrint = second+"";
				
			
			System.out.println(hourPrint+":"+minutePrint+":"+secondPrint);
		}
	}

}
