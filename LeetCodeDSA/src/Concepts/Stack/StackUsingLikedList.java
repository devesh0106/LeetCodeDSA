package Concepts.Stack;

// Concepts.Stack.Node class for the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    static class StackUsingLikedList {
        private Node top; // Reference to the top of the stack

        // Push: Add an element to the top
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top; // new node points to current top
            top = newNode; // top now points to the new node
        }

        // Pop: Remove and return the top element
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack underflow - cannot pop from empty stack");
            }
            int value = top.data;
            top = top.next;
            return value;
        }

        // Peek: Return the top element without removing it
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty - cannot peek");
            }
            return top.data;
        }

        // isEmpty: Check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Display stack elements (top to bottom)
        public void display() {
            Node current = top;
            System.out.print("Stack (top to bottom): ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        StackUsingLikedList stack = new StackUsingLikedList();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // Output: Stack (top to bottom): 30 20 10

        // Peek at the top
        System.out.println("Top element: " + stack.peek()); // 30

        // Pop elements
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        stack.display(); // Output: Stack (top to bottom): 10

        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        stack.pop(); // remove last item
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
    }
}
