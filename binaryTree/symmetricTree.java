**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || checkIsSymmetric(root.left, root.right);
    }
    
    private boolean checkIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.val == right.val 
                && checkIsSymmetric(left.left, right.right) 
                && checkIsSymmetric(left.right, right.left);
        }
        return false;
    }
}


// First thought, we can compute its mirror image and seeing if the mirror image is equal to the original tree.
// the time and space complexity will be O(n)
// we can improve it by not computing the mirrored subtrees. as soon as a pair of subtree fails the test,
// we can short circuit the check to false   the time and space will be O(n) and O(h) h is the height

