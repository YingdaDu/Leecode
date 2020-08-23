class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quicksort(int[] A, int l, int r) {
        if (l >= r) return;
        int i = partition(A, l , r);
        quicksort(A, l, i-1);
        quicksort(A, i+1, r);
    }

    private int partition(int[] A, int l, int r) {
        int pivot = A[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (A[j] <= pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, r);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}