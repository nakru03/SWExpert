/**
 * 
 * @author SangHyung Kim
 * circular Queue
 *
 */
public class SQueue2 {
	char [] datas;
	int maxSize;
	int front,rear;
	
	public SQueue2() {
		this(2);
	}
	public SQueue2(int maxSize) {
		datas = new char[maxSize];
		this.maxSize = maxSize;
		front = rear = 0;
	}
	public char qPeek() throws MyQueueException {
		if(isEmpty()) {
			throw new MyQueueException("큐가비었습니다.");
		}
		return datas[(front+1) % maxSize];
	}
	public char deQueue() throws MyQueueException {
		if(isEmpty()) {
			throw new MyQueueException("큐가비었습니다.");
		}
		front = (front+1) % maxSize;		
		if(front == rear) { //큐의 인덱스를 초기화해서 땡기는게 좋다.
			front = rear = 0;
		}
		return datas[front];
	}
	public void enQueue(char item)throws MyQueueException {
		if(isFull()) {			
			throw new MyQueueException();
		}
		rear = (rear + 1) % maxSize;
		datas[rear]  = item;
	}
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	public boolean isFull() {
		return (rear+1) % maxSize == front;
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
