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

@Path("/bookstore")
@Produces({ "application/json" })
public interface BookstoreAPI {


    @GET
    @Path("/books")
    public Collection<Book> getBooks();

    @GET
    @Path("/magazines")
    @Produces("text/plain")
    public Collection<Magazine> getMagazines() ;

    @GET
    @Produces({ "application/xml" })//@GZIP @Cache
    @Path("/items")
    public Collection<Item> getItems() ;

    @GET
    @Path("/books/{isbn}")
    public Response getBook(
            @PathParam("isbn") String id) ;

    @POST
    @Path("/books/{isbn}")
    public Book addBook(
            @PathParam("isbn") String id,
            @QueryParam("title") String title) ;

    @PUT
    @Path("/books/{isbn}")
    public Book updateBook(
            @PathParam("isbn") String id,
            @FormParam("title") String title) ;

    @DELETE
    @Path("/books/{isbn}")
    public Response removeBook(
            @PathParam("isbn") String id) ;
}