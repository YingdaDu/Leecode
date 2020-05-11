class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null) return null;
        //for leaf root
        if (root.left == null && root.right == null) {
            return root;
        }

        //recursively flatten
        TreeNode leftTail = this.flattenTree(root.left);
        TreeNode rightTail = this.flattenTree(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }


}