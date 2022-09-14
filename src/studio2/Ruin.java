package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("How much money are you starting with? ");
		double startAmount = in.nextDouble();
		System.out.print("What is your probability of winning a single play? ");
		double winChance = in.nextDouble();
		System.out.print("At what amount of money would you call it a successful day and leave? ");
		double winLimit = in.nextDouble();
		System.out.print("How many days are you gambling? ");
		int totalSimulations = in.nextInt();
		
		
		int win = 0;
		int lose = 0;
		
		
		for (int i = totalSimulations; i > 0; i--)
		{ 
			double dailyAmount = startAmount;

			while ((dailyAmount>0) && (dailyAmount < winLimit))
			{
				
				if (Math.random() < winChance)
				{
					dailyAmount = dailyAmount + 1;
				}
				else
				{
					dailyAmount = dailyAmount - 1;
				}
				

			}
			
			if (dailyAmount == winLimit) 
			{
				win++;
			}
			else 
			{
				lose++;
			}

		}
		
		
		if (winChance == .5)
		{
			double expectedRuin = (1 - (startAmount/winLimit));
			System.out.print(expectedRuin + "\n");
		}
		else 
		{
			double alpha = ((1 - winChance)/winChance);
			double expectedRuin = ((Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit) )/(1 - Math.pow(alpha, winLimit)));
			System.out.print(expectedRuin + "\n");

		}
		
		System.out.print("I won on " + win + " days, and lost "+ lose + " days" + "\n");

	
		
	}

}
