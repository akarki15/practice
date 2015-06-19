package questions.wayfair;

import LinkedList.Node;

// http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/

public class SwapKthNode {
	public static void main(String[] args) {
		Node n = Node.createSequence(9);
		Node.printNodes(n);
		swap(n, 5);
	}

	static void swap(Node node, int n) {
		int count = 1;
		// Store the two nodes to swap
		Node node1 = null;
		Node node2 = null;

		Node node1temp = null; // Node before Node1
		Node node2temp = null; // NOde before Node2

		// Shenanigan to give us the kth node from last.
		boolean beginTracking = false;

		Node startNode = node;
		Node lastNode = null; // stores the node before "node"
		while (node != null) {
			// Keep track of last node
			if (count == 2)
				lastNode = startNode;
			else if (count > 2)
				lastNode = lastNode.next;

			System.out.println(node.name + " ____ " + lastNode);
			// update node1
			if (count == n) {
				node1 = node;
				node1temp = lastNode;
				beginTracking = true;
			}

			if (beginTracking) {
				if (node2 == null) {
					node2 = startNode;
				} else {
					node2 = node2.next;
				}
				node2temp = lastNode;
			}

			node = node.next;
			count++;
		}

		System.out.println();

		System.out.println(node1.name);
		System.out.println(node1temp.name);
		System.out.println(node2.name);
		System.out.println(node2temp.name);
	}

}
