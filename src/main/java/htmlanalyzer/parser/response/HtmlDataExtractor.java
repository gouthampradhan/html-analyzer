package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

/**
 * Interface for data extraction. Implement this interface to extract different parts of html document
 * @see LinkCountExtractor
 * @see LinkExtractor
 * @see LoginInfoExtractor
 * @see TitleExtractor
 * @see VersionExtractor
 */
public interface HtmlDataExtractor<T> {
    /**
     * Interface to retrieve data form a given Document
     * @param document Jsoup document object
     * @return Generic response object
     */
    T extract(Document document);
}
