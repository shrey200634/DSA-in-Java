package StackQueue;

public class StackMain  {
    public static void main(String[] args) throws CustomException {  // it throws an exception so we need to mention here also
        
    
    CustomStack stack =new CustomStack(5);
       stack.push(12);
        stack.push(43);
        stack.push(92);
        stack.push(100);
        stack.push(52);


         System.out.println(stack.pop());
                System.out.println(stack.pop());
                        System.out.println(stack.pop());
                                System.out.println(stack.pop());
                                        System.out.println(stack.pop());
    
}
}