package A.A6;


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

    public Object removeLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }

        // Check for 1 node
        if (head.next == null) {
            head = null;
            return null;
        }

        // Traverse to the second last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Update the next pointer of the last node to null
        //garbage collector will remove last because nothing points to cutted node
        Object result = current.next.data;
        current.next = null;
        return result;
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

    public boolean search(Object element) {
        // check for empty list
        if (head == null) {
            return false;
        }

        // go through the list
        Node current = head;
        while (current != null){
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next; // go to next till null
        }

        return false;
    }

    public boolean insertAt(Object data, int position) {
        // To identify that it is invalid positions
        if (position < 0) {
            System.out.println("Invalid position: cannot insert at a negative index.");
            return false;
        }

        Node newNode = new Node(data);

        // Handle insertion at the beginning (position 0)
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return true;
        }

        // Count to the node before the insertion position
        int count = 0;
        Node current = head;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        // Handle positions beyond the list length
        if (current == null) {
            System.out.println("Invalid position: cannot insert beyond the end of the list.");
            return false;
        }

        // shift nodes to make space
        newNode.next = current.next;
        current.next = newNode;
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast("Minecraft"); // added first but will be in the beginning in the end
        list.addLast("Counter-Strike");
        list.addLast("Assassin's creed"); // added last but will be printed in the end
        list.addFirst("Dark Souls III");
        list.printLinkedList();

        System.out.println("INSETION");
        list.insertAt("Elden Ring", 4);
        list.printLinkedList();
        /*
        boolean result1 = list.search("Dark Souls III");
        System.out.println("Found - Dark Souls III");
        boolean result2 = list.search("The Legend of Zelda");
        System.out.println("Not Founded - The Legend of Zelda");
         */

    }
}