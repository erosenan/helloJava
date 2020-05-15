package helloworld;

import java.util.Scanner;

public class Op {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = "Hello " + ask(scan, "What is your name?");
		a = a + ", how are you in this " + ask(scan, "What is the weather?");
		a = a + " day? maybe we can go to the closest " + ask(scan, "Where do you like to eat?");
		a = a + " here in " + ask(scan, "Where are you now?");
		a = a + ", eat some " + ask(scan, "What do you like to eat?");
		a = a + ", and drink a bottle of " + ask(scan, "What do you like to drink?");
		a = a + ". anyway, talk to me later on your " + ask(scan, "What device do you use to contact people?");
		a = a + ", have a nice day!";
		System.out.println(a);
	}
	private static String ask(Scanner scan, String a) {
		System.out.println(a);
		return scan.next();
	}
}
