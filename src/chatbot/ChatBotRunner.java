/**
 * Created by Zak, George, and Trevor on 12/8/16
 * AP Computer Science A
 * Mr. Levin
 */
package chatbot;

import java.util.Scanner;

public class ChatBotRunner {
    TrevorBot trev;
    GeorgeBot george;
    ZakBot zak;
    Scanner in;
    String response;
    
    public static void main(String[] args)
    {
        ChatBotRunner chat = new ChatBotRunner();
        chat.run();
    }

    // constructor
    public ChatBotRunner() {
        trev = new TrevorBot();
        george = new GeorgeBot();
        zak = new ZakBot();
        in = new Scanner(System.in);
        response = "";
    }
    
    // cleans up string input
    private String simplify(String str) {
    	str = str.trim();
    	return str.toLowerCase();
    }
    
    public void greet() { // initail greeting
    	System.out.println("Hello, I am the chatbot. How are you doing today? If you want to use"
    			+ " one of our features enter 'Help'.");
    }

    // entire chatbot runs inside run method
    public void run() {
    	greet();
    	if (simplify(response).equals("help")) 
    	{
    		response = simplify(in.nextLine());
    		System.out.println("Enter 1 for search engine, 2 for the Love Guru, and 3 for Truth or Dare.");
    	}
    	while (!simplify(response).equals("bye")) {
    		response = simplify(in.nextLine());
    		System.out.println("No, you're a " + response + "!");
    	}
    	
    }
}