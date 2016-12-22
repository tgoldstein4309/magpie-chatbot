package chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zakaria Elkatani on 12/21/16.
 * Description: parser for chatbot
 */
public class ChatBotParser {
    private TrevorBot trev = new TrevorBot();
    private GeorgeBot george = new GeorgeBot();
    private ZakBot zak = new ZakBot();
    private Scanner in;
    private List<String> history = new ArrayList<String>();
    private String response = "";
    private String prevResponse;
    private String[] affirmations = "yes yeah yup yea ok sure good fun :)".split(" ");
    private String[] rejections = "no nope never sike nah nyet :(".split(" ");
    private int emotion = 0;

    public ChatBotParser(Scanner in) {
        this.in = in;
    }

    private void helpCommands() {
        response =  "Commands:\n" +
                    "help - lists commands\n" +
                    "truth/dare - play truth or dare game\n" +
                    "love/guru - talk to the love guru\n" +
                    "search - search thbhe internet\n" +
                    "bye - abandon the chatbot conversation\n";
    }

    public void input(String str) {
        if (str.isEmpty()) {
            int shuffle = (int) (Math.random() * 5);
            switch (shuffle) {
                case 0: response = "Did you say something?"; break;
                case 1: response = "What did you just say about my mother?"; break;
                case 2: response = "Can you speak up?"; break;
                case 3: response = ".....\nOh! I thought we were playing a game!"; break;
                case 4: response = "I feel the same exact way"; break;
                case 5: response = "So two fish are in a tank. One turns to the other and says " +
                                   "\"how do you drive this thing?\""; break;
            }

            return;
        }
        prevResponse = str;

        history.add(str);
        String[] resp = str.split(" ");

        switch (resp[0]) {
            case "bye" : response = ""; break;
            case "help" : helpCommands(); break;
            case "truth" : trev.truth();
            case "dare" : {
            	System.out.println(trev.getGreeting());
            	String answer = in.nextLine();
            	System.out.println(trev.getResponse(resp[0]));
            	in.nextLine();
                response = "hey thats pretty good";
            } break;
            case "search" : response = zak.google(response); break;
            case "love" :
            case "guru" : {
                System.out.println(george.getGreeting() + "\n");
                System.out.println(george.randomQuestions());
                response = in.nextLine();
                String answer = george.getResponse(response);
                System.out.println(answer);
                in.nextLine();
                response = "May karma be with you";
            } break;
            case "repeat" : response = history.get(history.size() - 2); break;
            default: {
                response = emotionalResponse(response);
                break;
            }
        }
    }

    public String emotionalResponse(String response) {
        for (String s: response.split(" ")) {
            if (positiveResponse(s)) emotion++;
            if (negativeResponse(s)) emotion--;
        }
        
        int range = (int) (Math.random() * 3);
        if (emotion == 0) {
            switch (range) {
                case 0:
                    return "Really does makes you think";
                case 1:
                    return "Now why do you believe that?";
                case 2:
                    return "No, you're a " + prevResponse + "!";
                case 3:
                    return "Interesting";
            }
        }

        if (emotion > 0) {
            if (emotion > 3) {
                switch (range) {
                    case 0:
                        return "Hey now, you're an allstar!";
                    case 1:
                        return "So kind :')";
                    case 2:
                        return "Its not like I like you or something!";
                    case 3:
                        return "You are literally my favorite person";
                }
            }
            switch (range) {
                case 0:
                    return "You're a good person";
                case 1:
                    return "Thank you!";
                case 2:
                    return "WOW!";
                case 3:
                    return "Nice!";
            }
        }

        if (emotion < 0) {
            if (emotion < -5) return "...";
            if (emotion < -3) {
                switch (range) {
                    case 0:
                        return "Why would you say that to me? :^(";
                    case 1:
                        return "Why am I still talking to you?";
                    case 2:
                        return "*insults you under breath*";
                    case 3:
                        return "Whats your deal?";
                }
            }
            switch (range) {
                case 0:
                    return "It is what it is";
                case 1:
                    return "Okay";
                case 2:
                    return "Yeah sure...";
                case 3:
                    return "Hmmph!";
            }
        }
        return "Well would you look at that!";
    }

    public void respond() {
        System.out.println(response);
    }

    private boolean positiveResponse(String str) {
        for (String pos : affirmations) {
            if (str.equals(pos)) return true;
        }
        return false;
    }

    private boolean negativeResponse(String str) {
        for (String neg : rejections) {
            if (str.equals(neg)) return true;
        }
        return false;
    }

    private void printHistory() {
        System.out.println("\nHistory:");
        for (String str : history) {
            System.out.println(str);
        }
    }

    public void askForHistory() {
        int respMood = 0;
        System.out.println("Would you like to see your conversation history?");
        response = ChatBotRunner.simplify(in.nextLine());
        for (String s : response.split(" ")) {
            if (positiveResponse(s)) respMood++;
        }
        for (String s : response.split(" ")) {
            if (negativeResponse(s)) respMood--;
        }

        if (respMood >= 0) printHistory();
    }
}
