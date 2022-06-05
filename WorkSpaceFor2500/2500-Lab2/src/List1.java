
/*
 * List 1 refers to the unsorted list type. This extends from the BaseList class and 
 * implements ListInerface abstract class. Essentially, it looks through the list
 * in hopes to find the same word as the current word in the text. If not, it is going
 * to add that current word to the beginning of the list.
 */


public class List1 extends BaseList implements ListInterface
{
	
	//this pulls from parent classes
	public List1()
	{
		super();
	}
	
	//this is the special part of the list. It takes this path to add a word to the list when specified.
	@Override
	public void add(String word)
	{
		
		LLNode top = list;
		LLNode newNode = new LLNode(word, 1);
		
		//this is for the first word added because the first only makes one reference change
		if(top == null)		//if the location is empty
		{
			list = newNode;
			refChanges++;
			return;
		}
		
		
		while(top != null)						//while we are not at the bottom of the list
		{
			keyCompare++;						//we compare to a another word
			if(word.compareTo(top.word) == 0)	//when we find the matching word
			{
				int z = top.getCount();			//increase that words count by 1
				z++;
				top.setCount(z);
				return;
			}
			top = top.getNext();				//if we don't find the matching word, we move to the next word
		}
		
		
		//this is if there is no matching words (puts it in front)
		//there are two reference changes made to add a new word
		newNode.setNext(list);	
		list = newNode;
		refChanges++;			
		refChanges++;
		return;
	}
}
