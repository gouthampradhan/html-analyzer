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
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class LinkParser implements HtmlParser {

    private Log log = LogFactory.getLog(MetaDataParser.class);

    @Override
    @SuppressWarnings("unchecked")
    public ResultsWrapper parse(RequestWrapper request) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            Document doc = Jsoup.parse(new URL(request.getUrl()), TIME_OUT);
            HtmlDataExtractor extractor = new LinkExtractor();
            List<String> links = (List<String>)extractor.extract(doc);
            links.sort(Comparator.comparing(String::toString));
            int offset = request.getOffset();
            int size = request.getLimit();
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
        //TODO handle RunTimeException
        return resultsWrapper;
    }
}
