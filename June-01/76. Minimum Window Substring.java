class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> wordCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c, 0) + 1);
        }

        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast= 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordCount.get(ch);
            if (count == null) {
                continue;
            } //not in target string, ignore
            wordCount.put(ch, count - 1);
            if (count == 1) {
                //1->0
                matchCount++;
            }

            while (matchCount == wordCount.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftMost = s.charAt(slow++);
                Integer leftMostCount = wordCount.get(leftMost);
                if (leftMostCount == null) {
                    continue;
                }
                wordCount.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    //0-->1
                    matchCount--;
                }
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);

    }
}