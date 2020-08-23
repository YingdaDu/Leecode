class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        double avg = helper(root)[2];
        return avg;
    }

    private double[] helper(TreeNode root) {
        if (root == null) {
            return new double[]{0, 0, 0}; // sum, count, average
        }
        double[] l = helper(root.left);
        double[] r = helper(root.right);

        double sum = l[0] + r[0] + root.val;
        double cnt = l[1] + r[1] + 1;
        double avg = Math.max(l[2], r[2]);
        avg = Math.max(avg, sum / cnt);
        return new double[]{sum, cnt, avg};
    }
}

