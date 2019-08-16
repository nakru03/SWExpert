
public class BTTest {

	static class BinaryTree {
		Node root;
		Node insert(char data, Node parent, int type) {
			Node node = new Node(data);
			if(parent == null)
				root = node;
			else {
				if(type == 1) {
					parent.left = node;
				}
				else {
					parent.right = node;
				}
			}
			
			return node;
		}
		void preOrder(Node node) {
			if(node == null) {
				return;
			}
			System.out.println(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	static class Node {
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node nodeA = tree.insert('A', null, 1);
		Node nodeB = tree.insert('B', nodeA, 1);
		Node nodeC = tree.insert('C', nodeA, 2);
		Node nodeD = tree.insert('D', nodeB, 1);
		Node nodeE = tree.insert('E', nodeB, 2);
		Node nodeF = tree.insert('F', nodeC, 1);
		Node nodeG = tree.insert('G', nodeC, 2);
		Node nodeH = tree.insert('H', nodeE, 1);
		Node nodeI = tree.insert('I', nodeE, 2);
		
		tree.preOrder(tree.root);
	}
}

