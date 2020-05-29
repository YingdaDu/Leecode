class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                char[] cur = queue.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (char c = 'a'; c <=  'z'; c++) {
                        cur[j] = c;
                        String next = new String(cur);
                        //when next is in the set
                        if (set.contains(next)) {
                            if (next.equals(endWord)) return count+1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    cur[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}