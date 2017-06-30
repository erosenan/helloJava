package gali;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Answer implements Serializable {

	public abstract Answer play();
	
	public static boolean askb(String qta) {
		
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
	
	public static String asko(String qta) {
			
		Scanner sc = new Scanner(System.in);
	
		System.out.println(qta);
		String ans = sc.nextLine();
		
		return ans;
	}
		
}
