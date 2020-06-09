class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();


        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        // min heap
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1)-map.get(w2)
        );

        for (String w :map.keySet()) { // keySet
            heap.add(w);
            if (heap.size() > k) heap.poll();
        }

        while(!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}