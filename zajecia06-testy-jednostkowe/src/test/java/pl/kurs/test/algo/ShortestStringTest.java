package pl.kurs.test.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortestStringTest {

	private ShortestString shortestString;
	
	@Before
	public void init() {
		shortestString = new ShortestString();
	}
	
	@Test
	public void shortestStringTest_1() {
		//given
		String s1 = "abc";
		String s2 = "defe";
		
		//when
		String result = shortestString.findShortest(s1, s2);
		
		//then
		String expected = "abcdefe";
		Assert.assertEquals(result, expected);
	}
	
}
