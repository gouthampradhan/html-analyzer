package htmlanalyzer.parser.response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class VersionExtractor implements HtmlDataExtractor {
    @Override
    public String extract(Document document) {
        List<String> list = document.childNodes().stream()
                .filter(x -> x instanceof DocumentType)
                .map(x -> x.attr("publicid"))
                .collect(Collectors.toList());
        return (list.isEmpty() || list.get(0).isEmpty()) ? "HTML 5.0" : list.get(0);
    }
}
