package chatbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zakaria Elkatani on 12/21/16.
 * Description: parser for chatbot
 */
public class ChatBotParser {
    private ChatBotResponses response;
    private TrevorBot trev = new TrevorBot();
    private GeorgeBot george = new GeorgeBot();
    private ZakBot zak = new ZakBot();
    private Scanner in;
    private List<String> history = new ArrayList<String>();
    private String answer = "";
    private String prevAnswer;

    private int emotion = 0;

    public ChatBotParser(Scanner in) {
        this.in = in;
        try {
            response = new ChatBotResponses();
            response.readFiles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void helpCommands() {
        answer =  "Commands:\n" +
                    "help - lists commands\n" +
                    "truth/dare - play truth or dare game\n" +
                    "love/guru - talk to the love guru\n" +
                    "search - search thbhe internet\n" +
                    "bye - abandon the chatbot conversation\n";
    }

    public void input(String str) {
        if (str.isEmpty()) {
            answer = response.getRandomResponse();
            return;
        }
        prevAnswer = str;

        history.add(str);
        String[] resp = str.split("\\s+");

        switch (resp[0]) {
            case "bye" : answer = ""; break;
            case "help" : helpCommands(); break;
            case "truth" :
            case "dare" : {
            	System.out.println(trev.getGreeting());
                System.out.println(trev.truth());
                in.nextLine();
                System.out.println(trev.dares());
                in.nextLine();
                answer = "\n" + response.getRandomResponse();
            } break;
            case "search" : answer = zak.google(answer); break;
            case "love" :
            case "guru" : {
                System.out.println(george.getGreeting() + "\n");
                System.out.println(george.randomQuestions());
                String greetResponse = in.nextLine().trim().toLowerCase();
                answer = george.getResponse(greetResponse);
            } break;
            case "repeat" : answer = history.get(history.size() - 2); break;
            default: {
                answer = emotionalResponse(answer);
                break;
            }
        }
    }

    public String emotionalResponse(String response) {
        for (String s: response.split("\\s+")) {
            if (this.response.isPositive(response)) emotion++;
            if (this.response.isNegative(response)) emotion--;
        }

        if (emotion == 0) {
            return this.response.getRandomResponse();
        } else if (emotion > 0) {
            return this.response.getPositiveResponse();
        } else {
            return this.response.getNegativeResponse();
        }
    }

    public void respond() {
        System.out.println(answer);
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
        answer = ChatBotRunner.simplify(in.nextLine());
        for (String s : answer.split("\\s+")) {
            if (response.isPositive(s)) respMood++;
            if (response.isNegative(s)) respMood--;
        }

        if (respMood >= 0) printHistory();
    }
}
