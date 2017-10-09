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
 * Class to retrieve metadata information of the html page. Metadata information includes html version,
 * html title, heading types, login info and count of internal and external links
 */
public class MetaDataParser implements HtmlParser {

    private Log log = LogFactory.getLog(MetaDataParser.class);

    /**
     * Method retrieves the meta-data information of a given html page.
     * @param request RequestWrapper containing request attributes
     * @return ResultsWrapper
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResultsWrapper parse(RequestWrapper request) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            Document doc = Jsoup.parse(new URL(request.getUrl()), TIME_OUT);
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
            log.error("Failed to get metadata for the url: " + request.getUrl(), e);
        }
        return resultsWrapper;
    }
}
