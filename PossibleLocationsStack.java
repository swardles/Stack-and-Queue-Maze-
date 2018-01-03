package project3;

/**
 * Represents a singly linked list stack implementation
 * for a set of spaces used for the 
 * search for the way out of a maze algorithm.
 * 
 * @author Sarah Wardles
 *
 */

public class PossibleLocationsStack implements PossibleLocations {
	//use a singly linked list to implement a stack
		private Node<Location> top = null;
		private int size = 0;
		
		private static class Node<Location> {
			private Location element;
			private Node<Location> next;
			
			public Node(Location e, Node<Location> n) {
				element = e;
				next = n;
			}
			//access data at node
			public Location getElement() {
				return element;
			}
			public Node<Location> getNext() {
				return next;
			}
		}
		
			/**
			 * Add a SquarePosition object to the top of the stack.
			 * @param s
			 *    Object to be added
			 * @exception NullPointerException if trying to add a 
			 *    null element to the stack.
			 *    
			 */
			public void add ( Location s ) {
				//only ever adding to front/head
			
				if (s == null) {
					throw new NullPointerException("ERROR: NullPointerException.");
				}
				
				Node<Location> newNode = new Node<Location> (s, null);
				
				//if empty stack
				if (this.top == null) {
					newNode.next = null;
					top = newNode;
					size ++;
				}
				
				//if one element/full stack
				else if (top != null) { 
					newNode.next = top;
					top = newNode;
					size ++;	
				}
			}
			
			/**
			 * Remove the top object from the stack.
			 * @return
			 *    The top object, or null if stack is empty
			 * 
			 */
			public Location remove () {
				//if empty stack
				if (top == null) {
					return null;
				}
				
				//if one element in stack
				if (top.next == null) {
					Node<Location> temp = top;
					top = null;
					size --;
					return temp.getElement();
				}
				
				//if full stack
				if (top.next != null) {
					Node<Location> temp = top;
					top = top.getNext();
					size --;
					return temp.getElement();
				}
				return null;
			}
			
			/**
			 * Determines if set is empty or not.
			 * @return
			 *    true, if set is empty,
			 *    false, otherwise.
			 */
			public boolean isEmpty() {
				if (top == null) {
					return true;
				}
				return false;
			}
			/**
			 * Returns the top of the stack.
			 * @return
			 *    top of stack.
			 */
			public Location getFirst() {
				return top.getElement();
			}
			/**
			 * Returns the size of the stack.
			 * @return
			 *    size of stack.
			 */
			public int getSize() {
				return size;
			}	
		}