/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
 */
/*
Brute force

for each *, replate it with (, ) , ' ', and check it is valid or not

complexity: image string *********, for loop the entire each, for each *, has 3 cases,
check valid cost O(N)

O(N * 3^N)
 */
class Solution {
    boolean ans = false;
    public boolean checkValidString(String s) {
        return solve(new StringBuilder(s), 0);
        return ans;
    }

    private void solve(StringBuilder sb, int i) {
        if (sb.length() == i) {
            ans |= valid(sb);
        } else if (sb.charAt(i) == '*'){
            for (char c : "() ".toCharArray()) {
                sb.setCharAt(i, c);
                solve(sb, i+1);
                if (ans) return; // found true in previous combination, then return
            }
            sb.setCharAt(i, '*');
        } else {
            solve(sb, i+1);
        }
    }

    private void valid(StringBuilder sb) {
        int bal = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') bal++;
            if (c == ')') bal--;
            if (bal < 0) break;
        }
        return bal == 0;
    }
}


class Solution {
    /*
    dp[i][j] is true if s[i]----s[j] is true;
    two case:
    if s[i] == '*' s[i+1] ....[j] is valid
    or s[i] == '(' there is k in s[i+1][j that s[k] can be made ), and s[i+1][k} and s[k+1][j]
    is true
     */

    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true;

        boolean[][] dp = new boolean[n][n];
        //init
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') dp[i][i] = true;
            if (i < n-1 &&
                    (s.charAt(i) == '(' || s.charAt(i) == '*')
                    && (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }
        //expand

        for (int size = 2; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
                    dp[i][i+size]=true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            dp[i][i+size]=true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0; // open parentheses count in range [cmin, cmax]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }
            if (cmax < 0) return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
            cmin = Math.max(cmin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }
        return cmin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }


}