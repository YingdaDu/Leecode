class Solution {
    /*
    There could be two situations :

    If the node has a right child, the successor is somewhere lower in the tree,
    see red nodes on the Fig. below.

    Otherwise, the successor is somewhere upper in the tree

     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        //sucussor is one step right and then left until you can
        if (p != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        //sucssor is somewhere upper in the tree
        Stack<TreeNode> stack = new Stack<>();
        int inorder = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            //go left till you cam
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(inorder == p.val) return root;
            inorder = root.val;
            root = root.right;
        }
        return null;
    }
}