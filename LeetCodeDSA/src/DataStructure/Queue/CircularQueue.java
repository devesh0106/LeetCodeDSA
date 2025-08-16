package DataStructure.Queue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size; //How many elements are?
    private int maxSize; // MaxSize of Concepts.Concepts.Queue

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    //add elements
    public void enqueue(int data){
        if(size==maxSize){
            System.out.println("Concepts.Concepts.Queue is full");
        }
        rear=(rear+1)%maxSize; //Capacity=10 so it can max go to 9. so 9+1%10 back to 0.
        queue[rear]=data;
        size++;
        //System.out.println("Elements in Circular Concepts.Concepts.Queue "+queue[rear]);
    }

    //delete elements from front
    public int dequeue(){
        if(size==0){
            System.out.println("Concepts.Concepts.Queue is Empty");
        }

        int data = queue[front];
        front=(front+1)%maxSize;
        size--;
        return data;
    }

    //return number of elements
    public int size(){
        return this.size;
    }

    //Display
    public int display(){
        if(size==0){
            System.out.println("Concepts.Concepts.Queue is Empty");
        }
        for(int i=front;i<=rear;i++){
            System.out.print( queue[i]+" \t");
        }
        return -1;
    }
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.enqueue(7);
        circularQueue.display();
        System.out.println("\n"+"Size of Concepts.Concepts.Queue is "+circularQueue.size());
        System.out.println("dequeue " +circularQueue.dequeue());
        circularQueue.display();
    }
}
