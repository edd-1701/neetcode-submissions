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
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);

        return result;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }

        traverse(node.left, level + 1);

        result.get(level).add(node.val);

        traverse(node.right, level + 1);
    }
}
