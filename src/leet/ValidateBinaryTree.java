package leet;

import java.util.ArrayList;

public class ValidateBinaryTree {
	public static void main(String[] args) {
		TreeNode n9 = new TreeNode(9);
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(5);
		TreeNode n12 = new TreeNode(5);

		n9.left = n5;
		n5.left = n3;
		n3.left = n1;

		n9.right = n12;
		n5.right = n7;
		n3.right = n4;
		System.out.println(isValidBST(n9));
	}

	public static boolean isValidBST(TreeNode root) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		if (root != null)
			return inOrderTest(root, a);
		else
			return true;
	}

	public static boolean inOrderTest(TreeNode node,
			ArrayList<Integer> inOrderList) {
		boolean answer = true;
		if (node.left != null) {
			answer = answer && inOrderTest(node.left, inOrderList);
		}

		if (inOrderList.size() > 0
				&& inOrderList.get(inOrderList.size() - 1) > node.val) {
			return false;
		}

		inOrderList.add(node.val);

		if (node.right != null) {
			answer = answer && inOrderTest(node.right, inOrderList);
		}

		return true;

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
