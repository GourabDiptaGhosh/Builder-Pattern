import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    enum HttpMethod {
        GET, POST, PUT, DELETE;
    }

    String m_url, m_body;
    HttpMethod m_method;
    Map<String, String> m_headers, m_queryParams;
    int m_timeout;
    boolean m_redirects;


    public HTTPRequest(String url, HttpMethod method) {
        m_url = url;
        m_method = method;
        m_headers = new HashMap<>();
        m_queryParams = new HashMap<>();
        m_body = "";
        m_timeout = 30;
        m_redirects = true;
    }

    public HTTPRequest addHeader(String key, String value) {
        m_headers.put(key, value);
        return this;
    }

    public HTTPRequest addQueryParam(String key, String value) {
        m_queryParams.put(key, value);
        return this;
    }

    public HTTPRequest body(String bodyDescription) {
        m_body = bodyDescription;
        return this;
    }

    public HTTPRequest timeout(int seconds) {
        m_timeout = seconds;
        return this;
    }

    public HTTPRequest followRedirects(boolean redirect) {
        m_redirects = redirect;
        return this;
    }
}
