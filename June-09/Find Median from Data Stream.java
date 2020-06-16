class MedianFinder {

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large= new PriorityQueue<>();
    private boolean even = true;

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(even) {
            large.add(num);
            small.add(large.poll());
        } else {
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if(even) {
            return (small.peek() + large.peek())/2.0; //important should be 2.0 cannot be 2
        } else {
            return small.peek();
        }
    }
}