package chatbot;

/*
  Created by Zakaria Elkatani on 12/1/16.
  Description: Google Searching and more
 */

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ZakBot {
    Document d;

    public ZakBot() {
        try {
            d = Jsoup.connect("https://www.google.com/#q=")
                    .userAgent("Mozilla")
                    .ignoreHttpErrors(true)
                    .timeout(0)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
    public void setPage(String url) {
        if (!(url.contains("http://") || url.contains("https://"))) url = "https://" + url;
        try {
            d = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Website not loaded");
            e.printStackTrace();
        }
    }
*/

    public String google(String url) {
        String body = "";
        try {
            d = Jsoup.connect("https://www.google.com/#q=" + url)
                .userAgent("Mozilla")
                .ignoreHttpErrors(true)
                .timeout(0)
                .get();

            System.out.println("Searching...");
            Elements links = d.select("li[class=g]");
            for (Element link : links) {
                Elements bodies = link.select("span[class=st]");
                body = bodies.text();

                System.out.println("Body: " + body + "\n");
            }
        } catch (IOException e) {
            body = "Something went wrong with searching!";
            e.printStackTrace();
        }

        return body;
    }
}
