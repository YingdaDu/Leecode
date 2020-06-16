class Solution {
    public int calculate(String s) {
        int len = s.length();
        int result = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i+1))) {
                    sum = 10 * sum + s.charAt(i+1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')'){
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}