package Graph;

import java.util.ArrayList;
import java.util.List;

public class DisJointUnionBySize {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    // Constructor to initialize the parent and size arrays
    public DisJointUnionBySize(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    // Find ultimate parent with Path Compression
    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    // Union by Size
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        // If they have the same ultimate parent, they are already in the same component
        if (ulp_u == ulp_v) return;
        
        // Attach the smaller component to the larger component
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


