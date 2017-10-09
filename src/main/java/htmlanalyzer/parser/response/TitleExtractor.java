package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
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
