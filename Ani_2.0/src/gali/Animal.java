package gali;

public class Animal extends Answer {

	private String name;

	public Animal(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public Answer play(IUser user) {
		
		if (user.askb("Is it a " + name + "?")) {
			user.print("I win!!");
			return this;
		} else {
			Animal animal = new Animal(asko("What animal did you think about?"));
			String question = asko("Please write a distinguishing question between " + name + " and " + animal + " (Remember to put a capital letter at the beggining and a question mark):");
			boolean answer = askb("What would be the answer for " + animal + "?");
			System.out.println("Thanks, I will remember next time");
			if (answer) {
				return new Question(question, animal, this);
			} else {
				return new Question(question, this, animal);
			}
		}
	}
}
