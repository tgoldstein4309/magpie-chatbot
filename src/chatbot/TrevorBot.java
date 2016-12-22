/**
 * Created by Trevor Goldstein on 12/1/16.
 * Mr. Levin
 * AP Computer Science Java
 * Description: truth or dare -- love edition
 */
package chatbot;

public class TrevorBot
{
	public String getGreeting()
	{
		return "Welcome to Truth or Dare. Which do you want?: ";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("truth") >= 0)
		{
			response = truth();
		}
		else if (statement.indexOf("dare") >= 0)
		{
			response = dares();
		}
		else 
		{
			response = "You didn't answer my question :(";
		}
		return response;
		
	}
	public String truth()
	{
		final int numOfQs = 6; 
		double r = Math.random();
		int whichQ = (int)(r * numOfQs);
		String truth = "";
		//randomized truth questions
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
	public String dares()
	{
		final int numOfDs = 6;
		double r = Math.random();
		int whichD = (int)(r * numOfDs);
		String dare = "";
		//randomized dares
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
			dare = "Bake a bunch of red velvet cupcakes for your friends.";
		}
		else if (whichD == 6)
		{
			dare = "Sing someone a ballad of Weeknd songs to make your crush swoon for you.";
		}
		return dare;
	}
}
