package B.B4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(12);
        stack.push(21);
        stack.push(7);

        System.out.println("Original stack: ");
        System.out.println(stack);

        reverseStack(stack);
        System.out.println("Reversed stack: ");
        System.out.println(stack);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, top);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int top = stack.pop();
            insertAtBottom(stack, item);
            stack.push(top);
        }
    }
}
