package Graph;

import java.util.Arrays;

import recursion.recursion;

public class BellmanFordAlgo {
    static class Edge {
        int src ;
        int dis ;
        int weight ;

        Edge(int src , int dis , int weight ){
            this.dis=dis ;
            this.src=src;
            this.weight=weight;

        }
    }

    public static void algo (int vertices , Edge[] edges, int source ){
        int []dis = new int[vertices];
        Arrays.fill(dis, Integer.MAX_VALUE); 

        dis[source]=0 ;
        // relax all the edges 
        for(int i =1 ; i<vertices ; i++){
            for(Edge edge :edges){
                int u =edge.src;
                int v = edge.dis;
                int w = edge.weight;
                
             if ( dis[u]!= Integer.MAX_VALUE && dis[u] + w < dis[v]){
                dis[v] = dis[u] +w ;
             }
        }


    }
    // check for negative cycle weight 
    for (Edge edge : edges){
        int u = edge.src ;
        int v = edge.dis;
        int w = edge.weight ;


if (dis[u] != Integer.MAX_VALUE && dis[u] + w < dis[v]) {
    System.out.println("cycle detected , negative cycle , shortesh path cannot compute ");
    return;
        }
    }

    //computed shortest distance 
    printSolution (dis , source );
}

    private static void printSolution(int[] dist, int source) {
        System.out.println("Vertex Distance from Source (" + source + "):");
        for (int i = 0; i < dist.length; i++) {
            String distanceStr = (dist[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(dist[i]);
            System.out.println(i + " \t\t " + distanceStr);
        }
    }

    public static void main(String[] args) {
        int vertices =5 ;

        Edge[] edges = new Edge[] {
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        };

        int sourceVertices =0 ;
        algo(vertices, edges, sourceVertices);


        
    }

    
}
