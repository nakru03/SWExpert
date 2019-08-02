/**
 * 
 * @author SangHyung Kim
 * LinkedList Queue
 *
 */
public class SQueue3 {
	Node front;
	Node rear;
	int size;
	
	class Node{
		char data;
		Node next;
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public void enQueue(char c) {
		Node node = new Node();
		node.data = c;
		if(front == null) {
			front = rear = node;
		}else {
			rear.next = node;
			rear = node;
		}
		size++;
	}
	public int size() {
		return size;
	}
	
	public char deQeue() {
		if(isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		char tmp = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		size--;
		return tmp;
	}
	
	public char qPeek() {
		if(isEmpty()) {
			System.out.println("empty");
			return '\u0000';
		}
		
		return front.data;
	}
}
