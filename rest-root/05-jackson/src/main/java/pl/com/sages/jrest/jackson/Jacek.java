package pl.com.sages.jrest.jackson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.com.sages.jrest.jackson.bookstore.Bookstore;
import pl.com.sages.jrest.jackson.bookstore.Item;
import pl.com.sages.jrest.jackson.bookstore.Magazine;
import pl.com.sages.jrest.jackson.srv.BookStoreBase;

public class Jacek {
    public static void main(String[] args) throws IOException {
        // Wczytanie JSON do obiektu
       // String json = "{\"type\":\"Book\", \"title\":\"Jacek i Placek\",\"isbn\":5}";
        //JsonFactory f=new JsonFactory();
       
   /* JsonParser createJsonParser = f.createJsonParser(json.getBytes());
    createJsonParser.nextToken();
    while (createJsonParser.nextToken()!=JsonToken.END_OBJECT)
    {
    	System.out.println(createJsonParser.getCurrentName());
    	createJsonParser.nextToken();
    }
    createJsonParser.close();*/
    
   // ObjectMapper m=new ObjectMapper();
   /* JsonNode root=m.readTree(json.getBytes());
    System.out.println("Title: "+root.get("title"));*/

        //System.out.println("wczytano:" + item);

        // Zapisanie obiektu do JSON
      /*  System.out.println("zapisano:");
        Magazine value = new Magazine();
        value.setIsbn("6");
        value.setMonth("10");
        value.setYear("2015");
        value.setTitle("Programista");
        
        m.writeValue(System.out,value);*/
        //System.out.println(out);

        //System.out.println("wczytano:" + item2);

        // Utworzenie "reczne"(strumieniowe) JSON i zapisanie
    
    	// part3(m);
        //part4();
     
     
        System.out.println("getItems" +BookStoreBase.getItems());
        System.out.println("getMagazines" + BookStoreBase.getMagazines());
        
        Magazine mg=new Magazine();
        mg.setIsbn("111");
        System.out.println("getMagazines count" + BookStoreBase.getMagazines().size());
        BookStoreBase.addMagazine(mg);
        System.out.println("getMagazines count" + BookStoreBase.getMagazines().size());
        
        
       

    }

	private static void part4() throws IOException {
		
		 JsonFactory f=new JsonFactory();
		 JsonGenerator g=f.createJsonGenerator(new File("book.json"),JsonEncoding.UTF8);
		 g.writeStartObject();
		 g.writeStringField("title", "Jaś wędrowniczek");
		 g.writeEndObject();
	        g.close();
	        System.out.println("zapisano strumieniowo:");
	}

	private static void part3(ObjectMapper m) throws IOException,
			JsonProcessingException {
		 ObjectMapper m2 = new ObjectMapper();
	        Bookstore item2 = m2.readValue(Jacek.class.getResourceAsStream("Bookstore.json"), Bookstore.class);
	System.out.println("wczytano:" + item2);
       /* createJsonParser.nextToken();
        while (createJsonParser.nextToken()!=JsonToken.END_OBJECT)
        {
        	System.out.println(createJsonParser.getCurrentName());
        	createJsonParser.nextToken();
        }
        createJsonParser.close();*/
	}
}
