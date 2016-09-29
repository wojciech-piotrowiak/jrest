package pl.com.sages.jrest.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieMonsterSerwlet
 */
public class CookieMonsterSerwlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieMonsterSerwlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = null;
        String kiedy = "";
        if (request != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                cookie = cookies[0];
            }
            if (cookie != null) {
                kiedy = cookie.getValue();
            }
        }
         response.setHeader("Cache-Control", "no-cache");
        if (!kiedy.equals("")) {
            response.getWriter().write("<message>Welcome again! Date and time of your last visit: " + kiedy + " </message>");
            cookie.setValue("" + new Date());
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            response.getWriter().write("<message>Welcome! </message>");
            cookie = new Cookie("Cookie-monster", "" + new Date());
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

}
