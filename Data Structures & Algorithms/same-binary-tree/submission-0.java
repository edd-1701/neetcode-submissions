class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        final var listP = new ArrayList<String>();
        final var listQ = new ArrayList<String>();

        traverse(p, listP);
        traverse(q, listQ);

        // System.out.println(listP);
        // System.out.println(listQ);

        return listP.equals(listQ);
    }

    private void traverse(TreeNode node, List<String> values) {
        // if (node == null) {
        //     return;
        // }

        values.add(node == null ? "null" : String.valueOf(node.val));

        if (node == null) {
            return;
        }
        traverse(node.left, values);
        traverse(node.right, values);

    }


}
