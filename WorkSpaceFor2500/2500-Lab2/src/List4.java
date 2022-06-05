
/*
 * List 4 refers to the Self-Adjusting list type. This extends from the BaseList class and 
 * implements ListInerface abstract class. This is the 'Light Handed' adjustment.
 * Essentially, it looks through the list in hopes to find the same word as the current 
 * word in the text. This comes with the added factor of if it finds the word were looking 
 * for, it moves that node for the word one step in front of the previous node.
 */

public class List4 extends BaseList implements ListInterface
{
	//this pulls from parent classes
	public List4()
	{
		super();
	}
	
	//this is the special part of the list. It takes this path to add a word to the list when specified.
	@Override
	public void add(String word)
	{
		//location previous, and previous2 are important place holders for searching through the list
		LLNode newNode = new LLNode(word, 1);
		LLNode location = list;
		LLNode previous = null;
		LLNode previous2 = null;

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
				
				if(previous == null)					//if we are at the front of the list
				{
					return;								//we do not need to move the word
				}
				if(previous2 == null)					//if previous2 doesn't refer to a word
				{
					previous.setNext(location.next);	//we put the word at the very front
					location.setNext(previous);			
					list = location;
					
					refChanges++;						//this movement has 3 reference changes
					refChanges++;
					refChanges++;
				}
				else									//if there are no exceptions to this two words being the same
				{
					previous.setNext(location.next);	//we take our planed switch of moving the matching words 
					location.setNext(previous);			//	one step ahead of the previous word
					previous2.setNext(location);
					refChanges++;
					refChanges++;						//this movement has 3 reference changes
					refChanges++;
				}
				
				
				return;
			}
			previous2 = previous;		//if the spot is not found move our temporary variables to the next word over
			previous = location;
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
