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
    
    public void greet() {
    	System.out.println("Hello, I am the chatbot. How are you doing today?");
    }

    // entire chatbot runs inside run method
    public void run() {
    	greet();
    	while (!simplify(response).equals("bye")) {
    		response = simplify(in.nextLine());
    		System.out.println("No, you're a " + response + "!");
    	}
    }
}