package htmlanalyzer.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class Test {
    /*public static void main(String[] args) throws Exception{
        Document doc = Jsoup.connect("http://www.htmlhelp.com/reference/wilbur/").get();
        List<String> list = doc.childNodes().stream()
                .filter(x -> x instanceof DocumentType)
                .map(x -> x.attr("publicid"))
                .collect(Collectors.toList());
        if(list.isEmpty()){
            System.out.println("Version 5");
        } else{
            System.out.println(list.get(0));
        }
    }*/
}
