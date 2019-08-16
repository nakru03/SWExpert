
public class BSTTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.search(3));
		bst.insert(7);
		bst.insert(6);
		bst.insert(5);
		bst.insert(4);
		bst.insert(4);
		bst.insert(2);
		bst.insert(1);
		bst.inOrder(bst.root);
		System.out.println(bst.search(4));
		
	}
}
