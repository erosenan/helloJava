package gali;

import java.util.Scanner;

public class Question extends Answer {

	private String question;
	private Answer ifYes;
	private Answer ifNo;

	public Question(String question, Answer ifYes, Answer ifNo) {
		this.question = question;
		this.ifYes = ifYes;
		this.ifNo = ifNo;
	}

	@Override
	public void play() {
		Scanner sc = new Scanner(System.in);
		System.out.println(question);
		
		String answer = sc.next();
		if (answer.equals("yes")) {
			ifYes.play();
		} else if (answer.equals("no")) {
			ifNo.play();
		} else {
			System.out.println("poop");
		}
	}

}
