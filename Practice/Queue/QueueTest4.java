import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueTest4 {

	public static void main(String[] args) {
		//SQueue q = new SQueue();
		PriorityQueue<Character> q = new PriorityQueue<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		q.offer('A');
		q.offer('B');
		q.offer('D');
		q.offer('C');
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

}
