public class StackUsingArray {


    private int maxSize;
    private int[] array;
    private int top=0;

    public StackUsingArray(int size){
        maxSize=size;
        array= new int[maxSize];
        top=-1;
    }

    //push operations
    public void push(int data){
        //check if Stack is full
        if(top==maxSize-1){
            System.out.println("Stack is full");
        }
        else{
            top++;
            array[top]=data;
        }
    }

    //pop operation
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else {
            int popElement = array[top];
            top--;
            return popElement;
        }
        return -1;
    }

    //peek : returns top elements without removing elements
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        else {
           return array[top];
        }
        return -1;

    }

    //isEmpty
    public boolean isEmpty(){
        return top==-1;
    }

    //display Elements
    public void displayElements(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        for(int i=0;i<=top;i++){
            System.out.print(array[i] + "\t");
        }
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray(5);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.displayElements();
        System.out.println();
        System.out.println( s.pop());
        s.displayElements();
        System.out.println("\n" + s.peek());
    }
}
