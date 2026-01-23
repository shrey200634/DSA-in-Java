package LinkedList;

public class MainDL {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(2);
        list.insertFirst(4);

        list.display();

        list.insertLast(99);
        list.display();


        list.insertAfterParticularValue(2, 22);
        list.display();
    }
    
}
