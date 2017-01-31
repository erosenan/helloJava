package helloworld;

public abstract class Mob {
	public abstract void hit();

	public void hitTwice() {
		hit();
		hit();
	}
	public void hitTimes(int times) {
		for(int i = 0; i < times; i++) {
			hit();
		}
	}
}
