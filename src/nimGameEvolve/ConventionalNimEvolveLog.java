package nimGameEvolve;

import java.util.ArrayList;

public class ConventionalNimEvolveLog {
	//highest amount of stones
	private final int highStone;
	private final int SSP;
	private ArrayList<ConventionalNimPlayer> players;
	private int generation = 0 ;
	
	public ConventionalNimEvolveLog(int stone,int playerNo,int SPP) 
	{
		highStone = stone;
		SSP = SPP;
		players = new ArrayList<ConventionalNimPlayer>();
		for(int i = 1;i<playerNo;i++)
		{
			players.add(new ConventionalNimPlayer(SSP,stone));
		}
	}
	public int doGeneration()
	{
		clearWin();
		doNDualRounds();
		int[] deadList = eliminate();
		mutate(deadList);
//		output();
		generation++;
		return 0;
	}
	private void clearWin()
	{
		for(int i=0;i<players.size();i++)
		{
			players.get(i).setZero();
		}
	}
	private void doNDualRounds()
	{
		for (int i=0;i<players.size()-1;i++)
		{
			for (int j=i+1;j<players.size();j++)
			{	
				ConventionalNimPlayer[] send = {players.get(i),players.get(j)};
				nimGame.DoDualRounds((int)(Math.random()*highStone+1),send);

			}
		}
	}
	private int[] eliminate()
	{
		players.sort(null);
		int s = players.size();

		int[] deadList = new int[(s+1)/2];

		for (int i = 0; i < (int)((s+1)/2); i++)
		{
			deadList[i] = (int)(Math.random()-((double)(i)/s)-1)+1;
		}
		if (s%2 != 0)
		{

			deadList[s/2] = (int)(Math.random()-(0.5)-1)+1;
		}
		return deadList;
	}
	private void mutate(int[] deadList)
	{
		int s = players.size();
		for(int i = 0; i< deadList.length;i++)
		{
			if (deadList[i] == 1)
			{
				players.get(i).mutateFrom(players.get(s-i-1), SSP);
			}
			else
			{
				players.get(s-i-1).mutateFrom(players.get(i), SSP);
			}
		}
		if (s % 2 != 0)
		{
			players.get(s/2).randomizeChoice(SSP, highStone);
		}
	}
	public String output()
	{
//		System.out.println(players.get(players.size()-1));
//		System.out.println(players.get(players.size()-1).getWin());
		return players.get(players.size()-1).toString();
	}
	public void outputAll()
	{
		int a = 0;
		for(int i=0;i<players.size();i++)
		{
			System.out.println(i+1);
			System.out.println(players.get(i));
			System.out.println(players.get(i).getWin());
			System.out.println();
			a+=players.get(i).getWin();
		}
		System.out.println(a);
	}
}
