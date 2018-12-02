package dataStructures;

import java.io.Serializable;

public interface DSListInterface<T> extends Serializable {
	int size();
	// return the number of elements on the list.
	
	void add(T element);
	// Adds an element to the list.
	
	boolean contains (T element);
	// Return true if the list contains an element e such that e.equals(element);
	// Otherwise, return false.
	
	boolean remove (T element);
	// Remove an element e from the list such that e.equals (element) and returns true;
	// If no such element exists, return false.
	
	T get(T element);
	// Returns an element e from this list such that e.equals(element);
	// If no such element exists, return null.
	
	String toString();
	// Returns a string representation of the list. 
	
	void reset();
	// Initializes current position to the first element of the list.
	
	T getNext();
	// Preconditions: The list is not empty, is reset, and not modified since the most recent reset
	//
	// Returns the element after the current position on the list.
	// If the current position is on the last element,
	// then it advances the current position to the first element
	// Otherwise, the current position advances to the next element.
}