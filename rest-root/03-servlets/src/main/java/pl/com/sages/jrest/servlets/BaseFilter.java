package pl.com.sages.jrest.servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseFilter implements Filter, Serializable {
    private static final long serialVersionUID = -446119629965179030L;

    private static final Logger LOG = LoggerFactory.getLogger(BaseFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        LOG.info("We/y init config={}", config);
    }

    @Override
    public void destroy() {
        LOG.info("We/y destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("We doFilter req={} resp={} chain={}", request, response, chain);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
        httpResponse.setHeader("Expires", "Fri, 12 Oct 2007 01:00:00 GMT");

        // takie tam
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getServletPath().endsWith(".xhtml")) {
            LOG.warn("Próba wejścia na " + httpRequest.getContextPath() + httpRequest.getServletPath());
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
        } else {
            chain.doFilter(request, response);
        }
        LOG.info("Wy doFilter");
    }

}
