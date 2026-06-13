class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        final var listP = new ArrayList<Integer>();
        final var listQ = new ArrayList<Integer>();

        traverse(p, listP);
        traverse(q, listQ);
        return listP.equals(listQ);
    }

    private void traverse(TreeNode node, List<Integer> values) {
        values.add(node == null ? null : node.val);

        if (node == null) {
            return;
        }
        traverse(node.left, values);
        traverse(node.right, values);
    }
}
