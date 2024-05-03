package A.A2;
//2. Implement a function to add an element to the end of a singly linked list.

class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void printLinkedList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null (the end of the LinkedList).");
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.printLinkedList(); // display that list is empty

        list.addLast("Minecraft"); // added first but will be in the beginning in the end
        list.addLast("Counter-Strike");
        list.addLast("Assassin's creed"); // added last but will be printed in the end
        list.addFirst("Dark Souls III");

        list.printLinkedList();

    }
}