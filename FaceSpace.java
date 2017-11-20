package finalProject;

import finalProject.RedBlackBST.Node;

public class FaceSpace<Key extends Comparable<Key>, Value> extends RedBlackBST {

	private Node root;
	
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
	
	public Value searchFriend(Key key) {
		return searchFriend(root, key);
	}
	
	private Value searchFriend(Node n, Key key) {
		if ( n == null ) return null;	//key not found
		int cmp = key.compareTo(n.key);
		if ( cmp < 0 )
			return searchFriend(n.left, key);
		else if ( cmp > 0)
			return searchFriend(n.right, key);
		else
			return n.val;
	}
	
}

