package A.A10;

class Node {
    Integer data;
    Node next;

    public Node(Integer data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public void addFirst(Object data) {
        Node newNode = new Node((Integer) data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(Object data) {
        Node newNode = new Node((Integer) data);

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

        Node newNode = new Node((Integer) data);

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

    public Object pop(Object element) {
        Object result = null;

        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }

        if (head.data == element ) {
            result = head.data;
            head = head.next;
            return result;
        }


        Node current = head;
        while (current != null && !(current.next.data.equals(element))) {
            current = current.next;
        }


        if (current.next == null) {
            System.out.println("Value not found in the list.");
            return null;
        }

        // Remove the node by linking the previous node to the node after the one to be removed
        result = current.next.data;
        current.next = current.next.next;
        return result;
    }

    public static LinkedList concat(LinkedList list1, LinkedList list2) {
        LinkedList newList = new LinkedList();

        Node current = list1.head;
        while (current != null) {
            newList.addLast(current.data);
            current = current.next;
        }

        current = list2.head;
        while (current != null) {
            newList.addLast(current.data);
            current = current.next;
        }
        return newList;
    }

    public static LinkedList reverse(LinkedList list){
        LinkedList newList = new LinkedList();

        Node current = list.head;
        while (current != null) {
            newList.addFirst(current.data);
            current = current.next;
        }

        return newList;
    }


    public void insertionSort() {
        // Handle empty or single-node list
        if (head == null || head.next == null) {
            return;
        }

        // Set the sorted part (initially just the head)
        Node sorted = head;
        Node current = head.next;

        while (current != null) {
            // Extract the current node
            Node next = current.next;

            // Find the correct position for the current node in the sorted part
            Node prev = null;
            Node insertAfter = sorted;
            while (insertAfter != null && current.data > insertAfter.data) {
                prev = insertAfter;
                insertAfter = insertAfter.next;
            }

            // If the current node needs to be inserted at the beginning
            if (prev == null) {
                current.next = sorted;
                sorted = current;
            } else {
                // Insert the current node between prev and insertAfter
                prev.next = current;
                current.next = insertAfter;
            }

            // Move to the next node
            current = next;
        }

        // Update the head pointer to point to the sorted list
        head = sorted;
    }
/*


    public void sort() {
        Node current = head;
        int counter = 0;
        while (current != null) {
            counter++;
            current = current.next;
        }
        Object[] a = new Object[counter];

        Node scurrent = head;
        counter = 0;
        while (scurrent != null) {
            a[counter] = scurrent.data;
            counter++;
            scurrent = scurrent.next;
        }

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }


 */

    public static void main(String[] args) {

        LinkedList list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(5);
        list2.addLast(30);
        list2.printLinkedList();

        list2.insertionSort();
        list2.printLinkedList();



    }
}