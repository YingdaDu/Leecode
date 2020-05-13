class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;

    }

    private void traverse(TreeNode root, List<Integer> res, int depth) {
        if(root == null) {
            return;
        }
        //every level only add one node
        if (res.size() == depth) {
            res.add(root.val);
        }

        traverse(root.right, res, depth+1);
        traverse(root.left, res, depth+1);
    }

    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (i == 0) res.add(cur.val);

                if(cur.right != null) queue.add(cur.right);
                if(cur.left != null) queue.add(cur.left);

            }
        }
        return res;

    }
}

