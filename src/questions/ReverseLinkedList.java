package questions;

// http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/

/*
 * input: A->B->C output; C->B->A
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		Node A = createNodes();
		printNodes(A);		
		Node C = reverse(A);
		System.out.println();
		printNodes(C);
	}
	
	static Node reverse(Node A){
		Node temp = A.next;
		A.next = null;
		return reverse(A, temp);
	}
	
	static Node reverse(Node A, Node B) {		
		if (B == null)
			return A;
		Node C = B.next;
		B.next = A;
		return reverse(B, C);
	}

	static void printNodes(Node A) {
		System.out.print(A.name + ", ");
		if (A.next != null)
			printNodes(A.next);

	}

	static Node createNodes() {
		Node D = new Node("D");
		Node C = new Node("C");
		Node B = new Node("B");
		Node A = new Node("A");
		
		A.next = B;
		B.next = C;
		C.next = D; 
		return A;
	}
}

class Node {
	public String name;
	public Node next;

	public Node(String v) {
		name = v;
	}

	public Node() {
	}
}