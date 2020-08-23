class Solution {
    public int distanceBetweenTwoNode (Node root, int a, int b) {
        if (root == null) {
            return 0;
        }

        if (root.val > a && root.val > b) {
            return distanceBetweenTwoNode(root.left, a, b);
        }
        if (root.val < a && root.val < b) {
            return distanceBetweenTwoNode(root.right, a, b);
        }
        if (root.val >= a && root.val <= b) {
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        }
        return 0;
    }

    private int distanceFromRoot(TreeNode root, int a) {
        if (root.val == a) {
            return 0;
        } else if (root.val > a) {
            return distanceFromRoot(root.left, a) + 1;
        } else {
            return distanceFromRoot(root.right, a) + 1;
        }
    }
}