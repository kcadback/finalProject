package finalProject;
public class Graph<Node extends RedBlackBST> {

	private int numNodes;
	private int numEdges;
	private Bag<Node>[] adj;
	
	public Graph(int numNodes) {
		initializeEmptyGraph(numNodes);
	}
	
	private void initializeEmptyGraph(int numNodes) {
		this.numNodes = numNodes;
		this.numEdges = 0;
		adj = (Bag<Node>[]) new Bag[numNodes];
		for (int v = 0; v < numNodes; v++) {
			adj[v] = new BagArray<Node>();
		}
	}
	
	public void addEdge(int v, int w) {
		numEdges++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Node> adj(int v){
		return adj[v];
	}
	
	public int numNodes() {
		return this.numNodes;
	}
	
	public int numEdges() {
		return this.numEdges;
	}
	
	public int degree(int v) {
		return adj[v].size();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		sb.append(numNodes + " Nodes, " + numEdges + " edges " + NEWLINE);
		for (int v = 0; v < numNodes; v++) {
			sb.append( v + ": " );
			for ( Node w : adj[v] ) { // for every w that is adjacent to v
				sb.append(w + " ");
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
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
		
	}
	
	
}
