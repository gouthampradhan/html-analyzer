package htmlanalyzer.parser;

import htmlanalyzer.parser.data.Link;
import htmlanalyzer.parser.data.Metadata;

import java.util.List;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class ResultsWrapper {
    private Metadata metadata;
    private List<Link> links;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
