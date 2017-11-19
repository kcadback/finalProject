package finalProject;

public class DepthFirstTraversal {

    private boolean visited[];
    
    public DepthFirstTraversal(Graph g, int source) {
        visited = new boolean[g.numNodes()];
        dfs(g,source);
    }
    
    private void dfs(Graph g, int v) {
        visited[v] = true;
        System.out.print(v+" ");  
        for (int w : g.adj(v)) {
            if (! visited[w]) {
                dfs(g,w);
            }
        }
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
            
        DepthFirstTraversal cc = new DepthFirstTraversal(g,0);
    }
}
