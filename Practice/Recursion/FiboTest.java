
public class FiboTest {
	static int[] nums;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int su = 45;
		nums = new int[su+1];
	//0값으로 초기화가 자동설정.
		nums[1] = 1;
		nums[2] = 1;
		int num = fibo(su);
		System.out.println(num);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static int fibo(int num) {
		// TODO Auto-generated method stub
		if(num ==1 || num ==2) {
			return nums[num];
		}
		if(nums[num] != 0) {
			return nums[num];
		}
		return nums[num]=fibo(num-1)+fibo(num-2);
	}

}
