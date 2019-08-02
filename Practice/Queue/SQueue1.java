/*
 * queue front rear를 -1로
 * enqueu -> front틑 그대로 rear를 ++
 * deqeue -> front ++ 제거.
 * 
 * linear queue
 */
public class SQueue1 {
	char [] datas;
	int maxSize;
	int front,rear;
	
	public SQueue1() {
		this(2);
	}
	public SQueue1(int maxSize) {
		datas = new char[maxSize];
		this.maxSize = maxSize;
		front = rear = -1;
	}
	public char qPeek() throws MyQueueException {
		if(isEmpty()) {
			throw new MyQueueException("큐가비었습니다.");
		}
		return datas[front];
	}
	public char deQueue() throws MyQueueException {
		if(isEmpty()) {
			throw new MyQueueException("큐가비었습니다.");
		}
		return datas[++front];
	}
	public void enQueue(char item)throws MyQueueException {
		if(isFull()) {			
			throw new MyQueueException();
		}
		datas[++rear]  = item;
	}
	public int size() {
		return rear - front;
	}
	public boolean isFull() {
		return rear == maxSize -1;
//		boolean flag = false;
//		if(rear == maxSize -1 ) {
//			flag = true;
//		}
//		return flag;
	}
	public boolean isEmpty() {
		return front == rear;
	}

}
