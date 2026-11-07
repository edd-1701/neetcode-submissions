/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public int goodNodes(TreeNode root) {
        return traverse(root, root.val);
    }

    private int traverse(TreeNode node, int ceiling) {
        if (node == null) {
            return 0;
        }
        
        final var result = node.val >= ceiling ? 1 : 0;

        final var newCeiling = Math.max(ceiling, node.val);
        final var left = traverse(node.left, newCeiling);
        final var right = traverse(node.right, newCeiling);

        return result + left + right;
        
    }
}
