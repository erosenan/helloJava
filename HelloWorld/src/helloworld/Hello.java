package helloworld;

public class Hello {
	public static void main(String[] args) {
		Mob yona = new Chicken();
		Mob blowy = new Creeper();
		System.out.println("do not blow my house creeper!");
		blowy.hitTimes(4);
		yona.hit();
	}

}
