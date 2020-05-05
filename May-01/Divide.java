//Complexity O(logn ^ 2)
class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        while (dividend -  divisor >= 0) {
           ans += 1;
           dividend -= divisor;
        }
        return isNeg ? -ans : ans;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        while (dividend - divisor >= 0) {
            int x = 0;
            /*
            1 << 4 = : 16
            10 << 4 = : 160
            10 << 1 << 4 = : 320
             */
            while (dividend - (divisor << 1 << x) >= 0) {
                x++;
            }
            ans += 1 << x;
            dividend -= divisor << x;
        }
        return isNeg ? -ans : ans;
    }
}