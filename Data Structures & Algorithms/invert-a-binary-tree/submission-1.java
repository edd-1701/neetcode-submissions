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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        helper(root);

        return root;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }


            final var tmpLeft = node.left;

            node.left = node.right;
            node.right = tmpLeft;


        helper(node.left);
        helper(node.right);

    }
}
