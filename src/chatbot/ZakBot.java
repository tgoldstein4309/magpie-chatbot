package chatbot;

/*
  Created by Zakaria Elkatani on 12/1/16.
  Description: Google Searching
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ZakBot {
    Document d; // html page DOM

    public ZakBot() {
        try {
            d = Jsoup.connect("https://www.google.com/")
                    .userAgent("Mozilla")
                    .ignoreHttpErrors(true)
                    .timeout(0)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String google(String[] url) {
        if (url.length == 0) return "Nothing to search";
        String newUrl = String.join("+", url);

        System.out.println("---Google Search---");
        String body;
        try {
            //Connect to the url and obtain HTML response
            d = Jsoup.connect("https://www.google.com/search?q=" + newUrl + "&num=1")
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .get();

            //parsing HTML after examining DOM
            try {
                Element el = d.select("span.st").get(0);
                body = el.text();
            } catch (IndexOutOfBoundsException e) {
                return "No text to display sadly :(";
            }
        } catch (IOException e) {
            body = "Something went wrong with searching!";
            e.printStackTrace();
        }

        return body + "\n";
    }
}
