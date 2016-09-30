package pl.com.sages.jrest.jaxrs.bookstore.srv;

import pl.com.sages.jrest.jaxrs.bookstore.Book;
import pl.com.sages.jrest.jaxrs.bookstore.Item;
import pl.com.sages.jrest.jaxrs.bookstore.Magazine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/store")
@Produces({"application/json"})
public class BookstoreImp implements BookstoreAPI {

    private static Collection<Item> bookstore = new ArrayList<>();

    static {
        Book book = new Book();
        book.setIsbn("1");
        book.setTitle("REST is Easy");
        
        Book book2 = new Book();
        book2.setIsbn("3");
        book2.setTitle("REST is almost Easy");
        bookstore.add(book);
        bookstore.add(book2);
        Magazine m = new Magazine();
        m.setIsbn("2");
        m.setTitle("Programista");
        bookstore.add(m);
    }

    @Override
    @Path("/books")
    @GET
    public Collection<Book> getBooks() {
    	return bookstore.stream().filter(item->item instanceof Book).map(item->(Book)item).collect(Collectors.toList());
    }

    @Override
    @Path("/magazines")
    @Produces("text/plain")
    @GET
    public Collection<Magazine> getMagazines() {
    	return bookstore.stream().filter(item->item instanceof Magazine).map(item->(Magazine)item).collect(Collectors.toList());
    }

    @Override
    public Collection<Item> getItems() {
        return bookstore;
    }

    @Override
    @Path("/books/{isbn}")
    @GET
    public Response getBook(@PathParam("isbn") String id) {
    	Optional<Item> findFirst = bookstore.stream().filter(item-> (item instanceof Book)&&id.contentEquals(item.getIsbn())).findFirst();
    	if(findFirst.isPresent())
		return Response.ok(findFirst.get()).build();
    	else
    		return Response.status(404).build();
    }

    @Override
    @Path("/books/{isbn}")
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