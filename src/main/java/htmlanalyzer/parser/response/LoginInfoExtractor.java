package htmlanalyzer.parser.response;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 * Class to extract the login information in the given url.
 */
public class LoginInfoExtractor implements HtmlDataExtractor {

    /**
     * Method looks for the text-input type and name attributes in a give html form to identify if the
     * given html form has a login information or not
     * @param document Jsoup document object
     * @return true if the document has a login information, false otherwise.
     */
    @Override
    public Boolean extract(Document document) {
        Elements inputs = document.getElementsByTag("input");
        return inputs.stream().anyMatch(x -> {
                    Attributes attributes = x.attributes();
                    if (attributes != null) {
                        String name = attributes.get("name");
                        String type = attributes.get("type");
                        if (name != null && type != null) {
                            if (type.equals("text")) {
                                if (name.equals("user") || name.equals("login") || name.equals("username")) {
                                    return true;
                                }
                            } else if (type.equals("password")) {
                                if (name.equals("password") || name.equals("passwd") || name.equals("pass")) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
        );
    }
}
