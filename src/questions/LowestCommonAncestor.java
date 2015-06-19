/*http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
*/
package questions;

import java.util.ArrayList;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
public class LowestCommonAncestor {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new Node(1));
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		find(4, 7, bt.root);
	}

	static void find(double input1, double input2, Node root){
		ArrayList <Node> ancestors1 = new ArrayList <>();
		ArrayList <Node> ancestors2 = new ArrayList <>();
		dfs(ancestors1, root, input1);
		dfs(ancestors2, root, input2);
		for (Node n: ancestors1){
			System.out.println(n.value);
		}
		for (Node n: ancestors2){
			System.out.println(n.value);
		}
		Node a = ancestors1.get(ancestors1.size()-1);
		Node b = ancestors2.get(ancestors1.size()-1);
		if (a.value!=b.value){
			System.out.println("No common ancestor");
			return;
		}
		for (int i =ancestors1.size()-2;i>=0;i--){
			if (ancestors1.get(i).value==ancestors2.get(i).value){
				a = ancestors1.get(i);
				b = ancestors2.get(i);
			}else {
				break;
			}
		}	
		System.out.println("Lowest common ancestor :"+a.value);
		
	}

	private static boolean dfs(ArrayList <Node> ancestors, Node n, double input1) {
		if (n == null)
			return false;

		if (n.value == input1)
			return true;

		boolean found = dfs(ancestors, n.left, input1)
				|| dfs(ancestors, n.right, input1);

		if (found) {		
			ancestors.add(n);
			return true;
		} else {
			return false;
		}

	}
}
