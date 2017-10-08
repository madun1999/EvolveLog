package nimGameEvolve;

public class ConventionalNimPlayer implements Comparable<ConventionalNimPlayer> {
	private int[] pickChoice;
	private int win = 0;
	private int lose = 0;
	private int stonesPicked = 0;
	public ConventionalNimPlayer(int[] dis)
	{
		pickChoice = dis;
	}
	public void mutateFrom(ConventionalNimPlayer source, int SPP)
	{
		if ((int) (Math.random()*2) == 0){
			pickChoice = source.getChoice().clone();
		}
		else
		{
			int index = (int) (Math.random()*pickChoice.length);
			int direction = (int) (Math.random()*2);
			if (direction == 0) {direction = -1;}
			int[] newChoice = source.getChoice().clone();
			newChoice[index]+=direction;
			if (newChoice[index]>SPP)
			{
				newChoice[index] -= 2;
			}
			if (newChoice[index] <= 0)
			{
				newChoice[index] = 2;
			}
			pickChoice = newChoice;
		}
	}
	public ConventionalNimPlayer(int SPP,int noStone)
	{
		randomizeChoice(SPP,noStone);
	}
	
	public void randomizeChoice(int SPP,int noStone)
	{
		pickChoice = new int[noStone];
		for (int i = noStone-1;i>=0;i--)
		{
			pickChoice[i]= (int) (Math.random()*SPP+1);
		} 

	}
	
	public int answer(int q)
	{
		return pickChoice[q];
	}
	
	public String toString()
	{
		String out = new String();
		for (int i=0;i<pickChoice.length;i++)
		{
			out+= pickChoice[i];
			out+= " ";
		}
		return out;
	}
	public void winPlus(int a)
	{
		win+=1;
		stonesPicked += a;
	}
	public void losePlus()
	{
		lose++;
	}
	public boolean ifGood()
	{
		return win>=lose;
	}
	public void eliminate()
	{
		win = 0;
		lose = 0;
		stonesPicked = 0;
		pickChoice=new int[pickChoice.length];
	}
	public int[] getChoice()
	{
		return pickChoice;
	}

	@Override
	public int compareTo(ConventionalNimPlayer o) {
		if (win == o.win) 
		{
			if(stonesPicked == o.stonesPicked)
			{
				return 0;
			}
			if(stonesPicked > o.stonesPicked)
			{
				return -1;
			}
			if(stonesPicked < o.stonesPicked)
			{
				return 1;
			}
		}
		if (win > o.win) return 1;
		if (win < o.win) return -1;
		return 0;
	}
	public int getWin()
	{
		return win;
	}
	public void setZero()
	{
		win = 0;
		lose = 0;
		stonesPicked = 0;
	}
}
