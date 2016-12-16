/**
 * Created by Trevor Goldstein on 12/1/16.
 * Mr. Levin
 * AP Computer Science Java
 * Description: truth or dare -- love edition
 */
package chatbot;

public class TrevorBot
{
	private String TruthQuestions()
	{
		final int numOfQs = 6;
		double r = Math.random();
		int whichQ = (int)(r * numOfQs);
		String truth = "";
		
		if (whichQ == 0)
		{
			truth = "How many girlfriends/boyfriends have you had?";
		}
		else if (whichQ == 1)
		{
			truth = "What's your ideal romantic dinner?";
		}
		else if (whichQ == 2)
		{
			truth = "Who do you have a crush on?";
		}
		else if (whichQ == 3)
		{
			truth = "Will you marry me?";
		}
		else if (whichQ == 4)
		{
			truth = "If you were on a stranded island with one other person, who would you choose?";
		}
		else if (whichQ == 5)
		{
			truth = "Who's your celebrity crush?";
		}
		return truth;
	}
	private String Dares()
	{
		final int numOfDs = 6;
		double r = Math.random();
		int whichD = (int)(r * numOfDs);
		String dare = "";
		
		if (whichD == 0)
		{
			dare = "Tell whoever is next to you you love them.";
		}
		else if (whichD == 1)
		{
			dare = "Ask someone to prom.";
		}
		else if (whichD == 2)
		{
			dare = "Give everyone in the room you are in a hug.";
		}
		else if (whichD == 3)
		{
			dare = "Give someone a great complement from the heart.";
		}
		else if (whichD == 4)
		{
			dare = "Buy a giant teddy bear.";
		}
		else if (whichD == 5)
		{
		}
		return dare;
}
