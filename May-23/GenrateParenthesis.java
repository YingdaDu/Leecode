class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String cur, int open, int close, int n) {
        if (cur.length() == n * 2 && close == open) {
            res.add(cur);
            return;
        }

        if (open < n) {
            dfs(res, cur+"(", open+1, close, n);
        }

        if (close < open) {
            dfs(res, cur+")" , open, close+1, n);
        }
    }
}