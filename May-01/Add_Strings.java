/*
415. Add Strings
67. Add Binary
 */
class Solution {
    public String addStringsInt(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1, j=num2.length()-1; i>=0 || j>=0 || carry==1; i--,j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x+y+carry)%10);
            carry = (x+y+carry)/10;
        }
        return sb.reverse().toString();
    }
    /*add bianry, just replace the above solution 10 to 2
      bit manipulation
      one has to find the sum of answer without carry and carry.
      Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.
      while carry is nonzero: y != 0:
      Current answer without carry is XOR of x and y: answer = x^y.
      Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
      Job is done, prepare the next loop: x = answer, y = carry.
      Return x in the binary form.
     */
    public String addStringsBianry(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, ans;
        while (y.compareTo(zero) != 0) {
            ans = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = ans;
            y = carry;
        }
        return x.toString(2);
    }
}