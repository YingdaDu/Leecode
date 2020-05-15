/*
Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1
example   rangeBitwiseAnd(26, 30);
m is 11010 n is 11110 i is 0
loop: m is 1101 n is 1111 i is 1
loop: m is 110 n is 111 i is 2
loop: m is 11 n is 11 i is 3
result is 24 binary is 11000

Java method Integer.toBinaryString(m)
 */

public static int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while(m != n){
            m >>= 1;
            n >>= 1;
            i++;
        }
        // at this point, m == n, left shift
        return m << i;
}