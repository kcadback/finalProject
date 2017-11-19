package finalProject;

public class FaceSpace<Key extends Comparable<Key>, Value> {

	private class Node {
	        
	        Key key;
	        Value val;
	        Node left;
	        Node right;
	        int size;
	        boolean color;
	        Bag adj;
	        
	        Node(Key key, Value val, int size, boolean color, Bag adj) {
	            this.key = key;
	            this.val = val;
	            this.size = size;
	            this.color = color;
	            this.adj = adj;
	        }
	        
	    }
	
	
}

