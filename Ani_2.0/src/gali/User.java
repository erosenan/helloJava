package gali;

import java.util.Scanner;

public class User implements IUser {

	@Override
	public boolean askb(String qta) {
		
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println(qta);
			String ans = sc.next();
		
			if (ans.equals("yes")) {
				return true;
			} else if (ans.equals("no")) {
				return false;
			} else {
				System.out.println("Excuse me, I didn't understand. please write 'yes' or 'no'.");
			}
		}
		

	}

	@Override
	public void print(String string) {
		System.out.println(string);
	}

}
