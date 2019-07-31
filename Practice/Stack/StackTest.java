
public class StackTest {
	public static void main(String[] args) {
		Sstack stack = new Sstack(5);
		String check = "([)]";
		char[] checkArr = check.toCharArray();
		System.out.println(checkBrace(checkArr));
		
	
	}
	
	
	public static boolean checkBrace(char[] checkArr) {
		boolean flag = false;
		char tmp ='\u0000';
		Sstack stack = new Sstack(checkArr.length);
		for(int i=0; i<checkArr.length; ++i) {
			switch(checkArr[i]) {
			case'(':
				stack.push(checkArr[i]);
				break;
			case'{':
				stack.push(checkArr[i]);
				break;
			case'[':
				stack.push(checkArr[i]);
				break;
			case')':
				tmp = stack.pop();
				if(stack.isEmpty()&&tmp!='(') {
					flag = false;
					return flag;
				}
				stack.pop();
				break;
			case'}':
				tmp = stack.pop();
				if(stack.isEmpty()&&tmp!='{') {
					flag = false;
					return flag;
				}
				stack.pop();
				break;
			case']':
				tmp = stack.pop();
				if(stack.isEmpty()&&tmp!=']') {
					flag = false;
					return flag;
				}
				stack.pop();
			}
			
		}
		if(!stack.isEmpty()) flag = false;
		else flag = true;
		return flag;
	}
	
	
	
	
	
	
	static class Sstack{
		//최대 사이즈
		private int size;
		private char[] datas = null;
		private int top;
		public Sstack(int size) {
			this.size = size;
			datas = new char[size];
			top = -1;
		}
		public boolean isEmpty() {
			return top < 0;
//			if(top==-1)
//				return true;
//			return false;
		}
		public int size() {
			return top+1;
		}
		public boolean isFull() {
			return top==size-1;
		}
		public void push(char c) {
			if(isFull()) {
				System.out.println("full");
				return;			
			}
			top++;
			datas[top] = c;
		}
		public char pop() {			
			if(isEmpty()) {
				//System.out.println("empty");
				return '\u0000';
			}

			return datas[top--];
			
		}
		public char peek() {
			if(isEmpty()) {
				System.out.println("empty");
				return'\u0000';
			}
			return datas[top];
		}
	}

}
