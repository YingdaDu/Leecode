/*
238. Product of Array Except Self

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of
all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

 */

/*
Use ans[] to maintain L and R arrays
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        // int[] L = new int[len];
        // int[] R = new int[len];

        int[] ans = new int[len];

        ans[0] = 1;
        for (int i=1; i < len; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        // R[len-1] = 1;
        int R = 1;
        for (int i=len-1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }

//         for (int i = 0; i < len; i++) {
//             ans[i] = L[i] * R[i];
//         }
        return ans;
    }

     //brute force
    public int[] productExceptSelfV1(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int product = 1;
        int zero = 0;
        int index = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zero++;
                index = i;
            }
        }

        if (zero >= 2) {
            return ans;
        } else if (zero == 1) {
            ans[index] = product;
            return ans;
        } else {
            Arrays.fill(ans, product);
            for (int i = 0; i < len; i++) {
                ans[i] = ans[i]/nums[i];
            }
        }
        return ans;
    }


}