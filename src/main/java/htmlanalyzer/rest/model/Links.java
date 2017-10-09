package htmlanalyzer.rest.model;

import java.util.List;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 * Java POJO to be marshaled as JSON response
 */
public class Links<T> {
    private List<T> links;

    public List<T> getLinks() {
        return links;
    }

    public void setLinks(List<T> links) {
        this.links = links;
    }
}
