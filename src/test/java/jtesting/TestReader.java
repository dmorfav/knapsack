package jtesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kp_hs.Reader;
import model.Item;

class TestReader {

	@BeforeEach
	void setUp() throws Exception {
		Reader reader = new Reader();
	}

	@Test
	void testWriteInstance() {
		String instanceName = "instance.json";
		int instanceLength= 10;
		assertTrue(Reader.createRandomInstance(instanceName, instanceLength, 1, 100));
		try { 
			ArrayList<Item> list = Reader.readKPInstance("src//main//resources//instances//"+instanceLength+"_"+instanceName);
			assertEquals(10, list.size()); }
		catch (IOException e) { 
			assertEquals("err",e.getMessage());
		}

	}


	@Test
	void testReadInstance() {
		try {
			ArrayList<Item> list = Reader.readKPInstance("src//main//resources//test_instance.json");
			assertEquals(9, list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
			fail("Not working");
		}
	}
}
