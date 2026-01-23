package LinkedList;

public class MainCLL {
    public static void main(String[] args) {
        CLL list= new CLL();
        list.insert(32);
        list.insert(23);
        list.insert(1);

        list.display();
        list.delete(23);
        list.display();
    }
    
}
