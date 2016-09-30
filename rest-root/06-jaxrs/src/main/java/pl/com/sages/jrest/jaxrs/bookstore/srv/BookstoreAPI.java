package pl.com.sages.jrest.jaxrs.bookstore.srv;

import io.swagger.annotations.*;
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

import org.jboss.resteasy.annotations.GZIP;

@Path("/bookstore")
@Api(value = "/bookstore", description="Costam z ksiegarnia")
@Produces({ "application/json" })
public interface BookstoreAPI {


    @GET
    @Path("/books")
    @ApiOperation(value = "Zwraca wszystkie ksiazki", notes = "Zwraca liste książek", response = Book.class, responseContainer = "list")
    public Collection<Book> getBooks();

    @GET
    @Path("/magazines")
    @Produces("text/plain")
    @ApiOperation(value = "Zwraca wszystkie magazyny ", notes = "Zwraca liste magazynow", response = Magazine.class, responseContainer = "list")
    public Collection<Magazine> getMagazines() ;

    @GET
    @Produces({ "application/xml" })
    @GZIP 
    @Path("/items")
    @ApiOperation(value = "Zwraca wszystko ", notes = "Zwraca liste całego stora", response = Item.class, responseContainer = "list" )
    public Collection<Item> getItems() ;

    @GET
    @Path("/books/{isbn}")
    @ApiOperation(value = "Zwraca ksiazke po isbn", notes = "Zwraca ksiazke albo byka", response = Book.class)
    @ApiResponses({ @ApiResponse(code = 404, message = "Nie ma takiej") })
    public Response getBook(
            @ApiParam(value = "podaj isbna", required = false)
            @Size(min = 1, max = 3)
            @PathParam("isbn") String id) ;

    @POST
    @Path("/books/{isbn}")
    @ApiOperation(value = "Dodaje nowa knige", notes = "Trzeba podac isbn i title", response = Book.class)
    public Book addBook(
            @ApiParam(value = "podaj isbna", required = true)
            @Size(min = 1, max = 3)
            @PathParam("isbn") String id,

            @ApiParam(value = "podaj title", required = true)
            @NotNull
            @QueryParam("title") String title) ;

    @PUT
    @Path("/books/{isbn}")
    @ApiOperation(value = "Zmienia tytul knidze", notes = "Trzeba podac isbn i title", response = Book.class)
    public Book updateBook(
            @ApiParam(value = "podaj isbna", required = true)
            @Size(min = 1, max = 3)
            @PathParam("isbn") String id,
            @ApiParam(value = "podaj title", required = true)
            @NotNull
            @FormParam("title") String title) ;

    @DELETE
    @Path("/books/{isbn}")
    @ApiOperation(value = "Usuwa knige ze stora", notes = "Trzeba podac isbn", response = Response.class)
    public Response removeBook(
            @ApiParam(value = "podaj isbna", required = true)
            @Size(min = 1, max = 3)
            @NotNull
            @PathParam("isbn") String id) ;
}