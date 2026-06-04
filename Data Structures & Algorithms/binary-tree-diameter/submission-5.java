class Solution {
    int mxi = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return mxi;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int lh = dfs(node.left);
        int rh = dfs(node.right);

        mxi = Math.max(mxi, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}