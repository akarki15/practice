package BinaryTree;

import java.util.ArrayList;

public class BinaryTree {
	public Node root;

	public BinaryTree(Node n) {
		root = n;
	}
	/* NEEDS DEBUGGING!
	public void addNodes(double... values){
		ArrayList<Node> nodeList = new ArrayList<>();
		for (double d: values){			
			nodeList.add(new Node(d));
		}
		addNodes(nodeList);
	}
	public void addNodes(ArrayList<Node> nodeList) {
		add(root, nodeList, 0);
	}

	private void add(Node n, ArrayList<Node> nodeList, int index) {
		if (index> nodeList.size()-1){
			return;
		}else{
			n.left = nodeList.get(index);						
		}
		index++;
		
		if (index> nodeList.size()-1){
			return;
		}else{
			n.right = nodeList.get(index);						
		}
		add(n.left, nodeList, index);
		add(n.right, nodeList, index+2);
	}
	
	public void printTree(){
		printTree(root);
	}
	private void printTree(Node n){
		if (n==null) return;
		System.out.println(n.value);
		printTree(n.left);
		printTree(n.right);					
	}*/
}
