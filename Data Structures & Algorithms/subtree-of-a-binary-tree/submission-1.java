/*

    traverse the tree until I find the start node

*/

class Solution {  
    private boolean subtreeMatch = false;
    private TreeNode subRoot;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.subRoot = subRoot;
        traverse(root);
        return subtreeMatch;
    }

    private void traverse(TreeNode node) {
        if (node == null || subtreeMatch) {
            return;
        }

        if (node.val == subRoot.val && matchingTrees(node, subRoot)) {
            subtreeMatch = true;
        }

        traverse(node.left);
        traverse(node.right);
    }

    private boolean matchingTrees(TreeNode node, TreeNode target) {
        if (node == null || target == null) {
            return node == target;
        }

        if (node.val != target.val) {
            return false;
        }

        return matchingTrees(node.left, target.left) &&
            matchingTrees(node.right, target.right);
    }
}
