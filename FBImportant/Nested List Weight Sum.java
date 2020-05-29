/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum (List<NestedInteger> list, int level) {
        int sum = 0;

        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * level;
            } else {
                sum += depthSum(n.getList(), level + 1);
            }
        }
        return sum;
    }
}

class Solution2 {
    // BFS and maintain prev to make sure previous sum can be added again in each level
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int prev = 0;
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n : nestedList) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int level = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    level += cur.getInteger();
                } else {
                    for (NestedInteger n : cur.getList()) {
                        queue.offer(n);
                    }
                }
            }
            prev += level;
            sum += prev;
        }
        return sum;
    }
}


//time limit exceed
class Solution2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int h = findDepth(nestedList);
        return depthSum(nestedList, h);
    }

    private int findDepth(List<NestedInteger> list) {
        if (list == null || list.size() == 0) return 0;
        int max = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                max = Math.max(max, 1);
            } else {
                max = Math.max(max, findDepth(list) + 1);
            }
        }
        return max;
    }

    private int depthSum (List<NestedInteger> list, int level) {
        if (list == null || list.size() == 0) return 0;
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) sum += (n.getInteger() * level);
            else sum += depthSum(n.getList(), level-1);
        }
        return sum;
    }
}