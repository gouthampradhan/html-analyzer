package htmlanalyzer.rest.service;

import htmlanalyzer.parser.HtmlParser;
import htmlanalyzer.parser.MetaDataParser;
import htmlanalyzer.parser.ResultsWrapper;
import htmlanalyzer.parser.data.LinkType;
import htmlanalyzer.rest.model.MetaData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class HTMLAnalyzeController {

    private Log log = LogFactory.getLog(HTMLAnalyzeController.class);

    @RequestMapping("/rest/metadata")
    public MetaData metadata(@RequestParam(value="url", defaultValue="http://") String url) {
        log.info("Retrieving metadata for url: " + url);
        HtmlParser parser = new MetaDataParser();
        MetaData metadata = new MetaData();
        ResultsWrapper resultsWrapper = parser.parse(url);
        if(resultsWrapper.getMetadata() != null){
            metadata.setHtmlVersion(resultsWrapper.getMetadata().getHtmlVersion());
            metadata.setTitle(resultsWrapper.getMetadata().getTitle());
            Map<String, Long> header = resultsWrapper.getMetadata().getHeader();
            if(header != null){
                metadata.setH1Count(header.get("h1") != null ? header.get("h1").intValue() : 0);
                metadata.setH2Count(header.get("h2") != null ? header.get("h2").intValue() : 0);
                metadata.setH3Count(header.get("h3") != null ? header.get("h3").intValue() : 0);
                metadata.setH4Count(header.get("h4") != null ? header.get("h4").intValue() : 0);
                metadata.setH5Count(header.get("h5") != null ? header.get("h5").intValue() : 0);
                metadata.setH6Count(header.get("h6") != null ? header.get("h6").intValue() : 0);
            }
            metadata.setHasLogin(resultsWrapper.getMetadata().isLogin());
            Map<LinkType, Integer> links = resultsWrapper.getMetadata().getLinkCount();
            if(links != null){
                metadata.setInternalLinks(links.get(LinkType.INTERNAL) != null ? links.get(LinkType.INTERNAL) : 0);
                metadata.setExternalLinks(links.get(LinkType.EXTERNAL) != null ? links.get(LinkType.EXTERNAL) : 0);
            }
        }
        return metadata;
    }
}
