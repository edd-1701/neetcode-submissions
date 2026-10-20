class Solution {
    private List<Integer> pList = new ArrayList<>();
    private List<Integer> qList = new ArrayList<>();

    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p, pList);
        helper(q, qList);

        return pList.equals(qList);
    }

    private void helper(TreeNode node, List<Integer> list) {
        list.add(node == null ? null : node.val);

        if (node == null) {
            return;
        }

        helper(node.left, list);
        helper(node.right, list);

    }
}
