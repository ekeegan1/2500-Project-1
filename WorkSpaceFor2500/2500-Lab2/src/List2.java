
/*
 * List 2 refers to the sorted list type. This extends from the BaseList class and 
 * implements ListInerface abstract class. Essentially, it looks through the list
 * in hopes to find the same word as the current word in the text. This comes with
 * the added factor of if it finds a word that comes after the current word. If the 
 * current word comes before the next word in the list, then it is placed in front of
 * that word.
 */

public class List2 extends BaseList implements ListInterface
{
	//this pulls from parent classes
	public List2()
	{
		super();
	}
	
	//this is the special part of the list. It takes this path to add a word to the list when specified.
	@Override
	public void add(String word)
	{
		//location and previous are important place holders for searching through the list
		LLNode location = list;
		LLNode previous = null;
		LLNode newNode = new LLNode(word, 1);
		
		//this is for the first word added because the first only makes one reference change
		if(location == null)	//if the location is empty
		{
			list = newNode;
			refChanges++;
			return;
		}
		
		
		while(location != null)								//while we are not at the bottom of the list
		{
			keyCompare++;									//we compare to a another word
			int compare = word.compareTo(location.word);	//this is used for repetitive comparison from the two comparing words
			
			if(compare == 0)		//this means we landed on top of the same word
			{
				location.count++;	//increase that words count
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
		return;
		
	}
}
