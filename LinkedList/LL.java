package LinkedList;
public class LL {

    private Node head ;
    private Node tail;
    private int size ;

    public LL(){
        this .size =0;


    }

    public void insertFirst( int val ){
        Node node = new Node (val);
        node.next = head;
        head = node ;

        if ( tail== null){
            tail=head ;

        }
       size +=1;

    }
    public void insertLast(int val){
        if (tail==null){
            insertFirst(val);
            return;

        }
        Node node = new Node(val);
        tail.next =node ;
        tail = node ;
        size ++;

    }

    public void insert(int val , int index ){
        if (index ==0){
            insertFirst(val);
            return ;
        }
        if ( index ==size ){
            insertLast(val);
            return ;

        }
        Node temp = head ;
        for (int i = 1; i < index ; i++) {// i not start from 0 cauzz 0 is itself head which is temp
            temp = temp.next ;
            
        }
        Node node = new Node (val , temp.next );
        temp.next = node;
        size ++;


    }
    // insert using recursion ;
    public void insertRec (int val , int index ){
        head = insertRec(val, index, head);


    }
    private Node insertRec(int val , int index , Node node ){
        if ( index ==0){
            Node temp = new Node (val, node );
            size ++;
            return temp ;

        }
        node .next =insertRec(val, index-1, node.next);
        return node ;

    }

    public int deleteLast(){
        if (size<=1){
            return deleteFirst();

        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next= null;

        return val;
    }

    public int delete ( int index ){
        if ( index ==0){
           return  deleteFirst();
        }
        if ( index == size-1){
           return  deleteLast();

        }

        // otheerwise go to index-1

        Node previous = get(index-1);
        int val = previous.next.value;

        previous.next = previous.next.next ;



        return val;


    }
    public Node get( int index ){     // for delete last elment one 
        Node node = head;
        for (int i = 0; i < index ; i++) {
            node =node .next;

            
        }
        return node ;

    }
    public Node find ( int value  ){     // for delete last elment one 
        Node node = head;
       while (node != null){
        if ( node .value == value ){
            return node ;

        }
        node = node .next;

       }
        return null ;   // if nothing is found just return null 

    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next ;
        if (head == null){
            tail= null;

        }
        size--;
        return val;


    }
    // display  function 
    public void display (){
        Node temp = head ;
        while (temp != null){
            System.out.print(temp.value + "-->");  // no new line so dont use ln 
            temp = temp.next;

        }
        System.out.println("END");
    }

    // here we r making class in which we r defining the structure of our linked list 
    // in this we initiallise two variables and making their constructor 

    private class Node{
       private  int value ;
       private  Node next;

       public Node(int value ){
        this.value = value;

       }
        public Node(int value, Node next ){
        this.value = value;
        this.next= next ;
        
       }

    }
    
}
