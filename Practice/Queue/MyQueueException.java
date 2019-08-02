
public class MyQueueException extends Exception{
	public MyQueueException(){
		this("큐가 가득참");
	}
	public MyQueueException(String message) {
		super(message);
	}

}
