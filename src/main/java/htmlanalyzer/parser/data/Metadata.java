package htmlanalyzer.parser.data;

import java.util.Map;

/**
 * Data response object to populate HTML Metadata information
 */
public class Metadata{
    //Html version
    private String htmlVersion;

    //HTML title
    private String title;

    //Map of header type and count
    private Map<String, Long> header;

    //Flag indicating if the page has a login form or not
    private boolean login;

    //Map of LinkType and total count of each links
    private Map<LinkType, Integer> linkCount;

    public String getHtmlVersion() {
        return htmlVersion;
    }

    public void setHtmlVersion(String htmlVersion) {
        this.htmlVersion = htmlVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Long> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Long> header) {
        this.header = header;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Map<LinkType, Integer> getLinkCount() {
        return linkCount;
    }

    public void setLinkCount(Map<LinkType, Integer> linkCount) {
        this.linkCount = linkCount;
    }
}
