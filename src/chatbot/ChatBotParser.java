package chatbot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private List<String> history = new ArrayList<>();
    private String answer = "";

    private int emotion = 0;

    public ChatBotParser(Scanner in) {
        this.in = in;

        // try to import file i/o and read
        try {
            response = new ChatBotResponses();
            response.readFiles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // commands list
    private void helpCommands() {
        answer =  "Commands:\n" +
                    "help - lists commands\n" +
                    "truth/dare - play truth or dare game\n" +
                    "love/guru - talk to the love guru\n" +
                    "search - search the internet\n" +
                    "bye - abandon the chatbot conversation\n";
    }

    public void input(String str) {
        if (str.isEmpty()) {
            answer = response.getRandomResponse();
            return;
        }

        history.add(str);

        // split first response
        String[] resp = str.split("\\s+");

        // if is command, do corresponding action
        switch (resp[0]) {
            case "bye" : answer = ""; break;
            case "help" : helpCommands(); break;
            // TRUTH OR DARE
            case "truth" :
            case "dare" : {
            	System.out.println(trev.getGreeting());
                System.out.println(trev.truth());
                in.nextLine();
                System.out.println(trev.dares());
                in.nextLine();
                answer = "\n" + response.getRandomResponse();
            } break;
            // SEARCHING
            case "search": {
                answer = zak.google(Arrays.copyOfRange(resp, 1, resp.length));
            } break;
            // LOVE GURU
            case "love" :
            case "guru" : {
                System.out.println(george.getGreeting() + "\n");
                System.out.println(george.randomQuestions());
                String greetResponse = in.nextLine().trim().toLowerCase();
                answer = george.getResponse(greetResponse);
            } break;
            // HISTORY
            case "repeat" : answer = history.get(history.size() - 2); break;
            // RANDOM RESPONSE
            default: {
                answer = emotionalResponse(String.join("", resp));
                break;
            }
        }
    }

    public String emotionalResponse(String response) {
        // read user input and change feelins to correspond
        for (String s: response.split("\\s+")) {
            if (this.response.isPositive(response)) emotion++;
            if (this.response.isNegative(response)) emotion--;
        }

        // feelings
        if (emotion > 5) {
            return this.response.getPositiveResponse();
        } else if (emotion < -5) {
            return this.response.getNegativeResponse();
        } else {
            return this.response.getRandomResponse();
        }
    }

    // print answer
    public void respond() {
        System.out.println(answer);
    }

    // history gets printed
    private void printHistory() {
        System.out.println("\nHistory:");
        for (String str : history) {
            System.out.println(str);
        }
    }

    // determine if wanted to print history
    public void askForHistory() {
        int respMood = 0;
        System.out.println("Would you like to see your conversation history?");
        answer = ChatBotRunner.simplify(in.nextLine());
        // test user input
        for (String s : answer.split("\\s+")) {
            if (response.isPositive(s)) respMood++;
            if (response.isNegative(s)) respMood--;
        }

        if (respMood >= 0) printHistory();
    }
}
