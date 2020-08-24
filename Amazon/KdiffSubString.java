public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        if(stringIn.length()<K){
            return 0;
        }
        int count = 0;
        Set<String> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < stringIn.length(); i++) {
            if (i - K >= 0){
                char start = stringIn.charAt(i - K);
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) {
                    count--;
                }
            }
            char cur = stringIn.charAt(i);
            if (!map.containsKey(cur) || map.get(cur) == 0) {
                count++;
            }

            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (count == K - 1) {
                set.add(stringIn.substring(i - K + 1, i + 1));
            }
        }
        return set.size();
    }
}