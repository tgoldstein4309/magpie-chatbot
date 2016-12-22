/**
 * @Author George Li
 * Date: 12/9/16
 * Teacher: Mr.Levin
 * Period 8
 * Description: a program talk about love and relationships
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
		return statement.indexOf(search) >= 0 && statement.indexOf(search) == search.length();
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
	
		return response;
	}
}
