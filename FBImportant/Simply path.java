class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        Stack<String> stack = new Stack<>();
        String[] elements = path.split("/");

        for (String dir : elements) {
            if (dir.equals(".") || dir.length() == 0) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(dir);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/");
            ans.append(dir);
        }
        return ans.length() > 0 ? ans.toString() : "/";
    }
}