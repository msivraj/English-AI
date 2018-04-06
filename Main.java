package stuff;

/**
 * Created by msivraj on 7/15/17.
 */
import java.io.IOException;
import java.lang.String;
import java.util.Vector;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String text="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the search term.");
        String searchTerm = scanner.nextLine();
        System.out.println("Please enter the number of results. Example: 5 10 20");
        int num = scanner.nextInt();
        scanner.close();
        KNcollector myKnCollector=new KNcollector();
        try {
            text=myKnCollector.urlCollector(searchTerm, num);
        } catch (IOException e) {
            System.out.println("You have an error");
        }
//        String myStr = new String("Out of the night that covers me, Black as the pit from pole to pole, I thank whatever gods " +
//                "may be For my unconquerable soul. In the fell clutch of circumstance I have not winced nor cried aloud. Under the " +
//                "bludgeonings of chance My head is bloody, but unbowed. Beyond this place of wrath and tears Looms but the Horror of the shade, " +
//                "And yet the menace of the years Finds and shall find me unafraid. It matters not how strait the gate, How charged with punishments " +
//                "the scroll, I am the master of my fate, I am the captain of my soul. ");
        Tokenizer myTokenizer = new Tokenizer();
        for (int i = 0; i < text.length(); i++) {
//        char aChar=myStr[i];
            myTokenizer.confirmToken(text.charAt(i));
        }
        //myTokenizer.printTokens();
        myTokenizer.parseTokens();

        Vector<Token> toks = myTokenizer.getTokens();
        System.out.println("wel done");




    }

}
