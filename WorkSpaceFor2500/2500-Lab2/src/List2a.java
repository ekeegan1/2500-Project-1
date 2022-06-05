
/*
 * List 2a is the modified sorted list type. This extends from the BaseList class and 
 * implements ListInerface abstract class. Similar to list 2, it adds words into the 
 * list alphabetically. Although, instead of starting from the front of the list every
 * run, it checks the word to see if it comes before or after the last word added.
 */

public class List2a extends BaseList implements ListInterface
{
	//this pulls from parent classes
	public List2a()
	{
		super();
	}
	
	//this saves the word added to be compared to next run
	LLNode lastLocation = null; 
	LLNode lastPrevious = null;
	
	@Override
	public void add(String word)
	{
		//location and previous are important place holders for searching through the list
		LLNode location;
		LLNode previous;
		LLNode newNode = new LLNode(word, 1);
		
		if(lastLocation == null)		//if list is empty
		{
			list = newNode;				//make a new node
			lastLocation = newNode;		//point lastWord to the new node
			
			refChanges++;			//refChange for adding the node
			
			lastLocation = list;	//save the lastLocation for next run
			lastPrevious = null;	//save the lastPrevious for next run
			
			return;
			
		}
		
		//we need to make an extra comparison to see if word is before or after our last word
		keyCompare++;
		if(word.compareTo(lastLocation.word) >= 0)	//if the word is at lastLocation or after
		{
			location = lastLocation;				//then start at lastLocation
			previous = lastPrevious;
		}
		else										//otherwise,
		{	
			location = list;						//start from the beginning
			previous = null;
		}
			
		//after we define our starting point, we can run the add (similar to List 2)
		while(location != null)		//while we are not at the bottom of the list
		{
			keyCompare++;									//we compare to a another word
			int compare = word.compareTo(location.word);	//this is used for repetitive comparison from the two comparing words
			
			if(compare == 0)		//this means we landed on top of the same word
			{
				location.count++;	//increase that words count
				
				lastLocation = location;	//save the lastLocation for next run
				lastPrevious = previous;	//save the lastPrevious for next run
				
				return;
			}
			else if(compare < 0) 	//this means we need to add the node before this node (for alphabetize)
			{
				newNode.setNext(location);
				if(previous == null)			//when the previous word is not on a word(null)
					list = newNode;				//null pointer go goes to our new word
				else
					previous.setNext(newNode);	//otherwise, put the previous word pointing towards the our new word
				
				refChanges++;	//this action makes two reference changes
				refChanges++;
				
				lastLocation = newNode;		//save the lastLocation for next run
				lastPrevious = previous;	//save the lastPrevious for next run				
				
				return;
			}
			else		//if the spot is not found move our temporary variables to the next word over
			{
				previous = location;
				location = location.next;
			}
		}
		
		//this is if there is no matching words it must be the farthest in the alphabet
		//add the word at the very end of the list		
		previous.setNext(newNode);
		refChanges++;		//this makes 2 reference changes
		refChanges++;
		
		lastLocation = newNode;		//save the lastLocation for next run
		lastPrevious = previous;	//save the lastPrevious for next run
		
		return;
	}
}