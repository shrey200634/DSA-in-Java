package Trees.AVLTree;

public class AVLTree {
    
    public class Node {

        
        private int value  ;
        private Node left ;
        private Node right ;
        private int height ;
         //constructor 
        public Node (int value ){
            this.value =value ;

        }
        //get value function 
        public int getValue(){
            return value ;

        }

    }

    private Node root;
// my constructor 
    public AVLTree(){

    }
    // just returning the height 

    public int height() {
    return height(root);
  }

    public int height (Node node ){
        if (node ==null){
            return -1 ;
        }
        return node.height;

    }

    public boolean isEmpty (){
        return root ==null;

    }

    public void insert(int value ){
        root =insert(value, root);

    }

    private Node  insert(int value , Node node ){
        if (node ==null){
            node =new Node(value);
            return node ;


        }
        if (value <node.value){
            node .left =insert(value , node.left);
        }
        if (value >node.value ){
            node .right =insert(value , node.right );
        }
        // when u added new node .. max height of any node will be plus 1 
              // node.height = Math.max(height (node.left), height (node.right) )+1; 

        node.height = Math.max(height (node.left), height (node.right) )+1;
        // return current node 
        return Rotate(node) ;


    }
    //------------------------------------------------------------------------------------------------//


    private Node Rotate(Node node) {
    if (height(node.left) - height(node.right) > 1) {
      // left heavy
      if(height(node.left.left) - height(node.left.right) > 0) {
        // left left case
        return rightRotate(node);
      }
      if(height(node.left.left) - height(node.left.right) < 0) {
        // left right case
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }

    if (height(node.left) - height(node.right) < -1) {
      // right heavy
      if(height(node.right.left) - height(node.right.right) < 0) {
        // right right case
        return leftRotate(node);
      }
      if(height(node.right.left) - height(node.right.right) > 0) {
        // left right case
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }

    return node;
  }

  public Node rightRotate(Node p) {
    Node c = p.left;
    Node t = c.right;

    c.right = p;
    p.left = t;
    
    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);

    return c;
  }

  public Node leftRotate(Node c) {
    Node p = c.right;
    Node t = p.left;

    p.left = c;
    c.right = t;
    
    p.height = Math.max(height(p.left), height(p.right) + 1);
    c.height = Math.max(height(c.left), height(c.right) + 1);

    return p;
  }


  //----------------------------------- -----------------------------------------------------//

    // make populate function 
    public void populate (int []nums ){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // for sorted array .... 
     public void populatedSorted (int []nums , int start , int end){
        if(start >=end){
            return ;
        }
        int mid =(start +end )/2;
        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid+1, end);
     }
 
    // check weather the tree is balanced or not 
    public boolean balanced (){
       return  balanced (root );
    }
    private boolean balanced ( Node node  ){
        if (node ==null){
            return true ;

        }
        // && is used to check for the left tree and right tree 
        return Math.abs(height(node.left) - height (node.right)) <=1 &&  balanced(node.left ) && balanced(node.right );
    }
    // lets make display function 

    public void display (){
        display (this.root , " root node : ");

    }
    private  void display( Node node , String details  ){
        if (node == null){
            return ;
        }
        System.out.println(details + node.value);
        display(node.left , "left chile of "  + node.value + ":");
        display(node.right  , "right chile of "  + node.value + ":");

    }  
}

    
