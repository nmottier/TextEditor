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
	public boolean add(E element ) {
		
		if (element == null) throw new NullPointerException("Cannot be null!");
		
		LLNode<E> newNode = new LLNode<E>(element);

		newNode.prev = tail.prev;
		newNode.prev.next = newNode;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {

		if (index < 0) throw new IndexOutOfBoundsException("Cannot be negative!");
		if (index >= size) throw new IndexOutOfBoundsException("Cannot be greater than the list!");
        
		LLNode<E> newNode = find(index);
		return newNode.data;
		
		return null;
	}
        

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if (element == null) throw new NullPointerException("Cannot be null!");
		if (index > size) throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		if (index < 0) throw new IndexOutOfBoundsException("Cannot be negative!");
		
		if (index == size) add(element);
		else {
			LLNode<E> node = find(index);
			
			LLNode<E> node0 = new LLNode<E>(element);
			node0.prev = node.prev;
			node0.next = node;
			node.prev = node0;
			node0.prev.next = node0;
			
			size++;
		}
	}


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
		
		if (index >= size) throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		if (index < 0) throw new IndexOutOfBoundsException("Cannot be negative!");
		
		LLNode<E> newNode = find(index);
		E data = newNode.data;
		newNode.prev.next = newNode.next;
		newNode.next.prev = newNode.prev;
		size = size - 1;
		
		return data;
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
		
		if (element == null) throw new NullPointerException("Cannot be null!");
		if (index >= size) throw new IndexOutOfBoundsException("Cannot be greater than the list!");
		if (index < 0) throw new IndexOutOfBoundsException("Cannot be negative!");
		
		LLNode<E> newNode = find(index);
		newNode.data = element;
		return newNode.data;
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
