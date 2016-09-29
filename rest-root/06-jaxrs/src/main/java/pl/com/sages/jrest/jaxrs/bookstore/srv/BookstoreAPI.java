package pl.com.sages.jrest.jaxrs.bookstore.srv;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import pl.com.sages.jrest.jaxrs.bookstore.Book;
import pl.com.sages.jrest.jaxrs.bookstore.Item;
import pl.com.sages.jrest.jaxrs.bookstore.Magazine;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

public interface BookstoreAPI {


    public Collection<Book> getBooks();

    public Collection<Magazine> getMagazines() ;

    public Collection<Item> getItems() ;

    public Response getBook(
            String id) ;

    public Book addBook(
            String id,
            String title) ;

    public Book updateBook(
            String id,
            String title) ;

    public Response removeBook(
            String id) ;
}