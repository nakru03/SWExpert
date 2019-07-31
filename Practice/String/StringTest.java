import java.util.Arrays;

public class StringTest {
	static class Student{
		int num;
		String name;
		@Override
		public boolean equals(Object obj) {
			return this.num == ((Student)obj).num;
		}
		
		
	}

	public static void main(String[] args) {
		
		String s = "Korea 한글 ";
		s = s+"kkk";
		String[] datas = s.split(" "); //짤랏다고 원본이 사라진게 아님 복사되서 짤라진거.
		System.out.println(s.substring(4));//substring begin index부터 end index까지 출력. end index 안적어주면 끝까지 출력.
		char[] data = s.toCharArray(); //String을 char[] 로 만들어줌.
		s=s.toUpperCase();//모두 대문자로. 단! 스트링은 원본이 변형되지 않음. 다른 메모리에 대문자 를 만들어줌 이걸 참조해줘야됨.
		s.toLowerCase();//모두 소문자로. //이렇게하면 s가 변함이 없음.
		s=s.replace('O', 'r'); //replace 는 char만 변경
		s=s.replaceAll("KrREA", "한국");//replaceAll은 스트링을 변환
		System.out.println(s.charAt(3));//문자열의 index자리의 char 반환.
		System.out.println(s);
		s = String.valueOf(123); //기본형을 스트링 객체로 만들어줌.
		s = 123+"";//같은결과지만 이방법을 많이 쓴다.
		System.out.println(Arrays.toString(datas));
		
		int num = Integer.parseInt("100",2); //뒤의 인자는 진수표현인자 100을 2진으로 볼것인가 10진으로 볼것인가
		System.out.println(num);
		
		
//		Student s1 = new Student();
//		Student s2 = new Student();
//		
//		s1.num = 1;
//		s2.num = 1;
//		
//		System.out.println(s1.equals(s2));
//		
//		String s = new String("korea");
//		String s1 = "korea";
//		System.out.println(s1.equals(s));
//		System.out.println(s1 == s);
//		String name =null;
//		System.out.println("임꺽정".equals(name)); // 얘는 널포인트 에러안뜸
//		System.out.println(name.equals("임꺽정")); //널포인트 에러가 뜸
	
		
	}

}
