class Solution {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

    //no stack
    public int calculate (String s) {
        if (s == null) return  0;
        int len = s.length();
        int res = 0, prev = 0, i = 0;
        char sign = '+';

        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int cur = 0;
            while (i < len && Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }

            if (sign == '+') {
                res += cur;
                prev = cur;
            } else if (sign = '-') {
                res += cur;
                prev = -cur;
            } else if (sign = '*') {
                res = prev * cur;
            } else if (sign == '/') {
                res = prev / cur;
            }
            if (i < len) {
                sign = s.charAt(i);
                i++;
            }
        }
        res += prev;
        return res;
    }

}