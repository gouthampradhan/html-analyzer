package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

/**
 * Class to extract title information from the url
 */
public class TitleExtractor implements HtmlDataExtractor {
    /**
     * Method to extract the title
     * @param document Jsoup document object
     * @return HTML title information
     */
    @Override
    public String extract(Document document) {
        return document.title();
    }
}
