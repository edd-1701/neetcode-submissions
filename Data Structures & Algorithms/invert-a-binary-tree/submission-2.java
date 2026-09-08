class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertHelper(root);
        return root;
    }

    private void invertHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        final var tmpLeft = node.left;
        node.left = node.right;
        node.right = tmpLeft;

        invertHelper(node.left);
        invertHelper(node.right);
    }
}
