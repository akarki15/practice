package questions;

import java.util.ArrayList;
import java.util.HashMap;

import sun.misc.Sort;
import BinaryTree.BinaryTree;
import BinaryTree.Node;

/*
 * Given a Binary Search Tree with integers at every node and an integer k,
 * write code that decides whether or not there exists two nodes a and b such
 * that a+b=k
 * 
 * 		  4
 *	 	 / \ 
 * 	   3     5
 * 	  / \   / \
 * 	  1	3.5 4.5	 7
 */

/*SOlution  O(N) time O (N) space*/
public class APlusBEqualsK {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(new Node (4));
		bt.root.left = new Node (3);
		bt.root.right = new Node (5);
		
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(3.5);
		
		bt.root.right.left = new Node(4.5);
		bt.root.right.right = new Node(7);
		
		System.out.println(findNodes(bt, 7));
	}

	
	
	private static boolean findNodes(BinaryTree bt, double i) {
		ArrayList<Double> sortedList = inOrderTraverse(bt);
		HashMap<Double, Double> hash = new HashMap<>();
		for (double d: sortedList){
			if (d > i)
				break;
			if (hash.get(i-d)!=null){
				System.out.println(d+ ", "+ (i-d));
				return true;
			}else {
				hash.put(d, d);
			}
		}
		return false;
	}


	private static ArrayList<Double> inOrderTraverse(BinaryTree bt) {
		ArrayList <Double> list = new ArrayList<>();
		inOrder(bt.root,list );
		return list;
	}

	private static void inOrder(Node n, ArrayList<Double> list) {
		if (n.left!=null){
			inOrder(n.left, list);
		} 
		list.add(n.value);
		if (n.right!=null){
			inOrder(n.right, list);
		}
	}	
}
