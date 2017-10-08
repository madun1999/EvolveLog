package testing;

import nimGameEvolve.ConventionalNimEvolveLog;

public class TestingDriver {

	public static void main(String[] args) {
		ConventionalNimEvolveLog a = new ConventionalNimEvolveLog(30,100,4);
		
		
		for(int j = 0; j<=100;j++)
		{
			for (int i=0;i<50;i++){
				a.doGeneration();
			}
			System.out.println(j);
			System.out.println(a.output());
						
		}

		
		

	}

}
