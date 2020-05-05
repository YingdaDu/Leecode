class Solution {
    public String alienOrder(String[] words) {
        Map<Character, HashSet<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String s : words) {
            for(char c : s.toCharArray()) {
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            for (j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
            if (j == len && w1.length() > w2.length()) {
                return "";
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
             char c = queue.poll();
             sb.append(c);
             if (map.containsKey(c)) {
                 for (char c1 : map.get(c)) {
                     indegree.put(c1, indegree.get(c1) - 1);
                     if (indegree.get(c1) == 0) {
                         queue.add(c1);
                     }
                 }
             }
        }
        String ans = sb.toString();
        if (ans.length() != indegree.size()) return "";

        return ans;
    }
}