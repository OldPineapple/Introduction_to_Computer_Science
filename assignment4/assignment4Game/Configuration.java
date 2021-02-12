package assignment4Game;
//Name: Hanwen Wang   ID:260778557
public class Configuration {
	
	public int[][] board;
	public int[] available;
	boolean spaceLeft;
	
	public Configuration(){
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}
	
	public void print(){
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				if (board[j][5-i] == 0){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+ board[j][5-i]+" |");
				}
			}
			System.out.println();
		}
	}
	public void addDisk (int index, int player){
		// ADD YOUR CODE HERE
		if(index>=0&&index<=6&&available[index]<6)
		{
			board[index][available[index]]=player;
			available[index]++;
		}
		for(int j=0;j<7;j++)
		{
			int num=0;
			if(available[j]==6)
			{
				num++;
			}
			if(num==7)
			{
				spaceLeft=false;
			}
		}
	}
	
	public boolean isWinning (int lastColumnPlayed, int player){
		// ADD YOUR CODE HERE
		//if(board[lastColumnPlayed][available[lastColumnPlayed]-1]!=player)
		//	return false;
		if(	lastColumnPlayed>=3&&lastColumnPlayed<=6&&
				available[lastColumnPlayed]>=1&&available[lastColumnPlayed]<=6&&
			board[lastColumnPlayed-1][available[lastColumnPlayed]-1]==player&&
			board[lastColumnPlayed-2][available[lastColumnPlayed]-1]==player&&
			board[lastColumnPlayed-3][available[lastColumnPlayed]-1]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=2&&lastColumnPlayed<=5&&
				available[lastColumnPlayed]>=1&&available[lastColumnPlayed]<=6&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed-2][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-1]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=1&&lastColumnPlayed<=4&&
				available[lastColumnPlayed]>=1&&available[lastColumnPlayed]<=6&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-1]==player)
		{
			return true;
		}
		else if(lastColumnPlayed<=3&&lastColumnPlayed>=0&&
				available[lastColumnPlayed]>=1&&available[lastColumnPlayed]<=6&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]-1]==player&&
				board[lastColumnPlayed+3][available[lastColumnPlayed]-1]==player)
		{
			return true;
		}
		else if(lastColumnPlayed<=6&&lastColumnPlayed>=0&&
				available[lastColumnPlayed]>=4&&available[lastColumnPlayed]<=6&&
				board[lastColumnPlayed][available[lastColumnPlayed]-2]==player&&
				board[lastColumnPlayed][available[lastColumnPlayed]-3]==player&&
				board[lastColumnPlayed][available[lastColumnPlayed]-4]==player)
		{
			return true;
		}
		else if(available[lastColumnPlayed]>=4&&available[lastColumnPlayed]<=6&&
				lastColumnPlayed>=3&&lastColumnPlayed<=6&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]-2]==player&&
				board[lastColumnPlayed-2][available[lastColumnPlayed]-3]==player&&
				board[lastColumnPlayed-3][available[lastColumnPlayed]-4]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=2&&lastColumnPlayed<=5
				&&available[lastColumnPlayed]>=3&&available[lastColumnPlayed]<=5&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]-2]==player&&
				board[lastColumnPlayed-2][available[lastColumnPlayed]-3]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=1&&lastColumnPlayed<=4&&
				available[lastColumnPlayed]>=2&&available[lastColumnPlayed]<=4&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]-2]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]+1]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]]==player)
		{
			return true;
		}
		else if(lastColumnPlayed<=3&&available[lastColumnPlayed]<=3&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]+1]==player&&
				board[lastColumnPlayed+3][available[lastColumnPlayed]+2]==player)
		{
			return true;
		}
		else if(lastColumnPlayed<=3&&available[lastColumnPlayed]>=4&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-2]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]-3]==player&&
				board[lastColumnPlayed+3][available[lastColumnPlayed]-4]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=1&&lastColumnPlayed<=4&&
				available[lastColumnPlayed]>=3&&available[lastColumnPlayed]<=5&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]]==player&&
				board[lastColumnPlayed+2][available[lastColumnPlayed]-3]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-2]==player)
		{
			return true;
		}
		else if(lastColumnPlayed>=2&&lastColumnPlayed<=5&&
				available[lastColumnPlayed]>=2&&available[lastColumnPlayed]<=4&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]]==player&&
				board[lastColumnPlayed-2][available[lastColumnPlayed]+1]==player&&
				board[lastColumnPlayed+1][available[lastColumnPlayed]-2]==player)
		{
			return true;
		}
		else if(available[lastColumnPlayed]<=3&&available[lastColumnPlayed]>=0&&
				lastColumnPlayed>=3&&lastColumnPlayed<=6&&
				board[lastColumnPlayed-1][available[lastColumnPlayed]]==player&&
				board[lastColumnPlayed-2][available[lastColumnPlayed]+1]==player&&
				board[lastColumnPlayed-3][available[lastColumnPlayed]+2]==player)
		{
			return true;
		}
		else
		{
			return false;
		} // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinNextRound (int player){
		for(int index=0;index<7;index++)
		{
			if(available[index]<6)
			{
				board[index][available[index]]=player;
				available[index]++;
				if(isWinning(index,player)==false)
				{
					available[index]--;
					board[index][available[index]]=0;
					continue;
				}
				else if(isWinning(index,player)==true)
				{
					available[index]--;
					board[index][available[index]]=0;
					return index;
				}
			}
			else 
				{
					continue;
				}
		}
		return -1;
		// ADD YOUR CODE HERE // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinTwoTurns (int player){
		int i=0;int a=-1;int j=0;int num=0;int counter=0;
		if(player==1)
			i=2;
		else if(player==2)
			i=1;
		for(int index=0;index<7;index++)
		{
			if(available[index]<6)
			{
				board[index][available[index]]=player;
				available[index]++;
				if(spaceLeft==true)
				{
					if(canWinNextRound(i)!=-1)
					{
						available[index]--;
						board[index][available[index]]=0;
						return -1;
					}
					else
					{
						for(j=0;j<7;j++)
						{
							if(available[j]<6)
							{
								board[j][available[j]]=i;
								available[j]++;
								if(counter==0)
								{
									for(int col=0;col<7;col++)
									{
										if(available[col]==6)
										{
											counter++;
										}
									}
								}
								if(spaceLeft==true)
								{
									if(canWinNextRound(player)!=-1)
									{
										num++;
										available[j]--;
										board[j][available[j]]=0;
									}
									else if (canWinNextRound(player)==-1)
									{
										available[j]--;
										board[j][available[j]]=0;
										break;
									}
									if(num==7-counter)
									{
										a=index;
										break;
									}
								}
							}
							else if(available[j]==6)
							{
								continue;
							}
						}
					}
				}
				if(a==-1)
				{
					available[index]--;
					board[index][available[index]]=0;
					continue;
				}
				else if(a!=-1)
				{
					available[index]--;
					board[index][available[index]]=0;
					break;
				}
			}
			else if(available[index]==6)
			{
				continue;
			}
		}
		// ADD YOUR CODE HERE
		return a; // DON'T FORGET TO CHANGE THE RETURN
	}

}