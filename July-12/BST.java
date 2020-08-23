class solution {
    public Node constructBST(int[] arr) {
        Arrays.sort(arr);
        Node root = helper(arr, 0, arr.length-1);
    }

    private Node helper(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end)/ 2;
        Node node = new Node(mid);
        node.left = helper(arr, start, mid - 1);
        node.right = helper(arr, mid + 1, end);

        return node;
    }
}