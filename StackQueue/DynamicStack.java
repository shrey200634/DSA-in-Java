package StackQueue;

public class DynamicStack  extends CustomStack{
    public DynamicStack(){
        super(); // it will call Customstack 
    }
    public DynamicStack (int size ){
        super(size);
    }
    @Override
    public boolean push(int item) {
        if (this.isFull()){
            //double the arraySize
            int []temp =new int [data.length *2];
            //copy al previous item in new data 
            for (int i = 0; i < data.length; i++) {
                temp[i]=data[i];
                
            }
            data =temp;

        }
        // at this point we know array is not full so we just isnert it 
        // insert item 
        return super.push(item);
    }

    
}
