/*
 * Hash 3 is the hash that most resembles the hash function in java. Although, this only stores 
 * 8-bits where java does 32. Hash 3 is dependent on the order of the letters of the word where 
 * Hash 1 is not, setting the two apart. The resulting value of the order of the words is its 
 * location in the array. Each location contains a Linked list sorted by the Heavy Handed Sorting
 * method (List 3).
 */

public class Hash3 extends BaseList implements ListInterface
{
	List3[] a3 = new List3[256];		//make an array of 256 List 3's
	
	public Hash3()
	{
		super();
		for(int i = 0; i < 256; i++)	//initialize each list
		{
			a3[i] = new List3();
		}
	}
	
	@Override
	public void add(String word)
	{
		int n = stringToHash(word);		//hash the word
		a3[n].add(word);				//then add it to the spot in the array using List 3
	}
	
	//this is the third hashing method
	int stringToHash(String s)
	{
		int hash = 0;
		for(int i = 0; i < s.length(); i++)		//for every letter of the word,
			hash = (hash * 31) + s.charAt(i);	//add its value correlating to is position in the word
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
			refChanges += a3[i].getRefChanges();
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
			keyCompare += a3[i].getKeyCompare();
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
			LLNode p = a3[i].list; //
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
			LLNode p = a3[i].list;
			while (p != null)
			{
				count += p.getCount();
				p = p.getNext();
			}
		}
		return count;
	}
	
}