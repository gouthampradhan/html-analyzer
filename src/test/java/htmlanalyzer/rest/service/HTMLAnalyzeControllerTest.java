package htmlanalyzer.rest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gouthamvidyapradhan on 08/10/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HTMLAnalyzeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHtmlTitle() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://commons.apache.org/proper/commons-logging/guide.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Apache Commons Logging - User Guide"));
    }

    @Test
    public void testHtmlLoginForm() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://github.com/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hasLogin").value(true));
    }

    @Test
    public void testHtmlNoLoginForm() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://commons.apache.org/proper/commons-logging/guide.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hasLogin").value(false));
    }

    @Test
    public void testHtmlVersion5() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://github.com/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.htmlVersion").value("HTML 5.0"));
    }

    @Test
    public void testHtmlVersion4() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=http://www.htmlhelp.com/reference/html40/structure.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.htmlVersion").value("-//W3C//DTD HTML 4.01//EN"));
    }

    @Test
    public void testHtmlHeaders() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://commons.apache.org/proper/commons-logging/guide.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.h1Count").isNotEmpty())
                .andExpect(jsonPath("$.h2Count").isNotEmpty())
                .andExpect(jsonPath("$.h3Count").isNotEmpty())
                .andExpect(jsonPath("$.h4Count").isNotEmpty())
                .andExpect(jsonPath("$.h5Count").isNotEmpty())
                .andExpect(jsonPath("$.h6Count").isNotEmpty());
    }

    @Test
    public void testHtmlLinkCount() throws Exception {
        this.mockMvc.perform(get("/rest/metadata?url=https://commons.apache.org/proper/commons-logging/guide.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.internalLinks").isNotEmpty())
                .andExpect(jsonPath("$.externalLinks").isNotEmpty());
    }


}