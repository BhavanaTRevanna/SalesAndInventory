package TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void hardAssert() {
		System.out.println("Step-1");
		System.out.println("Step-2");
		assertEquals("A", "B");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void hardAssert1() {
		System.out.println("Step-5");
		System.out.println("Step-6");
		assertNotSame("A", "B");
		System.out.println("Step-7");
		System.out.println("Step-8");
	}
	
	@Test
	public void hardAssert2() {
		int m=5;
		assertNotNull(m);
		System.out.println("Step-9");
		System.out.println("Step-10");
	}

}
