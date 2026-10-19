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
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 0);

        return result;
    }

    private int helper(TreeNode node, int steps) {
        if (node == null) {
            return 0;
        }

        final var left = helper(node.left, steps);
        final var right = helper(node.right, steps);

        if ((left + right) > result) {
            result = left + right;
        }

        return 1 + Math.max(left, right);
    }
}
