package java_basics.fifth_topic;

class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericLinkedList<T> {
    Node<T> head;
    private int length = 0;

    public GenericLinkedList() {
        this.head = null;
    }

    // Implement add(), add an element to the end
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // Implement addFirst(), add an element to the beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            head = new Node<T>(data);
            head.next = current;
        }
        length++;
    }

    // Implement add(), add an element to a position
    public void add(int position, T data) {
        if (position > length + 1) {
            System.out.println("Position Unavailable in GenericLinkedList");
        } else if (position == 1) {
            Node<T> current = head;
            head = new Node<T>(data);
            head.next = current;
            length++;
        } else {
            Node<T> current = head;
            Node<T> pre = null;
            int i = 1;
            while (i < position) {
                pre = current;
                current = current.next;
                i++;
            }
            Node<T> newNode = new Node<T>(data);
            pre.next = newNode;
            if (current != null) {
                pre.next.next = current;
            }
            length++;
        }
    }

    // Implement remove(), remove an element equals data
    public void remove(T data) {
        if (head == null) {
            return;
        } else if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Implement pop(), pop the last element if there is one
    public void pop() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            length--;
            return;
        } else {
            Node<T> current = head;
            Node<T> pre = null;
            while (current.next != null) {
                pre = current;
                current = current.next;
            }
            pre.next = null;
            length--;
        }
    }

    // Implement toString(), convert the linked list to a string
    @Override
    public String toString() {
        String s = "{ ";
        Node<T> current = head;
        if (current == null) {
            return s + " }";
        }
        while (current.next != null) {
            s += String.valueOf(current.data) + " -> ";
            current = current.next;
        }
        s += String.valueOf(current.data);
        return s + " }";
    }

    // Implement clear(), clear the Linked list
    public void clear() {
        head = null;
        length = 0;
    }
}
