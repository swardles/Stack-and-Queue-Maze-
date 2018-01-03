package project3;

/**
 * Represents an array queue implementation
 * for a set of spaces used for the 
 * search for the way out of a maze algorithm.
 * 
 * @author Sarah Wardles
 *
 */

public class PossibleLocationsQueue implements PossibleLocations{
		Location [] array;
		int capacity;
		int size;
		int front;
		int back = -1;
		
		/**
		 * Default constructor for queue implementation.
		 *    
		 */
		public PossibleLocationsQueue() {
			array = new Location[10];
			capacity = 10;
		}
		/**
		 * Constructor that takes in one parameter for a specified queue capacity
		 * @param initial_capacity
		 *    Specifying the capacity of the queue.
		  
		 */
		public PossibleLocationsQueue(int initial_capacity ) {
			if (initial_capacity < 0) {
				capacity = 10;
				array = new Location[capacity];
			}
			else {
				capacity = initial_capacity;
			    array = new Location[capacity];
			}
		}
		
		
		/**
		 * Add a SquarePosition object to the back of the queue 
		 * and calls makeArrayLarger function if the size of the array
		 * reaches the capacity of the array. 
		 * @param s
		 *    Object to be added
		 * @exception NullPointerException if trying to add a 
		 *    null element to the queue.
		 *    
		 */
		public void add (Location s) {
			//check if the object trying to be added is null
			if (s == null) {
				throw new NullPointerException();
			}
			//check if there is room in the array
			if(size == capacity) {
				//make array bigger
				makeArrayLarger();
			}
			
			back = (back + 1) % capacity;
			array[back] = s;
			//back ++;
			size ++;
		}
		
		/**
		 * Makes the array larger.
		 */
		public void makeArrayLarger() {
			int newCapacity = (capacity + 1) * 2;
			Location [] newArray = new Location[newCapacity];
			for (int i = 0; i < size; i ++) {
				newArray[i] = array[(front + i) % capacity];
			}
			front = 0;
			back = size - 1;
			capacity = newCapacity;
			array = newArray;
		}
			
		/**
		 * Remove the top object from the queue.
		 * @return
		 *    The top object, or null if queue is empty
		 * 
		 */
		public Location remove() {
			if (isEmpty()) {
				return null;
			}
			Location temp = array[front];
			front = (front + 1) % capacity;
			size --;
			return temp;
		}
			
			/**
			 * Determines if set is empty or not.
			 * @return
			 *    true, if set is empty,
			 *    false, otherwise.
			 */
		public boolean isEmpty() {
			if (size == 0) {
				return true;
			}
			return false;
		}
		/**
		 * Returns the size of the queue.
		 * @return
		 *    size of queue.
		 */
		public int getSize() {
			return size;
		}
		/**
		 * Returns the top of the queue.
		 * @return
		 *    top of queue.
		 */
		public int getFront() {
			return front;
		}
		/**
		 * Returns the back of the queue.
		 * @return
		 *    back of the queue.
		 */
		public int getBack() {
			return back;
		}
	}