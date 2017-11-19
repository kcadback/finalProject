package finalProject;

public class BreadthFirstTraversal {

    private boolean visited[];
    QueueArray<Integer> q = new QueueArray<Integer>();
    
    public BreadthFirstTraversal(Graph g, int source) {
        visited = new boolean[g.numNodes()];
        bfs(g,source);
    }
    
    private void bfs(Graph g, int s) {
        visited[s] = true;
        System.out.print(s + " ");
        q.enqueue(s);
        while (!q.isEmpty()) {
                int v = q.dequeue();
                for (int w : g.adj(v)) {
                    if (!visited[w]) {
                        visited[w] = true;
                        System.out.print(w + " ");
                        q.enqueue(w);
                    }
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
            
        BreadthFirstTraversal bfs = new BreadthFirstTraversal(g,0);
    }
}