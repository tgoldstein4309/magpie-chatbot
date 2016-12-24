package chatbot;

/*
  Created by Zak, George, and Trevor on 12/8/16
  AP Computer Science A
  Mr. Levin
 */

import java.util.Scanner;

public class ChatBotRunner {
    private ChatBotParser parser; // cli I/O
    private Scanner in;
    private String userInput;
    
    public static void main(String[] args)
    {
        ChatBotRunner chat = new ChatBotRunner();
        chat.run(); // runner
    }

    // constructor
    public ChatBotRunner() {
        in = new Scanner(System.in);
        parser = new ChatBotParser(in);
        userInput = ""; // nothing input
    }

    // cleans up string input
    public static String simplify(String str) {
    	str = str.trim();
        return str.toLowerCase();
    }
    
    private void greet() { // initial greeting
    	System.out.println("Hello, I am the chatbot. How are you doing today?\n" +
                           "enter \"help\" for a list of commands.\n");
    }

    // entire chatbot runs inside run method
    private void run() {
    	greet();
    	while (!simplify(userInput).equals("bye")) {
            userInput = simplify(in.nextLine());
            parser.input(userInput);
            parser.respond(); // all logic is on parser
        }
        parser.askForHistory(); // echos back history if yes
    }
}
