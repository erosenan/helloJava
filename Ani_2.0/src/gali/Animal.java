package gali;

public class Animal extends Answer {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		System.out.println(name);
	}

}
