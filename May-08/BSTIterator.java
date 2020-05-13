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
class BSTIterator {

    ArrayList<Integer> sortedList;
    int index;

    public BSTIterator(TreeNode root) {
        this.sortedList = new ArrayList<>();
        this.index = -1; // point to smallest element in BST
        this.inorderTraverse(root);
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        this.inorderTraverse(root.left);
        this.sortedList.add(root.val);
        this.inorderTraverse(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return this.sortedList.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.sortedList.size();
    }
}
