package chatbot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zakaria Elkatani on 12/23/16.
 * Description: File I/O
 */
public class ChatBotResponses {
    // directories and files
    private final String DIR = "src/chatbot/responses/";
    private final String[] FILES = {
            "positive.txt",
            "negative.txt",
            "random.txt",
            "positive_keywords.txt",
            "negative_keywords.txt"
    };

    // readers and writers
    private BufferedReader[] readers = new BufferedReader[FILES.length];
    private List<List<String>> responses = new ArrayList<>();

    // try to construct arraylist and bufferedreaders
    public ChatBotResponses() throws FileNotFoundException {
        for (int i = 0; i < FILES.length; i++) {
            if (new File(DIR + FILES[i]).exists()) {
                readers[i] = new BufferedReader(new FileReader((DIR + FILES[i]))); // create new readers with dirs
                responses.add(new ArrayList<>()); // create 2d array list
            }
        }
    }

    // read files and then close afterwards
    public void readFiles() throws IOException {
        String line;
        for (int i = 0; i < FILES.length; i++) {
            while ((line = readers[i].readLine()) != null) {
                responses.get(i).add(line.trim().toLowerCase());
            }
        }

        for (int i = 0; i < readers.length; i++) {
            readers[i]. close();
        }
    }

    // get random positive response
    public String getPositiveResponse() {
        List<String> pos = responses.get(0);
        return pos.get(new Random().nextInt(pos.size()));
    }

    // get random negative response
    public String getNegativeResponse() {
        List<String> neg = responses.get(1);
        return neg.get(new Random().nextInt(neg.size()));
    }

    // get random neutral response
    public String getRandomResponse() {
        List<String> rand = responses.get(2);
        return rand.get(new Random().nextInt(rand.size()));
    }

    // determine if input is in positive list
    public boolean isPositive(String input) {
        return responses.get(3).contains(input);
    }

    // determine if input is in negative list
    public boolean isNegative(String input) {
        return responses.get(4).contains(input);
    }

}
