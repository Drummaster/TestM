import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DEQueueTest {

	DEQueue queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new DEQueue();
	}
	
	@Test
	public void zeroSizeTest() {
		assertEquals(0, queue.size());
	}
	
	@Test
	public void pushBackTest() {
		queue.pushBack("greetings");
		assertEquals(1, queue.size());
	}
	
	@Test
	public void backTest() {
		queue.pushBack("greetings");
		assertEquals("greetings", queue.back());
		assertEquals(1, queue.size());
	}
	
	@Test
	public void popFrontTest() {
		queue.pushBack("greetings");
		queue.pushBack("gens");
		assertEquals("greetings", queue.popFront());
		assertEquals(1, queue.size());
		assertEquals("gens", queue.front());
	}
	
	@Test
	public void popBackTest() {
		queue.pushBack("greetings");
		queue.pushBack("gens");
		assertEquals("gens", queue.popBack());
		assertEquals(1, queue.size());
		assertEquals("greetings", queue.back());
	}
	
	@Test
	public void clearTest() {
		queue.pushBack("greetings");
		queue.pushBack("gens");
		queue.clear();
		assertEquals(0, queue.size());
	}	
	
	@Test
	public void toArrayTest() {
		String[] test2 = {"greetings", "ladies"};
		
		queue.pushBack("greetings");
		queue.pushBack("ladies");

		assertArrayEquals(test2, queue.toArray());
	}

}
