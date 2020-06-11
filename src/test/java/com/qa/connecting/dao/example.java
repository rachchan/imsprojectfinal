package com.qa.connecting.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//makes sure data is inserted every time
public class example {
	//setting up testing database
	@BeforeClass
	public static void init() {
		System.out.println("Before Class");
	}
	//ran before every test
	@Before
	public void setup() {
		System.out.println("before");
	}
	
	//dummy test
	@After
	public void teardown() {
		System.out.println("after");
	}
	
	//close connection, drop all tables and databases, not taking up bandwidth
	@AfterClass
	public static void terminate() {
		System.out.println("after Class");
	}
	
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}

}
