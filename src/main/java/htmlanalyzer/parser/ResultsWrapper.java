package htmlanalyzer.parser;

import htmlanalyzer.parser.data.Metadata;

import java.util.List;


/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 * Simple wrapper object to wrap the response data
 */
public class ResultsWrapper {
    private Metadata metadata;
    private List<String> links;
    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
