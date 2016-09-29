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

    

    }
}