package Graph;

import java.util.ArrayList;

import recursion.recursion;

public class DFS {
    public static void dfs(int node , boolean vis[], ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> ls){

        vis[node] =true ;
        ls.add(node );

        //getting neibhour node ;

        for (Integer it : adj.get(node)){
            if (vis[it] ==false ){
                dfs(it, vis, adj, ls);
            }
        }
    }

    // function to return the list containing the dfs traversal of the graph 

    public ArrayList<Integer> dfsOfGraph(int v ,  ArrayList<ArrayList<Integer>> adj){

        //boolean array to keep track of th visited array 
        boolean vis[] = new boolean[v+1];
        vis[0] = true ;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls ;
    }
    
}
