/*
 * Hash 1 is the hash of taking all of the values of a word, adding them together and dividing 
 * the result by 256. The resulting value is its location in the array. Each location contains a 
 * Linked list sorted by the Heavy Handed Sorting method (List 3).
 */

public class Hash1 extends BaseList implements ListInterface
{
	List3[] a1 = new List3[256];		//make an array of 256 List 3's
	
	public Hash1()
	{
		super();
		for(int i = 0; i < 256; i++)	//initialize each list
		{
			a1[i] = new List3();
		}
	}
	
	@Override
	public void add(String word)
	{
		int n = stringToHash(word);		//hash the word
		a1[n].add(word);				//then add it to the spot in the array using List 3
	}
	
	//this is the first hashing method
	int stringToHash(String s)
	{
		int hash = 0;
		for (int i = 0; i < s.length(); i++)	//for every letter of the word,
			hash += s.charAt(i);				//add its value
		return hash & 255;						//and find its array location
	}

	
	
	//add a for loop to all of these to be able to find the values from each list in the array.
	//these getters are basically the same as the ones from list 3 but iterated 256 times.
	
	@Override
	public long getRefChanges()
	{
		//create a loop to count the refChanges in every list
		for(int i = 0; i < 256; i++)
		{
			refChanges += a1[i].getRefChanges();
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
			keyCompare += a1[i].getKeyCompare();
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
			LLNode p = a1[i].list; //
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
			LLNode p = a1[i].list;
			while (p != null)
			{
				count += p.getCount();
				p = p.getNext();
			}
		}
		return count;
	}
	
}
