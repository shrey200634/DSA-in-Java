package Trees.BinaryTree;

import java.util.Scanner;
import java.util.*;



public class BinaryTree {

    public BinaryTree(){ /// default one 

    }

    private static class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value=value;

        }
    }
    private Node root;

    // insert elements      
    //  /// this is the root node in this we use recursion to inset new nodes
    public void populate(Scanner Scanner ){
        System.out.println("enter the root node ");
        int value =Scanner.nextInt();
        root =new Node(value);
          popoulate(Scanner ,root);
     

    }
    // now we r going to code preorder
    public void preorder(Node node ){
        if (node ==null){
            return ;
        }
        System.out.println(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public void Inorder(Node node ){
        if (node ==null){
            return ;
        }
       
        Inorder(node.left);
         System.out.println(node.value + " ");
        Inorder(node.right);
    }
    public void postorder(Node node ){
        if (node ==null){
            return ;
        }
        
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value + " ");
    }
    
    private void popoulate (Scanner Scanner, Node node ){
        // for left tree 


        System.out.println("do u want to enter left of "+ node.value);
        boolean left = Scanner.nextBoolean();

        if (left){
            System.out.println("enter the value of left of "+ node.value);
            int value = Scanner.nextInt();
            node.left=new Node(value);
            popoulate(Scanner, node.left);  // call recursion for new node and repeeat same 
        }
        // for right tree 


        System.out.println("do u want to insert right of " + node.value);
        boolean right = Scanner.nextBoolean();

        if (right ){
            System.out.println("enter the value of right of "+ node.value);
            int value = Scanner.nextInt();
            node.right= new Node (value);
            popoulate(Scanner, node.right);
        }


    }

    // display function 
    public void display(){
        Display(root , " ");

    }
    private void Display(Node node , String indent ){ // indent is just a space we r provided 
        if (node==null){
            return ;
        }
        System.out.println(indent + node.value);
        // recursion call 
        Display(node.left, indent + "\t");
                Display(node.right , indent + "\t");
    }

    public void prettyDisplay(){
        PrettyDisplay(root , 0);
    }







    private void PrettyDisplay(Node node  , int level){
        if (node ==null){
            return ;
        }
        PrettyDisplay(node.right , level+1);
        if (level!=0){
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
                
            }
             System.out.println("|--------->" +node.value);

        }else {
            System.out.println(node.value);

        }
        PrettyDisplay(node.left, level+1);

    }
 
    public static void main(String[] args) {
        Scanner Scanner = new Scanner (System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(Scanner);
        tree.display();
        tree.prettyDisplay();

    }
}
