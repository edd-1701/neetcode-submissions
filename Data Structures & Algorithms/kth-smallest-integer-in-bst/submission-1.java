class Solution {
    private int k;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);

        return result;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);

        k -= 1;
        if (k == 0) {
            result = node.val;
            return;
        }
        traverse(node.right);
    }
}