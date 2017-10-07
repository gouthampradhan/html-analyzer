package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public interface HtmlDataExtractor<T> {
    T extract(Document document);
}
