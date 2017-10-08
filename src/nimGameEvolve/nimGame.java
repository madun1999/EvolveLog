package nimGameEvolve;

public  class nimGame {
	
	public static int playerNFirst(int nFirst,int noStone,ConventionalNimPlayer[] players)
	{
		int stoneInpile=noStone;
		int player=1-nFirst;
		int[] stonePicked = {0,0};
		while(stoneInpile > 0)
		{
			player=1-player;
			int a =  players[player].answer(stoneInpile-1);
			stoneInpile -= a;
			stonePicked[player]+=a;
		}
		players[player].winPlus(stonePicked[player]);
		players[1-player].losePlus();
		return player;
	}
	public static int DoDualRounds(int noStone, ConventionalNimPlayer[] players)
	{
		playerNFirst(0,noStone,players);
		playerNFirst(1,noStone,players);
		return 0;
	}
}
