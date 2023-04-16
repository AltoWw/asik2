public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        Node<T> node = head;
        int index = 0;
        while (node != null) {
            if (node.element.equals(o)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node<T> node = tail;
        int index = size - 1;
        while (node != null) {
            if (node.element.equals(o)) {
                return index;
            }
            node = node.prev;
            index--;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }