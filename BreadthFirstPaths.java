package finalProject;

import java.util.Stack;

public class BreadthFirstPaths {
    
    private boolean[] visited;
    private int[] edgeTo;
    private final int source;
    
    public BreadthFirstPaths(Graph g, int source) {
        visited = new boolean[g.numVertices()];
        edgeTo = new int[g.numVertices()];
        this.source = source;
        bfs(g,source);
    }
    
    private void bfs(Graph g, int source) {
        QueueArray<Integer> queue = new QueueArray<Integer>();
        visited[source] = true;
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                if (! visited[w]) {
                    edgeTo[w] = v;
                    visited[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return visited[v];
    }
    
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
    
public static void main(String[] args) {
        
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 6);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(g);
        
        BreadthFirstPaths paths = new BreadthFirstPaths(g,0);
        for (int v = 1; v < g.numVertices(); v++) {
                System.out.println(paths.pathTo(v));
        }
        
    }

}

