package bonnie;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void test(){
		int size = 6;
		Grid g = new Grid(size, size);
		int x, y = 0;
		while(y < size){
			x = 0;
			while(x < size){
				//System.out.println("Checking: " + x + ", " + y);
				assertNotNull(g.getValue(x, y));
				assertEquals(x, g.getValue(x, y).getX());
				assertEquals(y, g.getValue(x, y).getY());
				x ++;
			}
			y ++;
		}
	}
}
