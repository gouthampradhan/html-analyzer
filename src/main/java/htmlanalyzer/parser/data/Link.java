package htmlanalyzer.parser.data;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public class Link {
    private String link;
    private boolean isReachable;
    private boolean isExternal;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isReachable() {
        return isReachable;
    }

    public void setReachable(boolean reachable) {
        isReachable = reachable;
    }

    public boolean isExternal() {
        return isExternal;
    }

    public void setExternal(boolean external) {
        isExternal = external;
    }
}
