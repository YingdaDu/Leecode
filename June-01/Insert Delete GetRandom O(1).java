class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs; //key insert value, value is location index
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val);
        //swap with the last index
        if (loc < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            locs.put(last, loc);
        }
        locs.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}


class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if(!contain) {
            locs.put(val, new HashSet<Integer>());
        }
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc); //remove the first one
        if (loc < nums.size() - 1) {
            int last = nums.get(nums.size()-1);
            nums.set(loc, last);
            locs.get(last).remove(nums.size()-1);
            locs.get(last).add(loc);
        }
        nums.remove(nums.size()-1);
        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
