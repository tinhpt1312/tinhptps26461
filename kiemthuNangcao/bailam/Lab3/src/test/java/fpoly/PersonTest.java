package fpoly;

import static org.junit.Assert.fail;

import org.hamcrest.Matcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {

//	@Rule
//	public ExpectedException exception = ExpectedException.none();
	
//	@Test(expected = IllegalArgumentException.class)
	@Test
	public void testExpectedException() {
//		exception.expect(IllegalArgumentException.class);
		try {
			new Person("Fpoly", -1);
			fail("Should have thrown an IllegalArgumentException because age is invalid");
		}catch(IllegalArgumentException e) {
			
		}
//		new Person("Fpoly", -1);
	}
}
