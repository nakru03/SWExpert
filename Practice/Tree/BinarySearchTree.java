
public class BinarySearchTree {
	Node root;
	boolean isEmpty() {
		return root == null;
	}
	
	void inOrder(Node node) {
		
		if(node == null) return;
		
		inOrder(node.left);
		System.out.println(node.data + " ");
		inOrder(node.right);
	}
	
	void insert(int data) {
		Node node = new Node(data);
		if(root == null) {
			root = node;
			return;
		}
		Node tmp = root;
		while(tmp != null) {			
			if(tmp.data > data ) {
				if(tmp.left == null) {
					tmp.left = node;
					break;
				}
				else {
					tmp = tmp.left;
				}
			}else if(root.data < data) {
				if(tmp.right == null) {
					tmp.right = node;
					break;
				}else {
					tmp = tmp.right;
				}
			}else {
				break;
			}
		}
		
		
	}
	
	boolean search(int key) {
		boolean flag = false;
		if(root == null) {
			return false;
		}
		Node tmp = root;
		while(tmp != null) {
			if(root.data > key ) {
				tmp = tmp.left;
			}else if(root.data < key) {
				tmp = tmp.right;
			}else {
				return true;
			}
		}
		
		return flag;
	}
}
