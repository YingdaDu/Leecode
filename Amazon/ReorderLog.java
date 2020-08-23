class Solution {
    // time complexity M * N log N
    // N is number of log, M is length of log
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> customComparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                int idx1 = s1.indexOf(" ");
                int idx2 = s2.indexOf(" ");
                char c1 = s1.charAt(idx1+1);
                char c2 = s2.charAt(idx2+1);

                if (!Character.isDigit(c1) && Character.isDigit(c2)) {
                    return -1; //s1 first
                } else if (Character.isDigit(c1) && !Character.isDigit(c2)) {
                    return 1; //s2 first
                } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                    return 0; //original order
                }
                String sub1 = s1.substring(idx1+1);
                String sub2 = s2.substring(idx2+1);
                int comp = sub1.compareTo(sub2);
                if (comp == 0){
                    return s1.compareTo(s2);
                } else {
                    return comp;
                }
            }
        };

        Arrays.sort(logs, customComparator);
        return logs;
    }
}