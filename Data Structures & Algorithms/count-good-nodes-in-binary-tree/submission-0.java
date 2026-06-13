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

    private int traverse(TreeNode node, int ceilingVal) {
        if (node == null) {
            return 0;
        }

        var result = node.val >= ceilingVal ? 1 : 0;

        final var newCeiling = Math.max(ceilingVal, node.val);
        result += traverse(node.left, newCeiling);
        result += traverse(node.right, newCeiling);

        return result;
    }
}
