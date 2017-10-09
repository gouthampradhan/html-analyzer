package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 * Class to extract links. Uses a helper class to extract links
 * @see LinkExtractorHelper
 */
public class LinkExtractor implements HtmlDataExtractor {
    /**
     * Extract the links from the given Jsoup Document object
     * @param document Jsoup document object
     * @return List of links
     */
    @Override
    public List<String> extract(Document document) {
        return LinkExtractorHelper.extract(document);
    }
}
