public class LFUCache {
    class DLinkedNode {
        int key;
        int value;
        int times;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(int key, int value) {
            this.key = key;
            this.val = value;
            times = 1;
        }
    }

    class DLinkedList {
        Node head, tail;
        int size;
        DLinkedList () {
            head = new DLinkedNode(0, 0);
            tail = new DLinkedNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(NDLinkedNode node) { // add after head
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        DLinkedNode removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }


    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private Map<Integer, DLinkedList> countMap = new HashMap<>(); // key: frequency value: list
    private int capacity, size, min;

    public LFUCache (int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
       if(capacity == 0) return;
       DLinkedNode node;
       if (cache.containsKey(key)) {
           node = cache.get(key);
           node.value = value;
           update(node);
       } else {
           node = new DLinkedNode(key, value);
           cache.put(key, node);
           if(size == capacity) {
               DLinkedList lastList = countMap.get(min);
               cache.remove(lastList.removeLast().key);
               size--;
           }
           size++;
           min = 1;
           DLinkedList newList = countMap.getOrDefault(node.times, new DLinkedList());
           newList.add(node);
           countMap.put(node.times, newList);
       }
    }

    private void update(DLinkedNode node) {
        DLinkedList oldList = countMap.get(node.times);
        oldList.remove(node);
        if(node.times == min && oldList.size == 0) min++;
        node.times++;
        DLinkedList newList = countMap.getOrDefault(node.times, new DLinkedList());
        newList.add(node);
        countMap.put(node.times, newList);
    }

}