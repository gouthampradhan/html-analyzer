package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
public class TitleExtractor implements HtmlDataExtractor {
    @Override
    public String extract(Document document) {
        return document.title();
    }
}
