class Solution {
    public Node flatten (Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            // case 1; no child
            if (cur.child == null) {
               cur = cur.next;
               continue;
            }
            //case 2 got child, find tail of the child, link it to cur.next
            Node tmp = cur.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            //connect tail to cur.next
            tmp.next = cur.next;
            if (cur.next != null) cur.next.prev = tmp;
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }

   public Node flatten(Node head) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null) {
            if (cur.child != null) {
                stack.push(cur.next);
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else if (cur.next == null && !stack.isEmpty()){
                cur.next = stack.pop();
                if (cur.next != null) cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
   }



}
