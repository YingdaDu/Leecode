class Solution {

    int index = 0;
    public String decodeString(String s) {
        return helper(s);
    }

    private String helper(String s) {
        StringBuilder cur = new StringBuilder();

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    count = 10 * count + s.charAt(index) - '0';
                    index++;
                }
                //to move after [
                index++;
                String repeatString = helper(s);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    sb.append(repeatString);
                }
                cur.append(sb.toString());
            } else if (s.charAt(index) == ']') {
                index++;
                return cur.toString();
            } else {
                cur.append(s.charAt(index++));
            }
        }
        return cur.toString();
    }

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }
}