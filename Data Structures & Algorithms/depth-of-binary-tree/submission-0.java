class Solution {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level > maxDepth) {
            maxDepth = level;
        }

        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}
