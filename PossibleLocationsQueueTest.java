package project3;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.AssertionFailedError;

public class PossibleLocationsQueueTest {
	private Location Loc1 = new Location(1,2);
	private Location Loc2 = new Location(2,3);
	private Location Loc3 = new Location(3,4);
	private Location Loc4 = new Location(4,5);
	private Location Loc5 = new Location(6,7);
	private Location Loc6 = new Location(5,6);
	private Location Loc7 = new Location(7,8);
	private Location Loc8 = new Location(8,9);
	private Location Loc9 = new Location(9,10);
	private Location Loc10 = new Location(10,11);
	private Location Loc11 = new Location(11,12);
	private Location Loc12 = new Location(12,13);
	
    //ADD
	//--------------------
	//testing that a NullPointerException is thrown when a null element is added to queue
	@Test
	public void testingNullAdd(){
		try {
		    PossibleLocationsQueue test = new PossibleLocationsQueue();
		    test.add(null);
		    }
		
		catch (NullPointerException e) {
		}
		
		catch (Exception e) {
			fail("Failed: Unexpected Exception.");
		}
		
	}
	//----------------------------
	//testing that an element is correctly added to an empty queue
	@Test
	public void testingAddElementToEmptyQueue() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
            
            assertEquals(false, test.isEmpty());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------
	//testing that an element is correctly added to a non empty queue
	@Test
	public void testingAddToFilledQueue() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			test.add(Loc4);
			test.add(Loc5);
			test.add(Loc6);
			test.add(Loc7);
			test.add(Loc8);
			test.add(Loc9);
			test.add(Loc10);
			
            test.add(Loc11);
            
            assertEquals(0, test.getFront());
            assertEquals(test.getSize()-1, test.getBack());
            
            assertEquals(Loc1, test.array[0]);
            assertEquals(Loc11, test.array[test.getSize()-1]);
			
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}

	//--------------------
	//testing that front and back refer to the correct array indices
	@Test
	public void testingMakeSureFrontAndBackAreInRightPlaces() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			test.add(Loc4);
			test.add(Loc5);
			test.add(Loc6);
			test.add(Loc7);
			test.add(Loc8);
			test.add(Loc9);
			test.add(Loc10);
			
            test.remove();
            test.add(Loc11);
            
            assertEquals(1, test.getFront());
            assertEquals(0, test.getBack());
			
			
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}

	//--------------------------
	//testing to make sure that the front and back references and the correct objects are
	//stored in the right places when beginning with an array in which the front is not 
	//at index zero and the back is less than the front and then adding an additional
	//element to the array. This tests specifically to make sure that the array is growing
	//larger correctly and storing the previous arrays elements correctly
	@Test
	public void testingAddingWhenFrontNotZeroAndBackLessThanFront() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			test.add(Loc4);
			test.add(Loc5);
			test.add(Loc6);
			test.add(Loc7);
			test.add(Loc8);
			test.add(Loc9);
			test.add(Loc10);
			
            test.remove();
            test.add(Loc11);
            //achieved state
            
            test.add(Loc12);
            
            assertEquals(0, test.getFront());
            assertEquals(test.getSize()-1, test.getBack());
            
            assertEquals(Loc2, test.array[0]);
            assertEquals(Loc12, test.array[test.getSize()-1]);
			
			
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//--------------------------------
	//testing that the size is correctly updating when adding to the queue
	@Test
	public void testingCheckingIfSizeUpdates() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			
			assertEquals(3, test.getSize());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	
	//REMOVE
	//-------------------------------
	//testing that null is returned when trying to remove from an empty queue
	@Test
	public void testingRemovingFromEmptyQueue() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			Location result = test.remove();
            
            assertEquals(null, result);
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------
	//testing that an element is correctly removed from a full queue
	@Test
	public void testingRemovingFromFullQueue() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			test.add(Loc4);
			test.add(Loc5);
			test.add(Loc6);
			test.add(Loc7);
			test.add(Loc8);
			test.add(Loc9);
			test.add(Loc10);
			test.remove();
            //
            assertEquals(Loc2, test.array[test.getFront()]);
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------
	//testing that the size updates correctly when an element is removed from the queue
	@Test
	public void testingCheckingIfSizeUpdatesForRemove() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			test.remove();
			
			assertEquals(2, test.getSize());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------
	//testing that the queue becomes empty when removing from a queue with one element
	@Test
	public void testingRemovingFromOneElementList() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			test.remove();
			
			assertEquals(true, test.isEmpty());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------
	//testing that the queue is not empty after adding one element
	@Test
	public void testingAddingAndCheckingForEmpty() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			test.add(Loc1);
			
			assertEquals(false, test.isEmpty());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------
	//testing that an empty/not yet added to queue is empty
	@Test
	public void testingEmptyForNewQueue() {
		try {
			PossibleLocationsQueue test = new PossibleLocationsQueue();
			
			assertEquals(true, test.isEmpty());
		}
		catch(AssertionFailedError e) {
			
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
}
