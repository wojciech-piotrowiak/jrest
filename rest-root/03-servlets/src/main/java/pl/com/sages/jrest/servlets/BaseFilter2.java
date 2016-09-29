package pl.com.sages.jrest.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class BaseFilter2 implements Filter, Serializable {
    private static final long serialVersionUID = -446119629965179030L;

    private static final Logger LOG = LoggerFactory.getLogger(BaseFilter2.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        LOG.info("We/y init2 config={}", config);
    }

    @Override
    public void destroy() {
        LOG.info("We/y2 destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("We doFilter2 req={} resp={} chain={}", request, response, chain);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.addHeader("Cache-Control", "dziwne cos");

            chain.doFilter(request, response);
        LOG.info("Wy doFilter2");
    }

}
