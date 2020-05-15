package helloworld;
import java.util.Scanner;

public class Ellipse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = 0, z = 0;
		double y;
		
		while(z < 0.5 || z > 100){
			System.out.println("Enter the ellipse height:");
			z = scan.nextInt() / 2;
		}
		
		while(x < 0.5 || x > z){
			System.out.println("Enter the ellipse width:");
			x = scan.nextInt() / 2;
		}
		y = Math.sqrt(z * z - x * x);
		int[] structure = new int[z];
		
		for(int i = 0; i < z; i ++){
			for(int j = 0; j < z; j ++){
				if(check(x - j, y, z, i)){
					structure[i] = j;
					break;
				}
			}
		}
		print(structure, x);
	}
	private static void print(int[] structure, int x) {
		for (int i = 1; i < structure.length; i ++){
			for(int j = structure[i]; j > 0; j --){
				System.out.print("  ");
			}
			for(int j = (x - structure[i]) * 2; j > 0; j --){
				System.out.print("()");
			}
			System.out.println();
		}
		for (int i = structure.length - 1; i > 0; i --){
			for(int j = structure[i]; j > 0; j --){
				System.out.print("  ");
			}
			for(int j = (x - structure[i]) * 2; j > 0; j --){
				System.out.print("()");
			}
			System.out.println();
		}
	}
	private static boolean check(int currentX, double y, int z, int currentY) {
		return Math.sqrt(currentX * currentX + (z - y - currentY) * (z - y - currentY)) + Math.sqrt(currentX * currentX + (z + y - currentY) * (z + y - currentY)) < z * 2;
	}
}
