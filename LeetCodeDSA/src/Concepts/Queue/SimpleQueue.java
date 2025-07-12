package Concepts.Queue;

public class SimpleQueue {

    private int[] queue;
    private int maxSize;
    private int front;
    private int rear;

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0; // pointer to remove elements
        this.rear = -1; //pointer to add elements
    }

    //Adding Elements in Concepts.Concepts.Queue
    public void enqueue(int data){
        if(rear==maxSize-1){
            System.out.println("Concepts.Concepts.Queue is Full");
        }
        else{
            rear++;
            queue[rear]=data;
        }
    }

    //Deleting Elements from Concepts.Concepts.Queue
    public int dequeue(){
        if(front>rear){
            System.out.println("Concepts.Concepts.Queue is Empty");
        }
        else {
            int data = queue[front];
            front++;
            return data;
        }
        return -1;
    }

    //Peek
    public int peek(){
        if(front>rear){
            System.out.println("Concepts.Concepts.Queue is Empty");
        }
        else {
            return queue[front];
        }
        return -1;
    }

    //Display
    public void display(){
        if(front>rear){
            System.out.println("Concepts.Concepts.Queue is Empty, cant display");
        }
        for(int i=front;i<=rear;i++){
            System.out.println("Data  inserted is "+queue[i]+"\n");
        }
    }

    public static void main(String[] args) {
        SimpleQueue simpleQueue = new SimpleQueue(5);
        simpleQueue.enqueue(5);
        simpleQueue.enqueue(6);
        simpleQueue.enqueue(7);
        simpleQueue.enqueue(8);
        simpleQueue.enqueue(9);
        simpleQueue.display();
        System.out.println("Data at the front/peek is " + simpleQueue.peek());
        System.out.println("Data is removed from front is  "+simpleQueue.dequeue()+"\n");
        simpleQueue.display();
    }
}
