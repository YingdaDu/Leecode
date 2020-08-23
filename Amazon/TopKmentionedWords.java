class solution {
    private static List<String> topK(int k, String[] keywords, String[] reviews) {
        List<String> res = new ArrayList<>();
        Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywords));
        Map<String, Integer> map = new HashMap<>();

        for (String review : reviews) {
            String[] strs = review.split("\\W");
            HashSet<String> added = new HashSet<>();
            for (String str : strs) {
                str = str.toLowerCase();
                if (keywordSet.contains(str) && !added.contains(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                    added.add(str);
                }
            }
        }
        //max heap
        PriorityQueue<Map.Entry<String, Integer>> maxheap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        maxheap.addAll(map.entrySet());

        while (!maxheap.isEmpty() && k > 0) {
            res.add(maxheap.poll().getKey());
            k--;
        }
        return res;
    }
}