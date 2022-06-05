
/*
 * 
 * EECS 2500 Project 3 - Lists Exploration
 * 
 * Author: Ethan Keegan
 * Date: 12/12/2021
 * Class EECS 2500
 * 
 * Note from Author: 11/6/2021
 * The main objective of this project is to gain exposure to many different types of Linked
 * Lists. With the following code, I display my understanding of these lists. The function
 * of this program is to take many test files and compare the lists' sorting efficiency.
 * The classes contained in this project include: MainClass (this one), BaseList, 
 * ListInterface, and LLNode. You can also find List1, List2, List3, and List4; with more to
 * come in the future. Many further descriptions for these lists and other classes can be 
 * found throughout the code.
 * 
 * APPEND #1: 11/23/2021
 * Project 3 is an extension of Project 2. There are many revisited elements. The objective
 * stays the same but the material has a twist. In this project I added the Modified Sorted
 * and Skip Lists. The classes that complement these are List 2a and List 5, respectively. I 
 * also included the SkipListNode for functionality purposes for the Skip List. There are 
 * also several modifications to other classes including MainClass, but not too big of 
 * changes. These classes are described more in detail throughout.
 * 
 * APPEND #2: 12/12/2021
 * Project 4 is and extension of Projects 2 and 3. This project is very similar to the last 
 * ones and the expectations have not changed. I added 2 new structures throughout 5 new
 * classes. These structures are Hashes and Binary Search Tree. The classes for these are 
 * Hash1, Hash2, Hash3, BST, and BSTNode. Once again, there were very minor modifications
 * to MainClass. More details about these classes can be found within the code.
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainClass
{

	
	public static void main(String args[]) throws IOException
	{
		//the following block is made to be able to chose a file to test from a remote program or manually
		//based off of the users preference.
		String fileName;
		if(args.length > 0)
		{
			fileName = args[0];
		}
		else
			fileName = "War and Peace.txt"; 	//change this for file testing
		
		
		
		//first run
		//this is to have in memory
		Scanner scanner = new Scanner(new File(fileName));
		while(scanner.hasNextLine())
		{
			scanner.nextLine();
		} scanner.close();
		
		
		
		//second run
		//this is the 'overhead' time
		scanner = new Scanner(new File(fileName));
		double start = System.currentTimeMillis();		//start timer
		while(scanner.hasNextLine())
		{
			
			//first need to trim (by line)
			//make sure word length is longer than 0
			
			String s = scanner.nextLine();
			
			String[] words = s.split(" ");
			for(int i = 0; i < words.length; i++)
			{
				if(words[i].length() > 0)
				{
					words[i] = words[i].toLowerCase();
				}
				else
					break;
			}		
		}
		double elapsed = System.currentTimeMillis();	//end timer
		double overheadTime = elapsed - start;			//if needed, this is the runtime without any lists
		scanner.close();
		
		
		//Lines 85-96 are given by Dr. Thomas in the project handout
		ListInterface[] Lists = new ListInterface[10]; // By creating the lists as
		 											  // an array, we can iterate
													  // with a subscript
		Lists[0] = new List1(); // Unsorted, insertions at beginning, no self-optimization
		Lists[1] = new List2(); // Sorted linked list
		Lists[2] = new List3(); // Unsorted, heavy-handed self-adjusting (moves repeated
		 						//word to the front of the list)
		Lists[3] = new List4(); // Unsorted, conservative self-adjusting (moves repeated
		 						//word one position towards front of list)
		
		//these lists are added for Project 3
				Lists[4] = new List2a();
				Lists[5] = new List5();
				
				//these lists are added for Project 4
				Lists[6] = new Hash1();
				Lists[7] = new Hash2();
				Lists[8] = new Hash3();
				Lists[9] = new BST();
								
		String[] ListNames = {"Unsorted", "Sorted", "Self-Adj (Front)", "Self-Adj (By One)", 	//project 2
							  "Modified Sorted", "Skip List", 									//project 3
							  "Hash 1", "Hash 2", "Hash 3", "Binary Tree"};						//project 4
		
		
		//this array holds the time taken by all the lists
		double[] ListTime = new double[10];
		
		
		//this for loop iterates through all of the runs for the lists
		for(int i = 5; i < 6; i++)
		{
			scanner = new Scanner(new File(fileName));	//open scanner for current list
			
			start = System.currentTimeMillis();			//start timer
		
				while(scanner.hasNext())					//while the .txt file has another word
				{
					String word = scanner.next();			//take that word
					word = word.toLowerCase();				//make it lowercase
					word = removeUnwantedCharacters(word);	//and remove the unwanted characters
					
					if(word.length() > 0)					//as long as that word isn't ""
					{
						Lists[i].add(word);					//add that word to its respective list
					}
					
				}						
			
			elapsed = System.currentTimeMillis();		//end timer
			ListTime[i] = (elapsed - start) / 1000;		//gives total time in seconds for the respective lists
			scanner.close(); 							//close scanner before next list
		} 
		
	
	
		
		//this is the formated table for all of the outputs of time, words, etc. from the lists
		System.out.printf("%2s %-17s %8s %11s %12s %10s %12s %4s\n", "#", "    List Name", "Run Time", "Vocabulary", "Total Words", "Key Comp", "Ref Chgs", "h");
		System.out.printf("%2s %-17s %8s %11s %12s %12s %12s %3s\n", "--", "-----------------", "--------", "----------", "-----------", "------------", "------------", "---");
		
		//each print statement must be written out individually so we can reorder them and add special metrics
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", 1, ListNames[0], ListTime[0], Lists[0].getDistinctWords(), Lists[0].getTotalWords(), Lists[0].getKeyCompare(), Lists[0].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", 2, ListNames[1], ListTime[1], Lists[1].getDistinctWords(), Lists[1].getTotalWords(), Lists[1].getKeyCompare(), Lists[1].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", "2a", ListNames[4], ListTime[4], Lists[4].getDistinctWords(), Lists[4].getTotalWords(), Lists[4].getKeyCompare(), Lists[4].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", 3, ListNames[2], ListTime[2], Lists[2].getDistinctWords(), Lists[2].getTotalWords(), Lists[2].getKeyCompare(), Lists[2].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", 4, ListNames[3], ListTime[3], Lists[3].getDistinctWords(), Lists[3].getTotalWords(), Lists[3].getKeyCompare(), Lists[3].getRefChanges()); 
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d %3d\n", 5, ListNames[5], ListTime[5], Lists[5].getDistinctWords(), Lists[5].getTotalWords(), Lists[5].getKeyCompare(), Lists[5].getRefChanges(), Lists[5].getHeight());

		//project 4 prints
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", "H1", ListNames[6], ListTime[6], Lists[6].getDistinctWords(), Lists[6].getTotalWords(), Lists[6].getKeyCompare(), Lists[6].getRefChanges()); 
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", "H2", ListNames[7], ListTime[7], Lists[7].getDistinctWords(), Lists[7].getTotalWords(), Lists[7].getKeyCompare(), Lists[7].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d\n", "H3", ListNames[8], ListTime[8], Lists[8].getDistinctWords(), Lists[8].getTotalWords(), Lists[8].getKeyCompare(), Lists[8].getRefChanges());
		System.out.printf("%2s %-17s %8.3f %10d %11d %13d %12d %3d\n", "BT", ListNames[9], ListTime[9], Lists[9].getDistinctWords(), Lists[9].getTotalWords(), Lists[9].getKeyCompare(), Lists[9].getRefChanges(), Lists[9].getHeight());
	}//end main
	
	
	//this method is important for trimming the words the scanner pulls from the .txt files	
	//what this does is takes the leading and trailing characters of the word and removes them
	static String removeUnwantedCharacters(String s)
	{

		String punc = "!@#$%^&*()_+-=[]\\{}|;':\"`~,./<>?";		//these are the characters we want to get rid of
		
		//removing front letters
		while(punc.indexOf(s.charAt(0)) != -1)
		{
			s = s.substring(1);
			if(s.length() == 0)	//if the word has a length of 0
				return "";		//return an empty string ("")
		}
		
		//removing back letters
		while(punc.indexOf(s.charAt(s.length() - 1)) != -1)
		{
			s = s.substring(0, s.length() -1);
			if(s.length() == 0)	//if the word has a length of 0
				return "";		//return an empty string("")
		}
		return s;	//return cleaned up word
	}
	

}
