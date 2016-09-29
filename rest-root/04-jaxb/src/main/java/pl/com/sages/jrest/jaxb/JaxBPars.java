package pl.com.sages.jrest.jaxb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pl.com.sages.jrest.jaxb.bookstore.Author;
import pl.com.sages.jrest.jaxb.bookstore.Bookstore;
import pl.com.sages.jrest.jaxb.bookstore.Magazine;
import pl.com.sages.jrest.jaxb.bookstore.ObjectFactory;

public class JaxBPars {
    public static void main(String[] args) throws JAXBException, IOException {
        ObjectFactory of = new ObjectFactory();
        Author a = of.createAuthor();
        a.setFirstName("Karol");
        a.setLastName("Maj");
        Bookstore b = of.createBookstore();
        Magazine ma = of.createMagazine();
        ma.setISBN("2345");
        ma.setMonth((byte) 2);
        ma.setTitle("Pani Domu");
        ma.setYear((short) 2015);
        b.getMagazine().add(ma);
        JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(b, System.out);

        JAXBContext jaxbContext2 = JAXBContext.newInstance(Magazine.class);
        Marshaller m2 = jaxbContext2.createMarshaller();
        m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m2.marshal(ma, System.out);

        JAXBContext jaxbContext3 = JAXBContext.newInstance(Author.class);
        Marshaller m3 = jaxbContext3.createMarshaller();
        m3.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m3.marshal(a, System.out);

        // unmarszaling
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        // InputStream is =
        // ClassLoader.getSystemResourceAsStream("Bookstore.xml");
        InputStream is = JaxBPars.class.getResourceAsStream("Bookstore.xml");

        Bookstore booktore = (Bookstore) unmarshaller.unmarshal(is);
        System.out.println(booktore.getMagazine());

        String xml = "<Author xmlns=\"http://www.sages.com.pl/jrest/jaxb\"><First_Name>Karol</First_Name><Last_Name>Maj</Last_Name></Author>";
        InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        Author autor = (Author) unmarshaller.unmarshal(stream);
        System.out.println(autor);

    }
}