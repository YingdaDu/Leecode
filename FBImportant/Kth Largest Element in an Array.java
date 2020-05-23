class solution {
    private void shffule(int[] nums) {
        final Random random = new Random();
        for (int i = 1; i < nums,length; i++) {
            int r = random.nextInt(i + 1);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int partition (int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int pivot = partition(nums, low, high);
            if (pivot < k) {
                low = pivot - 1;
            } else if (pivot > k) {
                high = pivot + 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
}