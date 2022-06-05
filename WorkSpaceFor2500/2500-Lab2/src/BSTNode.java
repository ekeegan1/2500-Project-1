
/*
 * This node class is fairly straightforward. It provides the Binary Search Tree
 * Class with the variables it needs to be able to function properly.
 */


public class BSTNode
{
	String key;					 	// comparable value we use to determine position
	public BSTNode left, right;		// links to child nodes
	
	BSTNode(String word)
	{
		key = word;
		left = right = null;
	}
}
