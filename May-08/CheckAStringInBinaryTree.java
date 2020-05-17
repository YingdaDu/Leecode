//BFS
public boolean isValidSequence(TreeNode root, int[] arr){
    Queue<TreeNode> queue = new ArrayList<>();
    queue.add(root);
    for (int i = 0; !queue.isEmpty() && i < arr.length; i++) {
        int size = queue.size(); //level size
        for (int j = 0; j < size; j++) {
            TreeNode n = q.poll();
            if (n != null && n.val == arr[i]) {
                if (i + 1 == arr.length && n.left == null && n.right == null) {
                    return true;
                }
                queue.addAll(Arrays.asList(n.left, n.right));
            }

        }

    }
    return false;
}

//DFS
public boolean isValidSequence(TreeNode root, int[] arr){
    return dfs(root, arr, 0);
}

public boolean dfs(TreeNode node, int[] arr, int index){
    if (index == arr.length - 1) {
        if (node != null && node.val == arr[index] && node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }
    if (node == null) return false;

    if (node.val == arr[index]) {
        return dfs(node.left, arr, index+1) || dfs(node.right, arr, index+1);
    } else {
        return false;
    }
}