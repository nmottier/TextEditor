/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		try {
			shortList.add(null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}

		assertEquals("Check last", "B", shortList.get(shortList.size()-1));
		
		shortList.add("A");
		assertEquals("Check last", "A", shortList.get(shortList.size()-1));
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		
		assertEquals("Size: check size is correct", 10, longerList.size());
		
		longerList.add(5);
		longerList.add(5);
		longerList.add(5);
		longerList.add(5);
		longerList.add(5);

		
		assertEquals("Size: check size is correct", 15, longerList.size());

		longerList.remove(0);
		longerList.remove(0);
		longerList.remove(0);
		longerList.remove(0);
		
		assertEquals("Size: check size is correct", 11, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		try {
			shortList.add(-1,"A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.add(10,"Z");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		shortList.add(0,"Z");
		shortList.add(0,"Y");
		shortList.add(2,"X");
		
		
		assertEquals("Check first", "Z", shortList.get(0));
		assertEquals("Check second", "Y", shortList.get(1));
		assertEquals("Check third", "X", shortList.get(2));
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		
		try {
			shortList.set(-1,"A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.set(10,"Z");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}

		
		shortList.add("A");
		shortList.add("C");
		shortList.add("E");
		shortList.add("G");
		shortList.add("I");
		shortList.add("K");
		
		shortList.set(0,"B");
		shortList.set(4,"D");
		shortList.set(2,"F");
		
		assertEquals("Check first", "B", shortList.get(0));
		assertEquals("Check fifth", "D", shortList.get(4));
		assertEquals("Check third", "F", shortList.get(2));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
