public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) { //  Integer.MAX_VALUE+1==Integer.MIN_VALUE cyclic must use n !+ 0, cannot use < 0
            count = count + (n & 1); // () is very import
            n = n >>> 1; //usign shift
        }
        return count;
    }
}