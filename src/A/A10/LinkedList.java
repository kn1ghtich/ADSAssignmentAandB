package A.A10;

import java.util.ArrayList;
import java.util.Arrays;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
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

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Check for 1 node
        if (head.next == null) {
            head = null;
            return;
        }

        // Traverse to the second last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Update the next pointer of the last node to null
        //garbage collector will remove last because nothing points to cutted node
        current.next = null;
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

    public boolean search(int element) {
        // check for empty list
        if (head == null) {
            return false;
        }

        // go through the list
        Node current = head;
        while (current != null){
            if (current.data == element) {
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

    /*
    public int pop(int element) {
        int result;

        if (head == null) {
            System.out.println("List is empty.");
            return -1;
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
     */

    /*
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

     */

    public LinkedList insertionSort() {
        // Handle empty or single-node list
        if (head == null || head.next == null) {
            return null;
        }

        ArrayList<Integer> sortss = new ArrayList<>();

        Node current = head;
        while (current != null) {
            sortss.add(current.data);
            current = current.next;
        }
        sortss.sort(Integer::compareTo);
        LinkedList Newlist = new LinkedList();
        for (int i = 0; i < sortss.size(); i++) {
            Newlist.addLast(sortss.get(i));
        }
        return Newlist;
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

        LinkedList list1 = list2.insertionSort();
        list1.printLinkedList();



    }
}