import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    enum HttpMethod {
        GET, POST, PUT, DELETE;
    }

    private final String m_url, m_body;
    private final HttpMethod m_method;
    public final Map<String, String> m_headers, m_queryParams;
    private final int m_timeout;
    private final boolean m_redirects;


    private HTTPRequest(String url, String body, HttpMethod method, int timeout, boolean redirects,
                        Map<String, String> headers, Map<String, String> queryParams) {
        m_url = url;
        m_method = method;
        m_headers = headers;
        m_queryParams = queryParams;
        m_body = body;
        m_timeout = timeout;
        m_redirects = redirects;
    }

//    public HTTPRequest addHeader(String key, String value) {
//        m_headers.put(key, value);
//        return this;
//    }
//
//    public HTTPRequest addQueryParam(String key, String value) {
//        m_queryParams.put(key, value);
//        return this;
//    }
//
//    public HTTPRequest body(String bodyDescription) {
//        m_body = bodyDescription;
//        return this;
//    }
//
//    public HTTPRequest timeout(int seconds) {
//        m_timeout = seconds;
//        return this;
//    }
//
//    public HTTPRequest followRedirects(boolean redirect) {
//        m_redirects = redirect;
//        return this;
//    }

    public static class Builder {
        String m_url, m_body;
        HttpMethod m_method;
        public Map<String, String> m_headers, m_queryParams;
        int m_timeout;
        boolean m_redirects;
        public Builder(String url, HttpMethod method) {
            m_url = url;
            m_method = method;
            m_timeout = 30;
            m_redirects = true;
            m_body = "";
            m_headers = new HashMap<>();
            m_queryParams = new HashMap<>();
        }

        public Builder addHeader(String key, String value) {
            m_headers.put(key, value);
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            m_queryParams.put(key, value);
            return this;
        }

        public Builder body(String bodyDescription) {
            m_body = bodyDescription;
            return this;
        }

        public Builder timeout(int seconds) {
            m_timeout = seconds;
            return this;
        }

        public Builder followRedirects(boolean redirect) {
            m_redirects = redirect;
            return this;
        }

        public HTTPRequest build() {
            if (m_timeout < 0)
                throw new IllegalArgumentException("Timeout cannot be negative.");
            if (m_url == null || m_url.isEmpty())
                throw new NullPointerException("URL cannot be Null or empty.");

            return new HTTPRequest(m_url, m_body, m_method, m_timeout, m_redirects,
            m_headers,  m_queryParams);
        }
    }
}
