package htmlanalyzer.parser;

import htmlanalyzer.parser.response.HtmlDataExtractor;
import htmlanalyzer.parser.response.LinkExtractor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class to retrieve a set of links
 */
public class LinkParser implements HtmlParser {

    private Log log = LogFactory.getLog(MetaDataParser.class);

    /**
     * Method retrieves a list of links from the given URL, sorts it and retrieves a sub-set of links starting from
     * the given offset value and a total of n elements equal to pageSize parameter.
     * @param request RequestWrapper containing request attributes
     * @return ResultsWrapper
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResultsWrapper parse(RequestWrapper request) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            Document doc = Jsoup.parse(new URL(request.getUrl()), TIME_OUT);
            //Extract links
            HtmlDataExtractor extractor = new LinkExtractor();
            List<String> links = (List<String>)extractor.extract(doc);

            //Sort links
            links.sort(Comparator.comparing(String::toString));
            int offset = request.getOffset();
            int size = request.getLimit();

            //Retrieve a subset of links
            if(offset < links.size()){ //offset and limit should always be smaller than the size of list
                int limit = offset + size;
                if(limit > links.size()){
                    limit = links.size();
                }
                links = links.subList(offset, limit);
            }else{
                links = new ArrayList<>(); //return a empty list
            }
            resultsWrapper.setLinks(links);
        } catch (IOException e) {
            log.error("Failed to get metadata for the url: " + request.getUrl(), e);
        }
        return resultsWrapper;
    }
}
