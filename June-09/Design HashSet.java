class MyHashSet {
    List<Integer>[] container;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;
    /** Initialize your data structure here. */
    public MyHashSet() {
        container = new LinkedList[cap];
    }

    public void add(int key) {
        if(contains(key)) return;
        if(cap * loadFactor == count) {
            cap = cap * 2;
            List<Integer>[] old = container;
            container = new LinkedList[cap];
            for (int i = 0; i < old.length; i++) {
                List<Integer> list = old[i];
                if(list != null) {
                    for (int entry : list) this.add(entry);
                }
            }
        }
        int hash = key % cap;
        if(container[hash] == null) container[hash] = new LinkedList<>();
        container[hash].add(key);
        count++;
    }

    public void remove(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> iter = list.iterator();
            while (iter.hasNext()) {
                if(iter.next() == key) {
                    iter.remove();
                    count--;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> iter = list.iterator();
            while(iter.hasNext()) {
                if(iter.next() == key) {
                    return true;
                }
            }
        }
        return false;
    }
}