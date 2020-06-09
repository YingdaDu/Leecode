class Solution {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (pattern[i-1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i <= text.length; i++) {
            for (int j = 1; j <= pattern.length; j++) {
                if (pattern[j-1] == '.' || text[i-1] == pattern[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern[j-1] == '*') {
                    if (pattern[j-2] != text[i-1] && pattern[j-2] != '.') {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        /*
                        dp[i-1][j] a* count as multiple
                        dp[i][j-1] a* count as one
                        dp[i][j-2] a* count as empty
                        */
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] || dp[i][j-2]);
                    }
                }
            }
        }
        return dp[text.length][pattern.length];
    }
}