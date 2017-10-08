package htmlanalyzer.parser.response;

import com.google.common.net.InternetDomainName;
import htmlanalyzer.parser.data.LinkType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Document;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
public class LinkCountExtractor implements HtmlDataExtractor {
    private Log log = LogFactory.getLog(LinkCountExtractor.class);

    @Override
    public Map<LinkType, Integer> extract(Document document) {
        Map<LinkType, Integer> map = new HashMap<>();
        List<String> links = LinkExtractorHelper.extract(document);
        for(String link : links){
            matchAndUpdate(map, link, document);
        }
        return map;
    }

    private void matchAndUpdate(Map<LinkType, Integer> map, String link, Document doc){
        try {
            String hostDomain = InternetDomainName.from(new URL(doc.location()).getHost()).topPrivateDomain().toString();
            String linkDomain = InternetDomainName.from(new URL(link).getHost()).topPrivateDomain().toString();
            if(hostDomain.equals(linkDomain)){
                Integer v = map.get(LinkType.INTERNAL);
                if(v == null){
                    v = 0;
                }
                map.put(LinkType.INTERNAL, v + 1);
            } else{
                Integer v = map.get(LinkType.EXTERNAL);
                if(v == null){
                    v = 0;
                }
                map.put(LinkType.EXTERNAL, v + 1);
            }
        }catch (Exception e){
            log.error("Exception occurred while parsing links", e);
        }
    }

}
