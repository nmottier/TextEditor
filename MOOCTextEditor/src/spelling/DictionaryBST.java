package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict = new TreeSet<String>();
   	int size = 0;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	
    	boolean addWord = dict.add(word.toLowerCase());
    	if (addWord) size++;
    	
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return size;
    }
    
    private boolean searchForWord(String word) {
    	
    	boolean foundWord = false;
    	foundWord = dict.contains(word);
    	
    	return foundWord;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	
    	boolean word = searchForWord(s.toLowerCase());
        return word;
    }

}
