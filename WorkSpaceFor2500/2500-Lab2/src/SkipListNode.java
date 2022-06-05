
/*
 * This node class is fairly straightforward. It simply sets up Skip List by providing it a place
 * to get its nodes. This also contains an important constructor and many setters and getters 
 * that are not all used. This is because they are just a copy of the LLNode class. 
 * 
 * Some elements in this class are credited to the Emory University webpage given in the 
 * project hand out
 */

public class SkipListNode
{
	public String key; 	// comparable value we use to determine position
	public int count; 	// auxiliary data associated with the key
	public String word;	
	public SkipListNode next = null;
	Boolean isSentinel; // used for placement of head and tail
	public int height;	//saves the value of height for the output

	public SkipListNode up, down, left, right; // all four links

	// constructors getters setters here

	SkipListNode(String word)
	{
		up = down = left = right = null;
		count = 1;
		isSentinel = false;
		key = word;
	}

	public SkipListNode getNext()
	{
		return this.next;
	}

	public int getCount()
	{
		return this.count;
	}

	public SkipListNode getLink()
	{
		return next;
	}

	public String getNode()
	{
		return word;
	}

	public void setNext(SkipListNode newNext)
	{
		this.next = newNext;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public String getKey()
	{
		return key;
	}

	//this method comes from the Emory University webpage provided
	public boolean equals(Object o)
	{
		SkipListNode ent;

		try
		{
			ent = (SkipListNode) o; // Test if o is a SkipListEntry...
		} 
		catch (ClassCastException ex)
		{
			return false;
		}

		return (ent.getKey() == key) && (ent.getCount() == count);
	}

	public String toString()
	{
		return "(" + key + "," + count + ")";
	}
}