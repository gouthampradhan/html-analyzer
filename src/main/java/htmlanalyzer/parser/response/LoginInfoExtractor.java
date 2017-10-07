package htmlanalyzer.parser.response;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
public class LoginInfoExtractor implements HtmlDataExtractor {
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
