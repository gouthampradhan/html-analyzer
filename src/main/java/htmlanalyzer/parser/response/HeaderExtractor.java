package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
public class HeaderExtractor implements HtmlDataExtractor {
    @Override
    public Map<String, Long> extract(Document document) {
        Elements hTags = document.select("h1, h2, h3, h4, h5, h6");
        return hTags.stream().collect(Collectors.groupingBy(Element::tagName, Collectors
                .counting()));

    }
}
