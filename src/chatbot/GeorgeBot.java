/**
 * @Author George Li
 * Date: 12/21/16
 * Teacher: Mr.Levin
 * Period 8
 * Description: a program to talk about oneself, love and relationships
 */
package chatbot;

public class GeorgeBot 
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, I am here to help you with your love life";
	}
	public boolean wordIn(String statement, String search)
	{
		return statement.contains(search);
	}
	/**
	 * Gives a response to user statement 
	 * @param statement 
	 * 			the user statement
	 * @return a response based on rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (wordIn(statement, "love")
				|| (wordIn(statement, "like")))
		{
			response = "What do you like about that person?";
		}
		else if (wordIn(statement, "hate")
				|| (wordIn(statement, "dislike")))
		{
			response = "What do you not like about that person?";
		}
		else if (wordIn(statement, "a lot")
				|| (wordIn(statement, "lot"))
				|| (wordIn(statement, "plenty")))
		{
			response = "The best and most beautiful things is to enjoy your life and be happy.";
		}
		else if (wordIn(statement, "a little")
				|| (wordIn(statement, "little"))
				|| (wordIn(statement, "never"))
				|| (wordIn(statement, "barely")))
		{
			response = "Don’t settle for a relationship that won’t let you be happy.";
		}
		else if (wordIn(statement, "books")
				|| (wordIn(statement, "book"))
				|| (wordIn(statement, "smart")))
		{
			response = "Aww, that is adorable. Your dates should be at Barnes & Nobles.";
		}
		else if (wordIn(statement, "looks")
				|| (wordIn(statement, "look"))
				|| (wordIn(statement, "handsome"))
				|| (wordIn(statement, "pretty"))
				|| (wordIn(statement, "beautiful")))
		{
			response = "Love is absolute loyalty. Try not to base it too much on their appearance.";
		}
		else if (wordIn(statement, "hugs")
				|| (wordIn(statement, "hug")))
		{
			response = "It definitely shows that you are very loving";
		}
		else if (wordIn(statement, "kisses")
				|| (wordIn(statement, "kiss")))
		{
			response = "Oh stop it, you're a romantic and will be able to sweep the person off their feet.";
		}
		else if (wordIn(statement, "fate")
				|| (wordIn(statement, "in fate")))
		{
			response = "You're passionate and will patiently wait for the right one in your life.";
		}
		else if (wordIn(statement, "in yourself")
				|| (wordIn(statement, "yourself"))
				|| (wordIn(statement, "in myself"))
				|| (wordIn(statement, "myself")))
		{
			response = "Soul mates sounds ridicous to me too when I could just go out and fish for one.";
		}
		else if (wordIn(statement, "half full")
				|| (wordIn(statement, "full"))
				|| (wordIn(statement, "half")))
		{
			response = "Wow, you are pretty cool. We both are extrovert and will socialize to make new friends.";
		}
		else if (wordIn(statement, "half empty")
				|| (wordIn(statement, "half"))
				|| (wordIn(statement, "empty")))
		{
			response = "I will tell you from experience that it is not good to be pessimistic.";
		}
		else if (wordIn(statement, "movies")
				|| (wordIn(statement, "movie")))
		{
			response = "It's good to not rush things and at a movie, the special person will slowly fall in love with you.";
		}
		else if (wordIn(statement, "netflix")
				|| (wordIn(statement, "netflix and chill")))
		{
			response = "STOP TRYING to netflix and chill, they will not like that too quick!";
		}
		return response;
	}
	public String randomQuestions()
	{
		final int NUM_OF_QUESTIONS = 5;
		double r = Math.random();
		int whichquestion = (int)(r * NUM_OF_QUESTIONS);
		String question = "";
		
		if (whichquestion == 0)
		{
			question = "Do you laugh a little or a lot when you are around that special person?";
		}
		else if (whichquestion == 1)
		{
			question = "Are you more into looks or books?";
		}
		else if (whichquestion == 2)
		{
			question = "Are you a hugs or kisses person?";
		}
		else if (whichquestion == 3)
		{
			question = "Do you believe in fate or in yourself when it comes to love?";
		}
		else if (whichquestion == 4)
		{
			question = "When you think about a cup with juice, is it half full or half empty?";
		}
		else if (whichquestion == 5)
		{
			question = "Where would you go on a first date, movies or netflix?";
		}
		return question;
	}
}
