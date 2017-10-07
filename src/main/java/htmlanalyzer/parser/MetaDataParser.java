package htmlanalyzer.parser;

import htmlanalyzer.parser.data.LinkType;
import htmlanalyzer.parser.data.Metadata;
import htmlanalyzer.parser.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class MetaDataParser implements HtmlParser {

    private Log log = LogFactory.getLog(MetaDataParser.class);

    @Override
    @SuppressWarnings("unchecked")
    public ResultsWrapper parse(String url) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            Document doc = Jsoup.parse(new URL(url), TIME_OUT);
            Metadata metadata = new Metadata();
            HtmlDataExtractor extractor;

            //extract html version
            extractor = new VersionExtractor();
            metadata.setHtmlVersion((String)extractor.extract(doc));

            //extract title
            extractor = new TitleExtractor();
            metadata.setTitle((String)extractor.extract(doc));

            //extract header types
            extractor = new HeaderExtractor();
            metadata.setHeader((Map<String, Long>)extractor.extract(doc));

            //extract login form info
            extractor = new LoginInfoExtractor();
            metadata.setLogin((Boolean)extractor.extract(doc));

            //extract link info
            extractor = new LinkCountExtractor();
            metadata.setLinkCount((Map<LinkType, Integer>)extractor.extract(doc));

            resultsWrapper.setMetadata(metadata);
        } catch (IOException e) {
            log.error("Failed to get metadata for the url: " + url, e);
        }
        //TODO handle RunTimeException
        return resultsWrapper;
    }
}
