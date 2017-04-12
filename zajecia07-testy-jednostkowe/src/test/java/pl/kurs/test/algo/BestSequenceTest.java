package pl.kurs.test.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BestSequenceTest {

	private BestSequence bestSequence;

	@Before
	public void init() {
		bestSequence = new BestSequence();
	}

	@Test
	public void shouldFindCorrectSequence_1() {
		//given
		int[] array = { 1, 2, 3, 1, 2, 3, 4, 1, 2 };
		//when
		int[] result = bestSequence.bestSequence(array);
		//then
		int[] expected = { 1, 2, 3, 4 };
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], result[i]);
		}
	}

	@Test
	@Ignore(value = "Fix is needed!")
	public void shouldFindCorrectSequence_2() {
		//given
		int[] array = { 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7 };
		//when
		int[] result = bestSequence.bestSequence(array);
		//then
		int[] expected = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], result[i]);
		}
	}

	@Test
	public void shouldFindCorrectSequence_3() {
		//given
		int[] array = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 1, 2, 3, 4 };
		//when
		int[] result = bestSequence.bestSequence(array);
		//then
		int[] expected = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], result[i]);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenArrayIsNull() {
		//given
		int[] array = null;
		//when
		bestSequence.bestSequence(array);
		//then - exception thrown
	}

}
