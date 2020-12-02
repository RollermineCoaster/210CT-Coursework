
class ListNode {

    private Object data;
    private ListNode next;

    ListNode(Object o) {
        data = o;
        next = null;
    }

    ListNode(Object o, ListNode nextNode) {
        data = o;
        next = nextNode;
    }

    Object getData() {
        return data;
    }

    ListNode getNext() {
        return next;
    }

    void setData(Object data) {
        this.data = data;
    }

    void setNext(ListNode next) {
        this.next = next;
    }

} // class ListNode

class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("List is empty");
    }
} // class EmptyListException

class LinkedList {

    private ListNode head;
    private ListNode tail;

    public LinkedList() {
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
            current.setNext(null);
            return removed.getData();
        }
    }

    public String toString() {
        String s = "[ ";
        ListNode current = head;
        while (current != null) {
            s += current.getData() + " ";
            current = current.getNext();
        }
        return s + "]";
    }
} // class LinkedList
