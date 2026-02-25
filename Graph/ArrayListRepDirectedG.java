package Graph;

import java.util.ArrayList;

public class ArrayListRepDirectedG {
    public static void main(String[] args) {
        int v =4;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i =0 ; i<v; i++){
            list.add(new ArrayList<Integer>());
        }

        // 2. Add edges (Directed)
        addEdge(list, 0, 1); // 0 -> 1
        addEdge(list, 1, 2); // 1 -> 2
        addEdge(list, 2, 0); // 2 -> 0
        addEdge(list, 2, 3); // 2 -> 3

        // 3. Print the graph
        printGraph(list);


        
    }

    public static void addEdge (ArrayList<ArrayList<Integer>> list , int u , int v){

        list.get(u).add(v);
        // we are not add reverse dir ;

    }
    static void printGraph(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " -> ");
            for (Integer neighbor : list.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
}
