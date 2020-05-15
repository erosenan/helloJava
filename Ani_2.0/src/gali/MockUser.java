package gali;

import static org.junit.Assert.*;

public class MockUser implements IUser {

	private Object[] interactions;
	private int index;

	public MockUser(Object[] interactions) {
		this.interactions = interactions;
		index = 0;
	}

	@Override
	public boolean askb(String question) {
		assertEquals(interactions[index], question);
		index += 2;
		return (boolean) interactions[index - 1];
	}

	@Override
	public void print(String string) {
		assertEquals(interactions[index], string);
	}

}
