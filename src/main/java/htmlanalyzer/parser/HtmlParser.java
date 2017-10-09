package htmlanalyzer.parser;

/**
 * Created by gouthamvidyapradhan on 07/10/2017.
 */
public interface HtmlParser {
    int TIME_OUT = 10000;
    ResultsWrapper parse(RequestWrapper request);
}
