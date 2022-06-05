/*
 * This LLNode class is used as the foundation for BaseList and all of the other created lists.
 * It holds all of the necessary variables, setters, and getters for the code. The class is fairly
 * straightforward. It basically holds all of the repetitive, yet highly necessary functions.
 */

public class LLNode
{
	public String word;
	public int count;
	public LLNode next = null;
	
	public LLNode(String word, int count) 
	{
		this.word = word;
		this.count = count;
		next = null;
	}

	public LLNode getNext()
	{
		return this.next;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public LLNode getLink()
	{
		return next;
	}
	
	public String getNode()
	{
		return word;
	}
	
	public void setNext(LLNode newNext)
	{
		this.next = newNext;
	}
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	
}
