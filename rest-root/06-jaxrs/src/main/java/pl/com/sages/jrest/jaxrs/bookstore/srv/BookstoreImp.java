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
        for (Item item : bookstore) {
            if (item instanceof Book) {
                books.add((Book) item);
            }
        }
        return books;
    }

    @Override
    public Collection<Magazine> getMagazines() {
        Collection<Magazine> magazines = new ArrayList<>();
        for (Item item : bookstore) {
            if (item instanceof Magazine) {
                magazines.add((Magazine) item);
            }
        }
        return magazines;
    }

    @Override
    public Collection<Item> getItems() {
        return bookstore;
    }

    @Override
    public Response getBook(String id) {
        Book book = null;

        for (Item item : bookstore) {
            if (item instanceof Book) {
                book = (Book) item;
                if (book.getIsbn().equals(id)) {
                    return Response.status(200).entity(book).build();
                }
            }
        }
        return Response.status(404).entity("Nie ma takiej").build();
    }

    @Override
    public Book addBook(String id, String title) {
        Book book = new Book();
        book.setIsbn(id);
        book.setTitle(title);
        bookstore.add(book);
        return book;
    }

    @Override
    public Book updateBook(String id, String title) {
        Book book = null;
        for (Item item : bookstore) {
            if (item instanceof Book) {
                book = (Book) item;
                if (book.getIsbn().equals(id)) {
                    book.setTitle(title);
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public Response removeBook(String id) {

        Book book = null;
        for (Item item : bookstore) {
            if (item instanceof Book) {
                book = (Book) item;
                if (book.getIsbn().equals(id)) {
                    bookstore.remove(book);
                    return Response.status(200).entity(book).build();
                }
            }
        }
        return Response.status(404).entity("Nie ma takiej").build();
    }
}