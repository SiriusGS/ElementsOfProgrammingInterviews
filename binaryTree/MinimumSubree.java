public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private TreeNode subtree;
    private int subtreeSum = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        helper(root);
        return subtree;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum < subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}