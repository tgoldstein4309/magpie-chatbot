/**
 * Created by Zak, George, and Trevor on 12/8/16
 * AP Computer Science A
 * * Mr. Levin
 */
package chatbot;

public class ChatBotRunner {
    public TrevorBot trev;
    public GeorgeBot george;
    public ZakBot zak;

    public static void main(String[] args)
    {
        ChatBotRunner chat = new ChatBotRunner();
        chat.run();
    }

    public ChatBotRunner() {
        trev = new TrevorBot();
        george = new GeorgeBot();
        zak = new ZakBot();
    }

    public void run() {
        // chatbot runs inside here
    }
}
