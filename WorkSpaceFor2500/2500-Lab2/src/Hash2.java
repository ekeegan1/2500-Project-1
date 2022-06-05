/*
 * Hash 2 is the hash where a word is placed in the array alphabetically based off of the first
 * letter only. After the location in found it is placed in to a Linked List sorted by the Heavy
 * Handed Sorting method (List 3)
 */


public class Hash2 extends BaseList implements ListInterface
{
	List3[] a2 = new List3[256];		//make an array of 256 List 3's
	
	public Hash2()
	{
		super();
		for(int i = 0; i < 256; i++)	//initialize each list
		{
			a2[i] = new List3();
		}
	}
	
	@Override
	public void add(String word)
	{
		int n = stringToHash(word);		//hash the word
		a2[n].add(word);				//then add it to the spot in the array using List 3
	}
	
	//this is the second hashing method
	int stringToHash(String s)
	{
		int hash = s.charAt(0);		//add the words first value
		return hash & 255;			//and find its array location
	}

	
	
	//add a for loop to all of these to be able to find the values from each list in the array.
	//these getters are basically the same as the ones from list 3 but iterated 256 times.
	
	@Override
	public long getRefChanges()
	{
		//create a loop to count the refChanges in every list
		for(int i = 0; i < 256; i++)
		{
			refChanges += a2[i].getRefChanges();
		}
		return refChanges;
	}

	@Override
	public long getKeyCompare()
	{
		// How many key comparisons (how much work was done looking for things on the
		// list)?
		//
		for(int i = 0; i < 256; i++)
		{
			keyCompare += a2[i].getKeyCompare();
		}
		return keyCompare;
	}

	@Override
	public int getDistinctWords()
	{
		// How many nodes are there on the list? Each corresponds to a unique word
		//
		int count = 0;
		for(int i = 0; i < 256; i++)
		{
			// Alternate coding:
			LLNode p = a2[i].list; //
			while (p != null) // for (LLNode p = list; p != null; p = p.getNext()) count++;
			{ // return count;
				count++; //
				p = p.getNext(); //
			} //
		}
		return count; //
	}

	@Override
	public int getTotalWords()
	{
		// How many TOTAL words? That's the sum of the counts in each node.
		//
		int count = 0;
		for(int i = 0; i < 256; i++)
		{
			LLNode p = a2[i].list;
			while (p != null)
			{
				count += p.getCount();
				p = p.getNext();
			}
		}
		return count;
	}
	
}