package helloworld;

import java.util.Scanner;

public class BaseConverter {

	public static void main(String[] args) {
		int inBase, outBase, stepCount = 1;
		String input, output = "";
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Enter a number:");
			input = scan.next();
		} while(check(input));
		do {
			System.out.println("Enter the base of this number:");
			inBase = scan.nextInt();
		} while(inBase < 1);
		do {
			System.out.println("Enter the base you want to convert to:");
			outBase = scan.nextInt();
		} while(outBase < 1 || outBase > 10);
		
		for (int i = input.length(); i > 0; i --)
			output = reWrite(output, input.charAt(input.length()), input.charAt(i) * pow(inBase, i), outBase);
		
		/*while (input > 0) {
			output = output + (input % 2) * stepCount;
			input = input / 2;
			stepCount = stepCount * 10;
		}*/
		System.out.print(output);
	}
	
	private static int pow(int x, int n) {
		if (n == 0)
			return 1;
		for (int i = 0; i < n; i ++)
			x = x * x;
		return x;
	}

	private static String reWrite(String output, char input, int add, int outBase) {
		for (int i = output.length(); i > 0; i --)
			if ((int)(output.charAt(i) - '0') + add / outBase >= outBase)
				output = "0" + output;
			output.charAt(i) =  
		
		return null;
	}
	
	private static boolean check(String a) {
		for (int i = 0; i < a.length(); i ++)
			if (a.charAt(i) < '0' ||a.charAt(i) > '9' )
				return true;
		return false;
	}
}
