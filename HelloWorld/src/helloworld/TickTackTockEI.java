package helloworld;

import java.util.Scanner;

public class TickTackTockEI {

	public static void main(String[] args) {
		int scanned;
		char[] board = new char[] {'-', '-', '-', '-', '-', '-', '-', '-', '-'}, testBoard = new char[9];
		Scanner scan = new Scanner(System.in);
		
		BoardPrint(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'});
		
		for(int turnsCount = 0; turnsCount < 9; turnsCount ++){
			System.out.println("Enter your move:");
			scanned = scan.nextInt() - 1;
			while(scanned < 0 || scanned > 8 || board[scanned] != '-'){
				System.out.println("please enter a valid move:");
				scanned = scan.nextInt() - 1;
			}
			
			board[scanned] = 'x';
			testBoard[scanned] = 'x';
			
			if(check(scanned, board)){
				System.out.println("You win!!!");
				BoardPrint(board);
				break;
			}
			for(int i = 0; i < 9; i ++){
				if(board[i] == '-'){
					testBoard = board;
					testBoard[i] = 'o';
					if(check(i, testBoard)){
						board[i] = 'o';
						System.out.println("1");
						break;
						
					}else if(i == 8){
						for (int j = 0; j < 8; j ++){
							if (board[j] != '-'){
								board[j] = 'o';
								break;
							}
						}
						testBoard[i] = '-';
						System.out.println("2");
					}else{
						testBoard[i] = '-';
						System.out.println("3");
					}
				}
			}
			BoardPrint(board);
		}
		System.out.println("Game over");
	}

	private static boolean check(int scanned, char[] board) {
		if (board[scanned % 3] != '-' && board[scanned % 3] == board[3 + scanned % 3] && board[3 + scanned % 3] == board[6 + scanned % 3])
			return true;
		else if (board[3 * (scanned / 3)] != '-' && board[3 * (scanned / 3)] == board[1 + 3 * (scanned / 3)] && board[1 + 3 * (scanned / 3)] == board[2 + 3 * (scanned / 3)])
			return true;
		else if (board[4] != '-' && scanned % 4 == 0 && board[scanned] == board[0] && board[scanned] == board[4] && board[scanned] == board[8])
			return true;
		else if (board[4] != '-' && scanned % 2 == 0 && scanned > 0 && scanned < 8 &&  board[scanned] == board[2] && board[scanned] == board[4] && board[scanned] == board[6])
			return true;
		else
			return false;
	}

	private static void BoardPrint(char[] c) {
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++)
				System.out.print("[" + c[i * 3 + j] + "]");
			System.out.println();
		}
	}
}
