package questions;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountNodesOfTree {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(0);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(0);
		TreeNode t5 = new TreeNode(0);
		TreeNode t6 = new TreeNode(0);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.left = t6;
		System.out.println(Solution.countNodes3(t2));

	}
}

class Solution {
	// O(n): Traverses every node. Gives time out on leet.
	static int countNodes1(TreeNode root) {
		int count = 1;
		if (root == null) {
			return count;
		}

		if (root.left != null) {
			count += countNodes1(root.left);
		}
		if (root.right != null) {
			count += countNodes1(root.right);
		}
		return count;
	}

	// O(logn* logn) Recursive: Still gives Time out error
	static int countNodes2(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null) {
			return 1;
		}

		if (root.right == null) {
			return 1 + countNodes2(root.left);
		}

		int lDepth = findDepth(root.left);
		int rDepth = findDepth(root.right);

		if (lDepth == rDepth) {
			return (int) Math.pow(2, lDepth + 1) - 1 + countNodes2(root.right);
		} else {
			return (int) Math.pow(2, rDepth + 1) + countNodes2(root.left);
		}

	}

	// O(logn*logn) Iterative
	static int countNodes3(TreeNode root) {
		int nodeCount = 0;
		while (root != null) {
			// Count the root itself
			nodeCount++;
			
			if (root.left == null) {
				break;
			} else if (root.right == null) {
				nodeCount++;
				break;
			} else {
				int lDepth = findDepth (root.left);
				int rDepth = findDepth(root.right);
				
				if (lDepth == rDepth){
					nodeCount += (int) Math.pow(2, lDepth + 1) - 1;
					root = root.right;
				} else {
					nodeCount += (int) Math.pow(2, rDepth + 1);
					root = root.left;
				}
			}
			
		}
		return nodeCount;
	}

	static int findDepth(TreeNode n) {

		if (n.left == null) {
			return 0;
		} else {
			return 1 + findDepth(n.left);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
