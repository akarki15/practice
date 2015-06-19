package LinkedList;


public class Node {
	public String name;
	public Node next;

	public Node(String v) {
		name = v;
	}

	public Node() {
	}
	// Creates n nodes and returns starting node
	public static Node createSequence(int n){		
		Node node = new Node ("1");
		Node startNode = node;
		for (int i =2; i<=n;i++){
			node.next = new Node(""+i);
			node = node.next;
		}
		return startNode; 				
	} 
	
	public static void printNodes(Node A) {
		System.out.print(A.name + ", ");
		if (A.next != null)
			printNodes(A.next);
	}
	
	public String toString(){		
			return this.name;
					
				
	}
}