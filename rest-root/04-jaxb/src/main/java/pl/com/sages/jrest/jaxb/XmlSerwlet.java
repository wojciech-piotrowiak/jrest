package pl.com.sages.jrest.jaxb;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pl.com.sages.jrest.jaxb.bookstore.Bookstore;
import pl.com.sages.jrest.jaxb.bookstore.ObjectFactory;

/**
 * Servlet implementation class CookieMonsterSerwlet
 */
public class XmlSerwlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XmlSerwlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JAXBContext jaxbContext;
        try {
            // response.setHeader("Content-Type", "text/xml");
            response.setHeader("Content-Type", "text/xml; charset=utf-8");
            response.setHeader("Content-Encoding", "UTF-8");

            jaxbContext = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream is = JaxBPars.class.getResourceAsStream("Bookstore.xml");

            Bookstore booktore = (Bookstore) unmarshaller.unmarshal(is);

            // slabo
            // JAXBContext jaxbContext2 =
            // JAXBContext.newInstance(Magazine.class);
            // Marshaller m2 = jaxbContext2.createMarshaller();
            // m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // m2.setProperty("jaxb.fragment", true);
            // m2.marshal(booktore.getMagazine().get(0), response.getWriter());
            // m2.marshal(booktore.getMagazine().get(1), response.getWriter());

            Marshaller m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            ObjectFactory of = new ObjectFactory();
            Bookstore newBS = of.createBookstore();
            newBS.getMagazine().addAll(booktore.getMagazine());
            m.marshal(newBS, response.getWriter());

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
