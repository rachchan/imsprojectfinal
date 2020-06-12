package com.qa.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomersTest {
	
	private Customers customers;
	private Customers other;
	
	@Before
	public void setUp() {
		customers = new Customers(5, "Thomas", "Sally");
		other = new Customers(5, "Thomas", "Sally");
	}

	
	@Test
	public void equalsWithNull() {
		assertFalse(customers.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customers.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithCustomerID() {
		assertEquals(5, customers.getCustomerID(), 0);
		assertEquals("Thomas", customers.getLastName());
		assertEquals("Sally", customers.getFirstName());
		
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customers.equals(customers));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customers.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customers.setFirstName(null);
		assertFalse(customers.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setFirstName("rachel");
		assertFalse(customers.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customers.setFirstName(null);
		other.setFirstName(null);
		assertTrue(customers.equals(other));
	}
	
	@Test
	public void nullId() {
		customers.setCustomerID(null);
		assertFalse(customers.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customers.setCustomerID(null);
		other.setCustomerID(null);
		assertTrue(customers.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setCustomerID(100);
		assertFalse(customers.equals(other));
	}
	
	@Test
	public void nullLastName() {
		customers.setLastName(null);
		assertFalse(customers.equals(other));
	}
	
	@Test
	public void nullLastNameOnBoth() {
		customers.setLastName(null);
		other.setLastName(null);
		assertTrue(customers.equals(other));
	}
	
	@Test
	public void otherLastNameDifferent() {
		other.setLastName("reed");
		assertFalse(customers.equals(other));
	}
	

	
}
