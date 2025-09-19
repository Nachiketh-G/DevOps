// Node class: represents a single element of the LinkedList
class Node {
    int data;      // value of the node
    Node next;     // reference to the next node

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class: contains operations
class LinkedList {
    Node head;  // start of the list

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at a specific position (0-based index)
    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Index out of bounds!");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found!");
        } else {
            current.next = current.next.next;
        }
    }

    // Search for a value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Main class to test LinkedList
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display(); // 10 -> 20 -> 30 -> null

        // Insert at beginning
        list.insertAtBeginning(5);
        list.display(); // 5 -> 10 -> 20 -> 30 -> null

        // Insert at index
        list.insertAt(2, 15);
        list.display(); // 5 -> 10 -> 15 -> 20 -> 30 -> null

        // Delete element
        list.delete(20);
        list.display(); // 5 -> 10 -> 15 -> 30 -> null

        // Search
        System.out.println("Search 15: " + list.search(15)); // true
        System.out.println("Search 100: " + list.search(100)); // false
    }
}
