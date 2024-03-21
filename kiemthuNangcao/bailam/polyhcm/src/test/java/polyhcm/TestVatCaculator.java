package polyhcm;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVatCaculator {
	@Test
	public void testGetVatCaculator() {
		VatCaculator calc = new VatCaculator();
		double expected = 10;
		Assert.assertEquals(calc.getVatOnAmount(100), expected);
		Assert.assertEquals(calc.getVatOnAmount(120), expected);
	}
}
