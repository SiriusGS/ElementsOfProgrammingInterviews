// Binary Tree Elements of programming 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



// test if a binary tree is height balanced 

private static class BalanceStatusWithHeight {
	public boolean balanced;
	public int height;
	public BalanceStatusWithHeight(boolean balanced, int height) {
		this.balanced = balanced;
		this.height = height;
	}
}

public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
	return checkBalanced(tree).balanced;
}

private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> root) {
	if (root == null) {
		return new BalanceStatusWithHeight(true, -1);  //base case
	}

	BalanceStatusWithHeight left = checkBalanced(root.left);
	if (!left.balanced) {
		return left;			// left subtree is not balanced
	}
	BalanceStatusWithHeight right = checkBalanced(root.right);
	if(!right.balanced) {    // right subtree is not balanced
		return right;
	}

	boolean isBalanced = Math.abs(left.height - right.height) <= 1;
	int height = Math.max(left.height, right.height) + 1;
	return new BalanceStatusWithHeight(isBalanced, height);
}

// Another approach

public static boolean isBalanced(TreeNode root) {
	return root == null || getHeight(root) != -1;
}

private int getHeight(TreeNode root) {
	if (root == null) {
		return 0;
	}
	int left = getHeight(root.left);
	int right = getHeight(root.right);

	if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
		return -1;
	}
	return Math.max(left, right) + 1;
}
 
// third approach

public static boolean isBalanced(TreeNode root) {
	if (root == null) {
		return true;
	}
	int left_Height = getHeight(root.left);
	int right_Height = getHeight(root.right);
	return Math.abs(left_Height - right_Height) <= 1 && isBalanced(root.left) && isBalanced(root.right);
}

private int getHeight(TreeNode root) {
	if (root == null) {
		return 0;
	}
	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

// time complexity: O(n)  because every node is visited once
// space complexity: O(h)  the stack height is bounded by the height of the tree
// The function call stack corresponds to a sequence of calls from the root through the unique path to the current node.

