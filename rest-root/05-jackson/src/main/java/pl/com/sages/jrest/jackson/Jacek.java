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

        //System.out.println("wczytano:" + item);

        // Zapisanie obiektu do JSON
        System.out.println("zapisano:");
        Magazine value = new Magazine();
        value.setIsbn("6");
        value.setMonth("10");
        value.setYear("2015");
        value.setTitle("Programista");
        //System.out.println(out);

        //System.out.println("wczytano:" + item2);

        // Utworzenie "reczne"(strumieniowe) JSON i zapisanie
        System.out.println("zapisano strumieniowo:");
//        g.writeEndObject();
//        g.close();

    }
}
