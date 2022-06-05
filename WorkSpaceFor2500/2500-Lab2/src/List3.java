
/*
 * List 3 refers to the Self-Adjusting list type. This extends from the BaseList class and 
 * implements ListInerface abstract class. This is the 'Heavy Handed' adjustment.
 * Essentially, it looks through the list in hopes to find the same word as the current 
 * word in the text. This comes with the added factor of if it finds the word were looking 
 * for, it moves that node for the word all the way to the front of the list.
 */

public class List3 extends BaseList implements ListInterface
{
	//this pulls from parent classes
	public List3()
	{
		super();
	}

	//this is the special part of the list. It takes this path to add a word to the list when specified.
	@Override
	public void add(String word)
	{
		//location and previous are important place holders for searching through the list
		LLNode newNode = new LLNode(word, 1);
		LLNode location = list;
		LLNode previous = null;

		//this is for the first word added because the first only makes one reference change
		if(location == null)	//if the location is empty
		{
			list = newNode;
			refChanges++;
			return;
		}

		while (location != null)						//while we are not at the bottom of the list
		{
			keyCompare++;								//we compare to a another word
			if (word.compareTo(location.word) == 0)		//if the two comparing words are the same
			{
				location.count++;						//increase that words count
				
				if(previous == null)					//if the word is already at the front,
					return;								//then were done
				
				//heavy handed movement
				previous.setNext(location.getNext());	//this moves the word that was increased in count to the front of the list
				location.setNext(list);	
				list = location;
		
							
				refChanges++;	//this movement makes three reference changes
				refChanges++;
				refChanges++;
				
				return;
			}
			previous = location;		//if the spot is not found move our temporary variables to the next word over
			location = location.next;
		}

		//this is if there is no matching words
		//add it to the front of the list
		newNode.setNext(list);
		list = newNode;
		refChanges++;		//this makes 2 reference changes
		refChanges++;
		return;
	}
}
