package Trees.BinarySearchTree;

public class BSTMain {
    public static void main(String[] args) {
        
    
    BST tree=new BST();
    int []nums= {15,21,42,12,10,1,83};
    tree.populate(nums);
    tree.display();

    BST tree2 = new BST();
    int []nums2 = {5,2,7,1,4,6,9,8,3,10};
    tree2.populate(nums2);
    tree2.display();

    BST tree3 =new BST();
    int []nums3= {1,2,3,4,5,6,7,8,9,10};
    tree3.populatedSorted(nums3, 0, nums3.length); 
    tree3.display();
    

    
}
}