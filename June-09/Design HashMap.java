class MyHashMap {

    class Pair {
        int key;
        int value;
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }
        public int getValue() {
            return this.value;
        }
    }

    List<Pair>[] container;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;
    /** Initialize your data structure here. */
    public MyHashMap() {
        container = new LinkedList[cap];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(cap * loadFactor == count) {
            cap = cap * 2;
            List<Pair>[] old = container;
            container = new LinkedList[cap];
            for (int i = 0; i < old.length; i++) {
                List<Pair> list = old[i];
                if(list != null) {
                    for (Pair p : list) this.put(p.getKey(), p.getValue());
                }
            }
        }
        if (get(key) != -1) {
            this.remove(key);
        }
        int hash = key % cap;
        if(container[hash] == null) container[hash] = new LinkedList<>();
        container[hash].add(new Pair(key, value));
        count++;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % cap;
        List<Pair> list = container[hash];
        if (list != null) {
            Iterator<Pair> iter = list.iterator();
            while(iter.hasNext()) {
                Pair p = iter.next();
                if(p.getKey() == key) {
                    return p.getValue();
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % cap;
        List<Pair> list = container[hash];
        if (list != null) {
            Iterator<Pair> iter = list.iterator();
            while (iter.hasNext()) {
                if(iter.next().getKey() == key) {
                    iter.remove();
                    count--;
                }
            }
        }
    }
}