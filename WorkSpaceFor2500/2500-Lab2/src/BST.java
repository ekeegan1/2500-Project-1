
/*
 * Unlike the other lists, the Binary Search Tree is a non-linear data structure. Instead of adding words in
 * a essentially '2-D' list, we are adding them in a '3-D' list. Because of its tree-like structure, the BST
 * is named after a tree and acts in a similar way. We first start at the root, in which case in this data 
 * structure is at the top, and moves down to make leaves or branches (child nodes). This form of sorting is,
 * generally, very efficient because it can traverse code faster because it doesn't have to go through every
 * entry in the list to get to its location. More details about the Binary Search Tree can be found throughout
 * the code. 
 * 
 * Many elements in this class come from the given pseudo code from the in-class slides from Dr. Thomas.
 */

public class BST implements ListInterface
{
	//this is the top of the tree
	BSTNode root;
	
	//these are our typical metrics to be watching out for
	public int distinctWords;
	public int totalWords;
	long refChanges;
	long keyCompare;
	public int height;
	
	//constructor
	public BST()
	{
		root = null;
	}
	
	//add the word given from the main method
	@Override
	public void add(String word)
	{
		
		if(search(word) == null)		//if the word is NOT in the tree
		{
			distinctWords++;			//new distinct word
			insert(this.root, word);	//insert the word into the tree
		}			
										//if it is in the tree, do nothing 
		totalWords++;					//increase the word count
	}								
	
	//this method is called by add and it places a given worn into the tree
	public void insert(BSTNode root, String word)
	{
		//these are temporary variables to move down the tree
		BSTNode x = root;
		BSTNode y = null;
		
		//z is the new word we are adding and will be placing once we find its spot in the tree
		BSTNode z = new BSTNode(word);
		z.left = z.right = null;
		
		while(x != null)						//while we haven't reached the end of the tree
		{
			y = x;
			if(z.key.compareTo(x.key) > 0)		//if the word is earlier in the alphabet
				x = x.left;						//move to the left branch
			else								//if its later,
				x = x.right;					//move the the right branch
		}
		
		//once we reach the bottom, either:
		if(y == null)							//it's the first of the list
			this.root = z;						//so, set the first word as the root
		else if(z.key.compareTo(y.key) > 0)		//it's before the parent in the alphabet
			y.left = z;
		else									//or its after the parent in the alphabet
			y.right = z;
		
		refChanges++;	//this makes one reference Change
	}
	
	//this method is used to find whether or not a word is in the tree
	//it is called from the add method
	public BSTNode search(String word)
	{
		//assign a temporary variable to move down the tree
		BSTNode p = root;
		while(p != null)						//while we are not at the bottom of the tree,
		{
			keyCompare++;	//one new key comparison
			if(word.compareTo(p.key) == 0)		//if the word is the same as our temporary variable
				return p;						//then signify that it is in the list
			if(word.compareTo(p.key) > 0)		//if the word is earlier in the alphabet than our temporary variable
				p = p.left;						//then move the temporary variable to the left child
			else								//otherwise (it is later in the alphabet)
				p = p.right;					//move the temporary variable to the right child
		}
		return null;	//if the word is not in the list, then returns null
	}
	
	
	//Binary Search Tree Exclusive Getters Here...
	
	//returns the Total Words that are counted throughout the class
	@Override
	public int getTotalWords() 
	{
		return totalWords; 
	}
	
	//returns Reference Changes that are counted throughout the class
	@Override
	public long getRefChanges()
	{
		return refChanges;
	}
	
	//returns Key Comparisons that are counted throughout the class
	@Override
	public long getKeyCompare()
	{
		return keyCompare;
	}
	
	//distinct words is counted throughout the class
	@Override
	public int getDistinctWords()
	{
		return distinctWords; 
	}
	
	//calls the height function to return the height (requires the root)
	public int getHeight()
	{
		return height(root);
	}
	
	//calls itself to traverse the tree, counting the number of child nodes on the way
	public static int height(BSTNode root)
	{
		if(root == null)	//if the root is null,
			return 0;		//the tree is empty
		
		//For each call, whichever direction has the higher number is the path we take
		return Math.max(height(root.left), height(root.right)) + 1;		//we need the + 1 increase the height on each call
	}
		

		
}