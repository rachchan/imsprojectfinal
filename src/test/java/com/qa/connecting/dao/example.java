package com.qa.connecting.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class example {
	
	@BeforeClass
	public static void init() {
		System.out.println("Before Class");
	}
	
	@Before
	public void setup() {
		System.out.println("before");
	}
	
	@After
	public void teardown() {
		System.out.println("after");
	}
	
	
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
