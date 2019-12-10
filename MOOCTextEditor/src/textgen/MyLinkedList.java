package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {

		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	
	public boolean add(E element ) 
	{
		
		if (element == null) {
			throw new NullPointerException("Invalid input");
		}
		
		// TODO: Implement this method
		LLNode<E> addedNode = new LLNode<E>(element);
		LLNode<E> previous = tail.prev;
		previous.next = addedNode;
		addedNode.prev = previous;
		addedNode.next = tail;
		tail.prev = addedNode;
		size++;
		return true;
	}
	
	public void add(int x,E element ) {
		
		if (element == null) 
			throw new NullPointerException("Cannot be null!");
		
		LLNode<E> addedNode = new LLNode<E>(element);

		LLNode<E> newNode = head;
		for (int i = 0; i <= x; i++) {
			newNode = newNode.next;
		}
		
		LLNode<E> prev = newNode.prev;
		prev.next = addedNode;
		addedNode.prev = prev;
		addedNode.next = newNode;
		newNode.prev = addedNode;
		size++;
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {

		if (index < 0) {
			throw new IndexOutOfBoundsException("Cannot be negative!");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		}
		LLNode<E> theNode = head.next;
		while (index > 0) {
			theNode = theNode.next;
			index = index - 1;
		}

		return theNode.data;
		
	}
        

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */



	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if (index >= size) {
			throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Cannot be negative!");
		}
		LLNode<E> noNode = head.next;
		while (index > 0) {
			noNode = noNode.next;
			index = index - 1;
		}
		noNode.next.prev = noNode.prev;
		noNode.prev.next = noNode.next;
		size = size - 1;
		return noNode.data;
		
		//finally got it
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if (element == null) {
			throw new NullPointerException("Cannot be null!");
		}
		if (index >= size) {
			throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		}
		if (index < 0) 
			throw new IndexOutOfBoundsException("Cannot be negative!");
		
	LLNode<E> theNode = head;
	for (int i = 0; i <= index; i++) {
		theNode = theNode.next;
	}
	theNode.data = element;
	
	// TODO: Implement this method
	return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
