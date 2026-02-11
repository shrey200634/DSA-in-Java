package Trees;

import java.util.Stack;

public class DFS {
      class Node {
        int value ;
        Node left ;
        Node right ;

        public Node (int value){
            this.value=value;

        }
    }
    //dfs using stack 

   public  void dfsStack ( Node node  ){
    if (node ==null){
        return ;
    }
    Stack <Node > stack = new Stack<>();
    stack.push(node);

    while ( !stack.isEmpty()){
        Node removed = stack.pop();
        System.out.println(removed.value + " ");
         if (removed.right!=null){
            stack.push(removed.right );
        }
        if (removed.left!=null){
            stack.push(removed.left);
        }
    }
   }
    
}
