class Solution {
    public String longestDupSubstring(String S) {
        int l = 1, r = S.length();
        String largest = "";
        while(l < r) {
            int m = l + (r-l)/2;
            String substring = search(S, m);
            if(largest == "" || substring.length() > largest.length()) {
                largest = substring;
            }
            if(substring.length() > 0) {
                l = m + 1; //try larger lengths
            }
            else {
                r = m;
            }
        }
        return largest;
    }

    String search(String s, int m) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i <= s.length() - m;i++) {
            String substr = compress(s.substring(i, i + m));
            if(seen.contains(substr)) {
                return s.substring(i, i + m);
            }
            seen.add(substr);
        }
        return "";
    }

    String compress(String s) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
            while(i < s.length() - 1 && s.charAt(i+1) == s.charAt(i)) {
                i++;
            }
            int len = i - j + 1;
            if(len > 0) {
                for(char chr : Integer.valueOf(len).toString().toCharArray()) {
                    sb.append(chr);
                }
            }
            sb.append(s.charAt(i));
            i++;
            j = i;
        }
        return sb.toString();
    }


    private String search(String s, int size){
        long H = hash(s.substring(0,size));

        HashSet<Long> set = new HashSet();
        set.add(H);

        long pow = 1;
        for(int i=1;i<size;i++)
            pow = (pow * 31);

        int n = s.length();
        for(int i=size;i < n;i++){
            H = nextHash(pow, H, s.charAt(i-size), s.charAt(i));
            if(!set.add(H)){
                return s.substring(i-size+1, i+1);
            }
        }

        return "";
    }

    private long hash(String s){
        long h = 0;
        long a = 1;

        int n = s.length();
        for(int k=n;k>=1;k--){
            char ch = s.charAt(k-1);
            h += (ch - 'a' + 1) * a;
            a = (a*31);
        }

        return h;
    }

    private long nextHash(long pow,long hash,char left,char right){
        return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
    }

}