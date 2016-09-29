package pl.com.sages.jrest.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.com.sages.jrest.jackson.bookstore.Bookstore;
import pl.com.sages.jrest.jackson.bookstore.Item;
import pl.com.sages.jrest.jackson.bookstore.Magazine;

public class Jacek {
    public static void main(String[] args) throws IOException {
        // Wczytanie JSON do obiektu
        String json = "{\"type\":\"Book\", \"title\":\"Jacek i Placek\",\"isbn\":5}";
        ObjectMapper m = new ObjectMapper();
        Item item = m.readValue(json, Item.class);
        System.out.println("wczytano:" + item);

        // Zapisanie obiektu do JSON
        System.out.println("zapisano:");
        Magazine value = new Magazine();
        value.setIsbn("6");
        value.setMonth("10");
        value.setYear("2015");
        value.setTitle("Programista");
        String out = m.writeValueAsString(value);
        System.out.println(out);

        ObjectMapper m2 = new ObjectMapper();
        Bookstore item2 = m2.readValue(Jacek.class.getResourceAsStream("Bookstore.json"), Bookstore.class);
        System.out.println("wczytano:" + item2);

        // Utworzenie "reczne"(strumieniowe) JSON i zapisanie
        System.out.println("zapisano strumieniowo:");
        JsonFactory f = new JsonFactory();
        JsonGenerator g = f.createJsonGenerator(System.out);
        g.writeStartObject();
        g.writeStringField("title", "Jacek i Placek");
        g.writeNumberField("isbn", 5);
        g.writeArrayFieldStart("authors");
        g.writeStartObject();
        g.writeStringField("name", "Jacek");
        g.writeEndObject();
        g.writeStartObject();
        g.writeStringField("name", "Placek");
        g.writeEndObject();
        g.writeEndArray();
        g.writeEndObject();
        g.close();

    }
}
