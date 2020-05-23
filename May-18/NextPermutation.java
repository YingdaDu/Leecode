public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        } //找到第一个从右到左不是递增的数（证明这个数是可以被右边的数替换的）
        if(i >= 0) {
            int j = nums.length-1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            } // 找到右边比I 大但最接近I 的数
            swap(nums, i, j); //交换这两个数
        }
        reverse(nums, i+1, nums.length-1); //把右边变成最小
}

private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
}

private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
}
