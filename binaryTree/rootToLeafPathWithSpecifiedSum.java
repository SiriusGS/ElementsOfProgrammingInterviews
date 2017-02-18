public static boolean hasPathSum(TreeNode root, int targetSum) {
	return hasPathSumHelper(root, 0, targetSum);
}

public static boolean hasPathSumHelper(TreeNode root, int partialPathSum, int targetSum) {
	if (root == null) {
		return false;
	}

	partialPathSum += root.val;

	if (root.left == null && node.right == null) { //leaf
		return partialPathSum == targetSum;
	}

	// non-leaf

	return hasPathSumHelper(root.left, partialPathSum, targetSum) || hasPathSumHelper(root.right, partialPathSum, targetSum)

}

// traverse the tree, keeping track of the root-to-node path sum. The first time we encounter
// a leaf whose weight equals the target weight, we have succeeded at locating a desired leaf.
//Short circuit evaluation of the check ensures that we do not process additional leaves.
// the time complexity and space complexity are O(n) and O(h) respectively