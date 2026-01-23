package StackQueue;

public class CustomStack {
    protected int [] data ;
    private static final int DEFAULT_SIZE =10;
    int ptr =-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data =new int[size];
    }


    public int pop() throws CustomException{
        if (isEmpty()){
            throw new CustomException("cannot pop from empty stack ");
        }
        // int removed =data[ptr];
        // ptr--;
        // return removed;   // also can be done with easy way 
        return  data[ptr--];
    }


    public int peek() throws CustomException{
         if (isEmpty()){
            throw new CustomException("cannot find peek from empty stack  ");
        }
        return data[ptr ] ;
    }


    public boolean push(int  item ){
        if (isFull()){
            System.out.println("stack is full ");
            return false ;
        }
        ptr++;
        data[ptr]=item ;
        return true;

    }
    
    public boolean isFull (){
        return ptr == data.length-1;  // pointer is at last 

    }
    public boolean isEmpty(){
        return ptr ==-1;
    }

    
}
