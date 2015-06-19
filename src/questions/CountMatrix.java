package questions;

import BinaryTree.BinaryTree;
import BinaryTree.Node;
/*Given a tree, WAP such that a matrix is generated so that:

    Tree:
       1
      / \
     2   3
     |  / \
     4 5   6

      1 2 3 4 5 6
    1 0 1 1 1 1 1
    2 0 0 0 1 0 0
    3 0 0 0 0 1 1
    4 0 0 0 0 0 0
    5 0 0 0 0 0 0
    6 0 0 0 0 0 0*/

public class CountMatrix {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new Node(1));
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(4);
		bt.root.right = new Node(3);
		bt.root.right.left = new Node (5);
		bt.root.right.right = new Node(6);
		generateMatrix(bt.root);		
	}
	
	private static void getMaxNum(Node n){
		
	}
	
	private static void generateMatrix(Node n) {
		
		
	}
}
