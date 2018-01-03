package project3;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.AssertionFailedError;

public class PossibleLocationsStackTest {
	//tests for linked list implementation of stack
	
	private Location nullElement = null;
	private Location Loc1 = new Location(1,2);
	private Location Loc2 = new Location(2,3);
	private Location Loc3 = new Location(3,4);
		
	//ADD
	//-----------------------------------
	//testing that a NullPointerException is thrown when adding a null element to stack
	@Test
	public void testingNullAdd(){
		try {
		    PossibleLocationsStack test = new PossibleLocationsStack();
		    test.add(nullElement);
		    }
		
		catch (NullPointerException e) {
		}
		
		catch (Exception e) {
			fail("Failed: Unexpected Exception.");
		}
		
	}
	//-----------------------------------
	//testing that an element is correctly added to an empty stack
	@Test
	public void testingAddingToEmptyStack(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			test.add(Loc1);
			assertEquals(Loc1, test.getFirst());
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-----------------------------------
	//testing that an element is correctly added to a non empty stack
	@Test
	public void testingAddingToNonEmptyStack(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			test.add(Loc1);
			test.add(Loc2);
			
			test.add(Loc3);
			assertEquals(Loc3, test.getFirst());
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------------
	//testing that the size is correctly updating when adding to the stack
	@Test
	public void testingIfSizeIsRightStack(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			
			assertEquals(3, test.getSize());
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	
	//REMOVE
	//-------------------------------------
	//testing that null is returned when trying to remove from an empty stack
	@Test
	public void testingRemoveFromEmptyStack(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			Location result = test.remove();
			assertEquals(null, result);
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//-------------------------------------
	//testing that an element is correctly removed from a non empty stack
	@Test
	public void testingRemoveFromNonEmptyStack(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			test.add(Loc1);
			test.add(Loc2);
			test.add(Loc3);
			
			test.remove();
			assertEquals(Loc2, test.getFirst());
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	//------------------------------------
	//testing that an element is correctly removed from a stack with one element
	@Test
	public void testingRemovingFromStackWithOneElement(){
		try {
			PossibleLocationsStack test = new PossibleLocationsStack();
			test.add(Loc1);
			
			assertEquals(Loc1, test.remove());
		}
		catch (AssertionFailedError e){
		}
		catch(Exception e) {
			fail("Failed: Unexpected Exception.");
		}
	}
	
	//ISEMPTY
	//-------------------------------------
	//testing that the isEmpty() method returns true when called on an empty stack
	@Test
	public void testingIsEmpty() {
		PossibleLocationsStack test = new PossibleLocationsStack();
		boolean result = test.isEmpty();
		assertEquals(true, result);
		
	}
    //--------------------------------------
	//testing that the isEmpty() method returns false when called on a non empty stack
	@Test
	public void testingIsEmptyForOneElementStack() {
		PossibleLocationsStack test = new PossibleLocationsStack();
		test.add(Loc1);
		boolean result = test.isEmpty();
		assertEquals(false, result);
		
	}
}
