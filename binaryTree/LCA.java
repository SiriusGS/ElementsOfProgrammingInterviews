Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

// A brute-force approach is to see if the nodes are in different immediate subtrees of the root, or
// if one of the nodes is the root.

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null) {
            return root;
        }
        
        if (left != null) {
            return left;
        }
        
        if (right != null) {
            return right;
        }
        
        return null;
}


//variant:when nodes have parent pointers, compute the LCA

/*  A brute-force approach is to store the nodes on the search path from the root to one of the nodes
in a hash table. Then we go up from the second node, stopping as soon as we hit a node in the hash
table. The time and space complexity are both O(h)
The improvement is to find the depth of two nodes, if they are not the same depth, we move the deeper
node to the same depth and perform the tandem upward movement.
The first common node we hit is the LCA.   */

public class LowestCommonAncestor {
  // @include
  public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                        BinaryTree<Integer> node1) {
    int depth0 = getDepth(node0), depth1 = getDepth(node1);
    // Makes node0 as the deeper node in order to simplify the code.
    if (depth1 > depth0) {
      BinaryTree<Integer> temp = node0;
      node0 = node1;
      node1 = temp;
    }
    // Ascends from the deeper node.
    int depthDiff = Math.abs(depth0 - depth1);
    while (depthDiff-- > 0) {
      node0 = node0.parent;
    }

    // Now ascends both nodes until we reach the LCA.
    while (node0 != node1) {
      node0 = node0.parent;
      node1 = node1.parent;
    }
    return node0;
  }

  private static int getDepth(BinaryTree<Integer> node) {
    int depth = 0;
    while (node.parent != null) {
      ++depth;
      node = node.parent;
    }
    return depth;
  }