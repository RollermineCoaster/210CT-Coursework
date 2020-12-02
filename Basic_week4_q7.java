
class Queue {

    private LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public boolean empty() {
        return list.isEmpty();
    }

    public void enqueue(Object obj) {
        list.addToTail(obj);
    }

    public Object dequeue() throws EmptyListException {
        return list.removeFromHead();
    }

    public String toString() {
        return list.toString();
    }

}

public class Basic_week4_q7 {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue("hello");
        System.out.println(q);
        q.enqueue("world");
        System.out.println(q);
        System.out.println("dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("dequeue: " + q.dequeue());
        System.out.println(q);
        System.out.println("empty: " + q.empty());
        q.enqueue("write");
        System.out.println(q);
        q.enqueue("once");
        System.out.println(q);
        q.enqueue("debug");
        System.out.println(q);
        q.enqueue("everywhere");
        System.out.println(q);
        System.out.println("empty: " + q.empty());
    }
}
