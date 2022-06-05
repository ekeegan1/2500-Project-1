import java.util.Random;

/*
 * List 5 refers to the Skip List type. This uses parts of the SkipListNode class
 * and implements ListInterface. This is a very efficient method of parsing a list.
 * What is special about this list is it is several lists in parallel in order to 
 * differentiate between fast lanes and slow lanes. These lanes can be taken to
 * 'skip' through the list. Once it finds its place in the slow lane, were done!
 * 
 * Many elements in this class are credited to the Emory University webpage given in the 
 * project hand out including parts of add and search to name a couple.
 */


public class List5 implements ListInterface
{

	public SkipListNode head; // First element of the top level
	public SkipListNode tail; // Last element of the top level

	public int distinctWords; // number of unique entries in the Skip List
	public int totalWords;	  //number of total entries in the Skip List

	public int height; 		//height of lanes
	public Random random; 	// Coin toss
	
	long refChanges;	
	long keyCompare;
	
	public List5()    // Constructor...
	{    
		SkipListNode p1 = new SkipListNode("");
	   	SkipListNode p2 = new SkipListNode("");
	    
	   	//here is front and back links
	   	head = p1;
	   	tail = p2;
	    
	   	p1.right = p2;
	   	p2.left = p1;
	    
	   	p1.isSentinel = true;
	   	p2.isSentinel = true;
	   	
	   	//data collecting variables
	   	totalWords = 0;
	   	distinctWords = 0;
	    height = 0;
	    random = new Random();
	}

	
	//Put a key-value pair in the map, replacing previous one if it exists
	//this method calls search to find where we're working
	@Override
	public void add(String word) 
	{
		  SkipListNode p, q;
		  int i;
		  
		  p = search(word);		//search for the location of the word


		  //Check if key is found
		  if (word.equals(p.getKey()))
		  {
			  totalWords++;		//increase the words count
			  return;
		  }

		 //Insert new entry 
	     q = new SkipListNode(word);
	     totalWords++;
	     q.left = p;
	     q.right = p.right;
	     p.right.left = q;
	     p.right = q;
	     refChanges += 4;	//links make 4 reference changes
	    
	     i = 0;             // Current level = 0

	     //level(height) creation
	    while ( random.nextDouble() < 0.5 )
	    {
			// Coin flip success: make one more level....
	
		   if ( i >= height )
		   {
			   SkipListNode p1, p2;
		
			   height = height + 1;
		
			   
			   //make new head and tails for the new row
			   p1 = new SkipListNode("");
			   p2 = new SkipListNode("");
			   
			   p1.right = p2;
			   p1.down  = head;
		
			   p2.left = p1;
			   p2.down = tail;
		
			   head.up = p1;
			   tail.up = p2;
		
			   refChanges += 6;			//this makes 6 reference changes
			   
			   head = p1;				//assign them to head and tail
			   tail = p2;

			   p1.isSentinel = true;	//and make them sentinels
			   p2.isSentinel = true;
		   }
	
		   	//move p back
			//Scan backwards
			while ( p.up == null )
			{
				p = p.left;
			}
	
			p = p.up;
	
	
		    //Add one more to the column
			SkipListNode e;
		   		 
		   	e = new SkipListNode(word);  // Don't need the value...
		   		 
		   	//Initialize links of e
		   	e.left = p;
		   	e.right = p.right;
		   	e.down = q;
		   		 
		   	
		   	//Change the neighboring links..
		   	p.right.left = e;
		   	p.right = e;
		   	q.up = e;
		   	
		   	refChanges += 6;	//this makes 6 reference changes
	
		    q = e;		// Set q up for the next iteration
	
		    i = i + 1;	// Current level increased by 1

		    
	     }

	    distinctWords = distinctWords + 1;	//we make a new node including a unique word

	     return;  
	  }
	
	//this method is called by add()
	//it looks thought the skip list to (hopefully) find the matching word
	  public SkipListNode search(String word)
	  {
		  SkipListNode p;

		  //Start at "head"
		  p = head;

		  while ( true )
		  {
			  //Search RIGHT until you find a LARGER entry
			  while ( p.right.isSentinel != true && p.right.key.compareTo(word) <= 0 )
			  {
				  keyCompare++;	//key comparison every move
				  p = p.right;
			  }
	
			  //Go down one level if you can
			  if ( p.down != null )
			  {  
				  keyCompare++;	//key comparison every move
				  p = p.down;
			  }
			  else
				  break;	// We reached the LOWEST level... Exit...
	     }	     return(p);         // p.key <= word
	  }

	  
	//Skip List Exclusive Getters Here...
	  
	//Returns the number of entries in the hash table.
	@Override
	public int getTotalWords() 
	{ 
		return totalWords; 
	}

	//Returns whether or not the table is empty.
	public boolean isEmpty() 
	{ 
		return (distinctWords == 0); 
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

	//returns height that is kept track throughout the class
	public int getHeight()
	{
		return height;
	}
	
}
