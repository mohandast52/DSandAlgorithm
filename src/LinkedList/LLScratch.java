package LinkedList;

import java.io.PrintWriter;

/*
<T> is a generic way of saying to use any wrapper class e.g Integer, Float, String!
*/
public class LLScratch<T> {
    static PrintWriter out = new PrintWriter(System.out);
    Node head = null;

    private static class Node<T> {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        /*
        public String toString() {
            return data + "";
        }
        if we override toString() method, node.next will print node.data value, and not the address!
        */
    }

    private void insert(T data) {
        Node node = new Node(data, null);
        // if here comes the first node, then head will be the first node
        if (head == null) {
            head = node;
        } else {
            Node nodeItr = head;
            while (nodeItr.next != null) /* iterate till last element in linked list */ {
                nodeItr = nodeItr.next;
            }
            nodeItr.next = node;
        }
    }

    private void insertAtStart(T data) {
        Node node = new Node(data, null);
        node.next = head; // address of the head added to newNode
        head = node;
    }

    private void insertAt(int index, T data) {
        Node node = new Node(data, null);
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        int temp = 0;
        Node nodeItr = head;
        while (temp < (index - 1)) /* -1 for one step back */ {
            nodeItr = nodeItr.next;
            ++temp;
        }
        node.next = nodeItr.next;
        nodeItr.next = node;
    }

    private void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }

        int temp = 0;
        Node nodeItr = head;
        while (temp < (index - 1)) /* -1 for one step back */ {
            nodeItr = nodeItr.next;
            ++temp;
        }
        System.out.println("Deleted : " + nodeItr.next.data);
        nodeItr.next = nodeItr.next.next;
    }

    private void show() {
        Node nodeItr = head;

        /* iterate till last element in linked list */
        do {
            out.println("Data: " + nodeItr.data + ", Pointer: " + nodeItr + ", Next: " + nodeItr.next);
            nodeItr = nodeItr.next;
        } while (nodeItr.next != null);

        // last value will not be printed, because .next => null
        out.println("Data: " + nodeItr.data + ", Pointer: " + nodeItr + ", Next: " + nodeItr.next);
    }

    public static void main(String args[]) {

        LLScratch<Integer> linkedList = new LLScratch<>();
        linkedList.insert(10);
        linkedList.insert(50);
        linkedList.insertAtStart(5);
        linkedList.insert(90);
        linkedList.insert(95);
        linkedList.insertAt(1, 777);
        linkedList.deleteAt(1);
        linkedList.show();
        out.flush();
    }
}
/*
 - there is not pointer to object in Java, unlike c++!
 - head => stores the address of the node and we can access the data using node.data!

            HEAD
             ||
     ________ ________
     |       |       |
     |   15  |  Next |
     |_______|_______|
         @address
*/
