class CircularList {

    private ListNode head;
    private ListNode tail;

    public CircularList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(Object item) {
        // TO BE COMPLETED
        ListNode newHead = new ListNode(item, head);
        if (isEmpty()) {
            head = tail = newHead;
        } else {
            head = newHead;
        }
        tail.setNext(head);
    }

    public void addToTail(Object item) {
        // TO BE COMPLETED
        ListNode newTail = new ListNode(item);
        if (isEmpty()) {
            head = tail = newTail;
        } else {
            tail.setNext(newTail);
            tail = newTail;
        }
        tail.setNext(head);
    }

    public Object removeFromHead() throws EmptyListException {
        // TO BE COMPLETED
        if (isEmpty()) {
            throw new EmptyListException();
        }
        ListNode removed = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        return removed.getData();
    }

    public Object removeFromTail() throws EmptyListException {
        // TO BE COMPLETED
        if (isEmpty()) {
            throw new EmptyListException();
        }
        ListNode current = head;
        if (head == tail) {
            head = tail = null;
            return current;
        } else {
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            ListNode removed = tail;
            tail = current;
            current.setNext(head);
            return removed.getData();
        }
    }

    public String toString() {
        String s = "[ ";
        if (!isEmpty()) {
            s += head.getData() + " ";
            ListNode current = head.getNext();
            while (current != head) {
                s += current.getData() + " ";
                current = current.getNext();
            }
        }
        return s + "]";
    }
} // class CircularList

public class Advanced_week3_q4 {

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addToHead("world");
        System.out.println(list);
        list.addToHead("hello");
        System.out.println(list);
        System.out.println("removed: " + list.removeFromHead());
        System.out.println(list);
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("removed: " + list.removeFromHead());
        System.out.println(list);
        System.out.println("isEmpty: " + list.isEmpty());
        
        list.addToTail("write");
        System.out.println(list);
        list.addToTail("once");
        System.out.println(list);
        list.addToTail("debug");
        System.out.println(list);
        list.addToTail("everywhere");
        System.out.println(list);
        System.out.println("removed: " + list.removeFromTail());
        System.out.println(list);
        System.out.println("removed: " + list.removeFromTail());
        System.out.println(list);
        list.addToTail("run");
        System.out.println(list);
        list.addToTail("anywhere");
        System.out.println(list);
    }
}
