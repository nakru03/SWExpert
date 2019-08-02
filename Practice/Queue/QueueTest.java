import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SQueue1 q = new SQueue1(2);
		SQueue2 q = new SQueue2(5);
		Queue<Integer> q1 = new LinkedList<>();
		
		try {
			q.enQueue('A');
		} catch (MyQueueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			q.enQueue('B');
		} catch (MyQueueException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		try {
			q.enQueue('C');
		} catch (MyQueueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			q.enQueue('D');
		} catch (MyQueueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(q.isFull());
		System.out.println(q.size());
	}

}
