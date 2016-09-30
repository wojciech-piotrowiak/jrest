package pl.com.sages.jrest.jaxrs.bookstore.srv;

import pl.com.sages.jrest.jaxrs.bookstore.Book;
import pl.com.sages.jrest.jaxrs.bookstore.Item;
import pl.com.sages.jrest.jaxrs.bookstore.Magazine;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.core.Response;

public class BookstoreImp implements BookstoreAPI {

    private static Collection<Item> bookstore = new ArrayList<>();

    static {
        Book book = new Book();
        book.setIsbn("1");
        book.setTitle("REST is Easy");
        bookstore.add(book);
        Magazine m = new Magazine();
        m.setIsbn("2");
        m.setTitle("Programista");
        bookstore.add(m);
    }

    @Override
    public Collection<Book> getBooks() {
        Collection<Book> books = new ArrayList<>();
        return books;
    }

    @Override
    public Collection<Magazine> getMagazines() {
        Collection<Magazine> magazines = new ArrayList<>();
        return magazines;
    }

    @Override
    public Collection<Item> getItems() {
        return bookstore;
    }

    @Override
    public Response getBook(String id) {
        Book book = null;

        return null;
    }

    @Override
    public Book addBook(String id, String title) {
        Book book = null;
        return book;
    }

    @Override
    public Book updateBook(String id, String title) {
        Book book = null;
        return null;
    }

    @Override
    public Response removeBook(String id) {

        Book book = null;
        return null;
    }
}