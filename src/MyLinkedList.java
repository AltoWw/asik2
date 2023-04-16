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

    public void add(T item) {
        add(item, size);
    }

    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            Node<T> newNode = new Node<>(item, tail, null);
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        } else {
            Node<T> node = getNode(index);
            Node<T> newNode = new Node<>(item, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
            if (index == 0) {
                head = newNode;
            }
        }
        size++;
    }

    public boolean remove(T item) {
        Node<T> node = head;
        while (node != null) {
            if (node.element.equals(item)) {
                removeNode(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public T remove(int index) {
        Node<T> node = getNode(index);
        removeNode(node);
        return node.element;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public T get(int index) {
        return getNode(index).element;
    }

    public void sort() {
        // This implementation uses a simple insertion sort
        for (int i = 1; i < size; i++) {
            T item = get(i);
            int j = i - 1;
            while (j >= 0 && get(j).compareTo(item) > 0) {
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, item);
        }
    }
}