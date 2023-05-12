package my_FirstGAME_TicTacToe;
import java.util.*;
public class tic_tac_toe {

	private players player1,player2;
	private Board board;
	private int numBoards;

	public static void main(String[] args) {
		tic_tac_toe ttt=new tic_tac_toe();
		ttt.startGame();

	}
	

	public void startGame() {
		Scanner sc=new Scanner(System.in);
		// take players input
		player1=takeInput(++numBoards);
		player2=takeInput(++numBoards);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol Already Taken !! Please Enter Differt Symbol ");
			player2.setSymbol(sc.next().charAt(0));

		}
		
		while(player1.getName()==player2.getName()) {
			System.out.println("Name Already Taken !! Please Enter Differt Name ");
			player2.setName(sc.nextLine());

		}
		
		// Create the board
		board=new Board(player1.getSymbol(), player2.getSymbol());


		// start the game
		boolean player1turn=true;
		int status=board.INCOMPLETE;
		while(status==board.INCOMPLETE || status==board.INVALIDMOVE) {
			if(player1turn) {
				System.out.println("Player1 :"+ player1.getName()+"s turn");
				System.out.println("Enter X :");
				int x=sc.nextInt();
				System.out.println("Enter y :");
				int y=sc.nextInt();

				status=board.move(player1.getSymbol(),x,y);
				if(status==board.INVALIDMOVE) {
					System.out.println("Enterd move is INVALID!!!  Please Enter valid move");
					continue;
				} 
			}
			else {
				System.out.println("Player2 :"+ player2.getName()+"s turn");
				System.out.println("Enter X :");
				int x=sc.nextInt();
				System.out.println("Enter y :");
				int y=sc.nextInt();

				status=board.move(player2.getSymbol(),x,y);
				if(status==board.INVALIDMOVE) {
					System.out.println("Enterd move is INVALID!!!  Please Enter valid move");
					continue;
				} 

			}
			player1turn=!player1turn;
			board.print();
		}
		
		if(status==board.PLAYER1WIN) {
			System.out.println("HURRAY...........");
			System.out.println("Player 1: "+player1.getName()+" Wins!!");
		}else if(status==board.PLAYER2WIN) {
			System.out.println("HURRAY...........");
			System.out.println("Player 2: "+player2.getName()+" Wins!!");
		}else {
			System.out.println("Well played champs ");
			System.out.println("Match has been DRAW");
		}

	}
	private players takeInput(int num) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the player "+ num+ " Name: ");
		String name=sc.nextLine();
		System.out.println("Enter the player "+num+" Symbol: ");
		char symbol=sc.next().charAt(0);
		players p=new players(name, symbol);
		return p;

	}

}
