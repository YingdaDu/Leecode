class Solution {
    public List<string> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')'){
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);
    }

    private void dfs(String s, int start, Set<String> res,
                     StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {//open < 0 ) is more than ( which is invalid
            return;
        }

        if (start == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(start);
        int len = sb.length();

        if (c == ')') {
            dfs(s, start + 1, res, sb, rmL, rmR - 1, open); // not use )
            dfs(s, start + 1, res, sb.append(c), rmL, rmR, open - 1); //use )
        } else if (c == '(') {
            dfs(s, start + 1, res, sb, rmL - 1, rmR, open); // not use )
            dfs(s, start + 1, res, sb.append(c), rmL, rmR, open + 1);
        } else {
            dfs(s, start + 1, res, sb.append(c), rmL, rmR, open);
        }
        sb.setLength(len);
    }
}