class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (plen > slen) return ans;

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();

        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < slen; i++) {
            char ch = s.charAt(i);
            //add to map
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            if (i >= plen) {
                ch = s.charAt(i - plen);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch); // need to remove key, not just keep 0 in the map
                }
                else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            //compare two hashmap
            if (pCount.equals(sCount)) {
                ans.add(i + 1 - plen);
            }

        }
        return ans;
    }
}