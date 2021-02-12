package assignment4Game;
//Name: Hanwen Wang   ID:260778557
import java.io.*;

public class Game {
	
	public static int play(InputStreamReader input){
		BufferedReader keyboard = new BufferedReader(input);
		Configuration c = new Configuration();
		int columnPlayed = 3; int player;
		
		// first move for player 1 (played by computer) : in the middle of the grid
		c.addDisk(firstMovePlayer1(), 1);
		int nbTurn = 1;
		
		while (nbTurn < 42){ // maximum of turns allowed by the size of the grid
			player = nbTurn %2 + 1;
			if (player == 2){
				columnPlayed = getNextMove(keyboard, c, 2);
			}
			if (player == 1){
				columnPlayed = movePlayer1(columnPlayed, c);
			}
			c.addDisk(columnPlayed, player);
			if (c.isWinning(columnPlayed, player)){
				c.print();
				System.out.println("Congrats to player " + player + " !");
				return(player);
			}
			nbTurn++;
		}
		return -1;
	}
	
	public static int getNextMove(BufferedReader keyboard, Configuration c, int player){
		try
		{
			System.out.print("Enter a column number:");
			InputStreamReader input1 = new InputStreamReader(System.in);
			keyboard=new BufferedReader(input1);
			int column=keyboard.read()-48;
			while(c.available[column]==6)
			{
				System.out.print("Enter a column number again:");
				InputStreamReader input = new InputStreamReader(System.in);
				keyboard=new BufferedReader(input);
				column=keyboard.read()-48;
			}
			return column;
		}
		catch(Throwable e)
		{
			System.out.println("Wrong input number!");
		}
		return -1;
		// ADD YOUR CODE HERE
		// DON'T FORGET TO CHANGE THE RETURN
	}
	
	public static int firstMovePlayer1 (){
		return 3;
	}
	
	public static int movePlayer1 (int columnPlayed2, Configuration c){
		if(c.canWinNextRound(1)!=-1)
		{
			return c.canWinNextRound(1);
		}
		else if(c.canWinTwoTurns(1)!=-1)
		{
			return c.canWinTwoTurns(1);
		}
		else
		{
			if(c.available[columnPlayed2]<=5)
			{
				return columnPlayed2;
			}
			else
			{
				for(int i=1;i<6;i++)
				{
					if(columnPlayed2-i>=0&&c.available[columnPlayed2-i]<=5)
					{
						return columnPlayed2-i;
					}
					else if(columnPlayed2+i<=6&&c.available[columnPlayed2+i]<=5)
					{
						return columnPlayed2+i;
					}
					else continue;
				}
			}
		}
		// ADD YOUR CODE HERE
		return 0; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
