package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsTraversal(int v ,ArrayList<ArrayList<Integer>> adj ){
        // v is noof node 
        // 1 based indexing so V+1 size of traversing array 

        ArrayList<Integer>bfsResult = new ArrayList<>();
        Boolean []visited = new Boolean[v+1];
        Queue <Integer> queue = new LinkedList<>();

        //starting bfs from node 1 

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            Integer node =queue.poll();
            bfsResult.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited and enqueue i

            for (Integer neibhour : adj.get(node)){
                if (!visited[neibhour]){
                    visited[neibhour]=true;
                    queue.add(neibhour);
                }

            }
        }
        

        return bfsResult;



    }

    
}
