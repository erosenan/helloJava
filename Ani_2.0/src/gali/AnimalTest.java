package gali;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void testSuccessfulGuess() {
		IUser user = new MockUser(new Object[] {"Is it a Dog?", true, "I win!!"});
		Answer animal = new Animal("Dog");
		animal.play(user);
	}

}
