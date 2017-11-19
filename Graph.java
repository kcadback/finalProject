package finalProject;
public class Graph {

	private int numNodes;;
	private int numEdges;
	private Bag<Integer>[] adj;
	
	public Graph(int numVertices) {
		initializeEmptyGraph(numVertices);
	}
	
	private void initializeEmptyGraph(int numVertices) {
		this.numNodes = numVertices;
		this.numEdges = 0;
		adj = (Bag<Integer>[]) new Bag[numVertices];
		for (int v = 0; v < numVertices; v++) {
			adj[v] = new BagArray<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		numEdges++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int numVertices() {
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
		sb.append(numNodes + " vertices, " + numEdges + " edges " + NEWLINE);
		for (int v = 0; v < numNodes; v++) {
			sb.append( v + ": " );
			for ( int w : adj[v] ) { // for every w that is adjacent to v
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
