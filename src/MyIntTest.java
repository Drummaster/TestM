import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyIntTest extends Assert {
	MyInt a, b, c, d, e, f, g, h, i, j, k, l;
	
	
	@Before
	public void setUp() throws Exception {
		a = new MyInt(100);
		b = new MyInt("-230");
		c = new MyInt(196);
		d = new MyInt(37);
		e = new MyInt(-50); f = new MyInt(150);
		g = new MyInt(100); h = new MyInt(-230);
		i = new MyInt(900); j = new MyInt(371);
		
		k = new MyInt(-100); l = new MyInt(-230);	
	}
	
	@Test
	public void addTest() {
		assertEquals("-130", a.add(b).toString());
		assertEquals("1271", i.add(j).toString());
	}
	
	@Test
	public void subtractTest() {
		assertEquals("159", c.subtract(d).toString());
		assertEquals("-200", e.subtract(f).toString());
		assertEquals("330", g.subtract(h).toString());
		assertEquals("130", k.subtract(l).toString());
		assertEquals("-130", l.subtract(k).toString());
	}
	
	@Test
	public void multiplyTest() {
		assertEquals("19600", a.multiply(c).toString());
		assertEquals("3700", a.multiply(d).toString());
		assertEquals("33300", d.multiply(i).toString());
		assertEquals("11500", e.multiply(h).toString());
		assertEquals("-7500", e.multiply(f).toString());
		assertEquals(0, d.multiply(new MyInt(0)).longValue());
	}

	@Test
	public void longValueTest() {
		assertEquals(-7500, e.multiply(f).longValue());
	}
	
	@Test
	public void gcdTest() {
		assertEquals("20", a.gcd(new MyInt(40)).toString());
	}
	
	@Test
	public void compareToTest() {
		assertEquals(-1, new MyInt(20).compareTo(new MyInt(40)));
		assertEquals(1, new MyInt(40).compareTo(new MyInt(20)));
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
