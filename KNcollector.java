package stuff;

/**
 * Created by msivraj on 2/20/18.
 */
import java.io.IOException;
//import java.io.M
//import java.nio.charset.MalformedInputException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class KNcollector {


    public String GOOGLE_SEARCH_URL = "https://www.google.com/search";


    String urlCollector(String searchTerm, int num) throws IOException {
        //Taking search term input from console
        String returnVal="";
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the search term.");
//        String searchTerm = scanner.nextLine();
//        System.out.println("Please enter the number of results. Example: 5 10 20");
//        int num = scanner.nextInt();
//        scanner.close();

        String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
        //without proper User-Agent, we will get 403 error
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
//        Document doc = Jsoup.connect(searchURL).get();

//        System.out.println("-------------------------------DOC-----------------------------\n"+doc);
//
//
//        String html=doc.html();
//        System.out.println("-------------------------------HTML-----------------------------\n"+html);
//        Document htmldoc=Jsoup.parse(html);
//        System.out.println("-------------------------------HTMLDOC-------------------------\n"+htmldoc);
//
//        Elements ptag=htmldoc.select("p");
//        Element ptag=htmldoc.tagName("p");
//        String ptagtext = ptag.text();
//
//
//        below will print HTML data, save it to a file and open in browser to compare
//        System.out.println("--------------------------------HTML----------------------------\n"+doc.html());
//        System.out.println("--------------------------------TEXT----------------------------\n"+htmldoc.body().text());
//        System.out.println("--------------------------------P-------------------------------\n"+ptagtext);
//
//        If google search results HTML change the <h3 class="r" to <h3 class="r1"
//        we need to change below accordingly
        Elements results = doc.select("h3.r > a");

        for (Element result : results) {
            String linkHref = result.attr("href");
            String url = linkHref.substring(7, linkHref.indexOf("&"));
            try {
               returnVal=textFinder(url);
            } catch(IllegalArgumentException iae){
//                System.out.println("You have an MALFORMEDINPUTEXCEPTION error");
//                continue;
            } catch (IOException ioe) {
//                System.out.println("You have an IOEXCPTION error");
//                continue;
            }
//            System.out.println("------------------------URL--------------------\n"+url);
//            String linkText = result.text();
//            String text=result.html();
//            System.out.print("------------------------TEXT----------------------\n"+text);
//            System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
//            System.out.println("URL::" + linkHref.substring(6, linkHref.indexOf("&")));
            System.out.println("-------------------FOR LOOP------------------------");

        }
        return returnVal;
    }

    String textFinder(String urlIn)throws IOException{
//        System.out.println(urlIn);
        Document doc = Jsoup.connect(urlIn).get();
        String html=doc.html();
//        System.out.println("-------------------------------HTML-----------------------------\n"+html);
        Document htmldoc=Jsoup.parse(html);
//        System.out.println("-------------------------------HTMLDOC-------------------------\n"+htmldoc);

        Elements ptag=htmldoc.select("p");
//        Element ptag=htmldoc.tagName("p");
        String ptagtext = ptag.text();
//        System.out.println("---------------------------PTAGTEXT----------------------------\n"+ptagtext);

        return ptagtext;
    }
}
