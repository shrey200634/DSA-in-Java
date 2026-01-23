package StackQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);

        queue.display();
        System.out.println("removeing from queue ");
        queue.remove();
        queue.display();
        System.out.println(queue.isFull());
        // we have make our own custom queue 


        
    }
    
}
