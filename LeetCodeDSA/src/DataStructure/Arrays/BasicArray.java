package DataStructure.Arrays;

/**
 * Basic Array Implementation with common operations
 */
public class BasicArray {
    private int[] arr;
    private int size;
    private int capacity;

    // Constructor
    public BasicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    // Insert element at the end
    public void insert(int element) {
        if (size < capacity) {
            arr[size] = element;
            size++;
            System.out.println("Inserted " + element + " at index " + (size - 1));
        } else {
            System.out.println("Array is full!");
        }
    }

    // Insert element at specific index
    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }
        if (size >= capacity) {
            System.out.println("Array is full!");
            return;
        }
        
        // Shift elements to make space
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        System.out.println("Inserted " + element + " at index " + index);
    }

    // Delete element at specific index
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        
        int deletedElement = arr[index];
        // Shift elements to fill the gap
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("Deleted " + deletedElement + " from index " + index);
    }

    // Search for an element
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Get element at specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return -1;
        }
        return arr[index];
    }

    // Update element at specific index
    public void update(int index, int newElement) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        int oldElement = arr[index];
        arr[index] = newElement;
        System.out.println("Updated element at index " + index + " from " + oldElement + " to " + newElement);
    }

    // Display array
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Get current size
    public int getSize() {
        return size;
    }

    // Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if array is full
    public boolean isFull() {
        return size == capacity;
    }

    // Main method for testing
    public static void main(String[] args) {
        BasicArray array = new BasicArray(10);
        
        System.out.println("=== Basic Array Operations ===");
        
        // Insert elements
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.display();
        
        // Insert at specific index
        array.insertAt(2, 25);
        array.display();
        
        // Search for element
        int searchResult = array.search(25);
        System.out.println("Element 25 found at index: " + searchResult);
        
        // Update element
        array.update(1, 22);
        array.display();
        
        // Delete element
        array.deleteAt(2);
        array.display();
        
        // Get element at index
        System.out.println("Element at index 1: " + array.get(1));
        
        System.out.println("Array size: " + array.getSize());
        System.out.println("Is empty: " + array.isEmpty());
        System.out.println("Is full: " + array.isFull());
    }
}
