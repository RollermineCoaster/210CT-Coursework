
class ListStack extends LinkedList {

    public ListStack() {
        super();
    }

    public boolean empty() {
        return super.isEmpty();
    }

    public void push(Object obj) {
        super.addToHead(obj);
    }

    public Object pop() throws EmptyListException {
        return super.removeFromHead();
    }

    public Object peek() throws EmptyListException {
        Object temp = super.removeFromHead();
        super.addToHead(temp);
        return temp;
    }

    public Object search(Object obj) {
        int pos = 1;
        boolean found = false;
        if (!empty()) {
            ListStack temp = new ListStack();
            Object popObj = null;
            while (!empty()) {
                popObj = pop();
                temp.push(popObj);
                if (popObj.equals(obj)) {
                    found = true;
                    break;
                } else {
                    pos++;
                }
            }
            while (!temp.empty()) {
                push(temp.pop());
            }
        }
        return found ? pos : -1;
    }
}

public class Basic_week4_q6 {

    public static void main(String[] args) {

        ListStack list = new ListStack();
        list.push("world");
        System.out.println(list);
        list.push("hello");
        System.out.println(list);
        System.out.println("popped: " + list.pop());
        System.out.println(list);
        System.out.println("empty: " + list.empty());
        System.out.println("popped: " + list.pop());
        System.out.println(list);
        System.out.println("empty: " + list.empty());

        list.push("write");
        System.out.println(list);
        list.push("once");
        System.out.println(list);
        list.push("debug");
        System.out.println(list);
        System.out.println("peek: " + list.peek());
        list.push("everywhere");
        System.out.println(list);
        System.out.println("search debug: " + list.search("debug"));
        System.out.println(list);
        System.out.println("search run: " + list.search("run"));
        System.out.println("popped: " + list.pop());
        System.out.println(list);
        System.out.println("popped: " + list.pop());
        System.out.println(list);
        list.push("run");
        System.out.println(list);
        list.push("anywhere");
        System.out.println(list);
    }
}
