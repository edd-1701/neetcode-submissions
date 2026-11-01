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
    final List<Integer> result = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        traverse(root, 0);

        return result;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (result.size() == level) {
            result.add(null);
        }

        result.set(level, node.val);

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
