package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
public class LinkExtractor implements HtmlDataExtractor {
    @Override
    public List<String> extract(Document document) {
        return LinkExtractorHelper.extract(document);
    }
}
