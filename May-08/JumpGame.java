class Solution {
    //dp
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] canJump = new boolean[len];
        canJump[len - 1] = true;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i] && i+j < len; j++) {
                if(canJump[i+j] == true) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0];
    }
    // greedy
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(i > max) {
                return false;
            }
            max = Math.max(A[i] + i, max);
        }
        return true;
    }
}