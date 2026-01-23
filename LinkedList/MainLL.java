package LinkedList;

public class MainLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(8);
        list.insertFirst(10);
        list.insertFirst(12);
        list.insertFirst(17);
        // insert at last
        list.insertLast(99);
        list.insertLast(1000);

        list.insert(100, 3);
        list.display();
                                           
      System.out.println(list.deleteFirst());
       list.display();

       System.out.println(list.deleteLast());
       list.display();

       System.out.println(list.delete(2));
       list.display();
       

    System.out.println("iinsert using recursion ");
    list.insertRec(12, 3);
    list.display();

    list.insertFirst(12);
    list.insertFirst(132);
    list.display();
   

  

                    
                   

        
    }
    
}
