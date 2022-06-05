
public class LLStack
{

	public class LLNode<T>
	{
		protected T info;      // the data this node stores 
		protected LLNode link; // a link to the NEXT node
		  
		  
		public LLNode(T info)
		{
		  this.info = info;
		  link = null;
		}
	
		public void setInfo(T info)
		{
		  this.info = info;
		}
	
		public T getInfo()
		{    
		  return info;
		}
	
		public void setLink(LLNode<T> link)
		{
		  this.link = link;
		}
	
		public LLNode<T> getLink()
		{
		  return link;
		}
	
		
		
	}
//need push/pop/isEmpty
//
}
