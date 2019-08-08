/**
 * 링크드 리스트로만든 우선순위큐
 * @author student
 *
 */
public class SQueue4 {
	Node front;
	Node rear;
	int size;
	
	
	public void offer(char data) {
		Node node = new Node();
		node.data = data;
		if(isEmpty()) {
			front = rear = node;
		} else {		// 맨앞에 넣어야하는 경우
			
			if(front.data >= node.data) {
				node.next = front;
				front = node;
			}else {  //중간에 넣어야하는 경우
				Node temp = front;
				boolean flag = true;
				while(temp.next !=null) {
					if(temp.data>node.data) {
						node.next = temp.next;
						temp.next = node;
						flag = false;
						break;
					}
					temp = temp.next;
				}
				if(flag) { //마지막에 넣어야하는경우
					rear.next  = node;
					rear = node;
				}
			}
			
			
		}
		size++;
	}
	
	
	public char poll() {
		char tmp = '\u0000';
		if(isEmpty()) {
			System.out.println("empty");
			return tmp;
		}
		char data = front.data;
		front = front.next;
		return data;

	}
	
	public char peek() {
		char tmp = '\u0000';
		if(isEmpty()) {
			System.out.println("empty");
			return tmp;
		}
		return tmp = front.data;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return front == null;
	}
	class Node{
		char data;
		Node next;
		
	}
}
