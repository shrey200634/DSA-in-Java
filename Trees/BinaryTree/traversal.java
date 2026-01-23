package Trees.BinaryTree;

public class traversal  {
private static class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value=value;

        }
    }
    private Node root;


  /// preorder 
     public void preorder(Node node ){
        if (node ==null){
            return ;
        }
        System.out.println(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    /// Inorder 
    public void Inorder(Node node ){
        if (node ==null){
            return ;
        }
       
        Inorder(node.left);
         System.out.println(node.value + " ");
        Inorder(node.right);
    }


    /// postorder 
    public void postorder(Node node ){
        if (node ==null){
            return ;
        }
        
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value + " ");
    }
    
}
