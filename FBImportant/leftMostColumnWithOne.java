class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int n = dimension.get(0);
        int m = dimension.get(1);
        //from right top
        int i = 0, j = m - 1, leftMost = -1;

        while (i < n && j >= 0) {
            int result = binaryMatrix.get(i, j);
            if (result == 0) {
                i++;
            } else {
                leftMost = j;
                j--;
            }
        }
        return leftMost;
    }
}