class Solution {
    public String removeParenthese(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> index = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    index.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            index.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (index.contains(i)) continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}