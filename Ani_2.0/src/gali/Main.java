package gali;

public class Main {

	public static void main(String[] args) {
		Answer tuna = new Animal("Tuna");
		Answer dog = new Animal("Dog");
		Answer dogOrTuna = new Question("Is this animal a mammal?",dog,tuna);
		dogOrTuna.play();
	}

}
