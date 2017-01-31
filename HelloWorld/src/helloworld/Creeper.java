package helloworld;

public class Creeper extends Mob {
	private int hitCount = 0;
	@Override
	public void hit() {
		if(hitCount == 0){
			System.out.println("tssssssssss...");
		} else if(hitCount == 1){
			System.out.println("ka Boom!!!");
		} else {
			System.out.println("I have already done it");
		}
		hitCount += 1;
	}

}