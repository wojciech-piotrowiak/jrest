package pl.com.sages.jrest.jaxrs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.annotations.GZIP;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;


//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.annotations.GZIP;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/say")
public class Echo {

    @Context
    ServletContext servletContext;

    @GET
    @Path("/im/{who}")
    @GZIP
    public Response say(@PathParam("who") @Encoded String who,
                      @QueryParam("count")  String howMany,
                      @HeaderParam("User-Agent") String agent) {
        System.out.println("Who=" + who);
        System.out.println("count=" + howMany);
        StringBuilder something = new StringBuilder();
        something.append(who);
        try {
            if (howMany != null) {
                for (int i = 1; i < Integer.parseInt(howMany); i++) {
                    something.append(" ");
                    something.append(who);
                }
            }
        }catch (Exception e){
            return Response.status(400).entity("Zły int").language("pl").header("Content-Type", "text/json; charset=utf-8").encoding("UTF-8").build();
        }
        return Response.ok("I'm knight who say : " + something.toString() + "!! and your browser is:" + agent).build();
    }

    @GET
    @Path("/im/{who}")
    public Response say(@PathParam("who") String who) {
        System.out.println("Who=" + who);
        return Response.ok("I'm knight who say !: " + who + " z tej innej").build();
    }


    @POST
    @Path("/{who}")
    public Response echo(@PathParam("who") String who, @FormParam("what") String what) {
        return Response.ok("My name is " + who + " and I'm knight who say !: " + what).build();
    }

    @GET
    @Path("/image")
    @Produces("image/png")
    public Response getFile() {

        File file = new File("C:\\Java\\wrsp_JRest\\rest-root\\06-jaxrs\\src\\main\\webapp\\logo.png");
        ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=sages-logo.png");
        return response.build();

    }

    @GET
    @Path("/image2")
    @Produces("image/png")
    public Response getFile2() throws MalformedURLException {
        System.out.println(servletContext.getResource("/logo.png").getFile());
        File file = new File(servletContext.getResource("/logo.png").getFile());

        ResponseBuilder response = Response.ok(file);
        return response.build();

    }

    @GET
    @Path("/image3/{plik}")
    @Produces("image/png")
    public Response getFile3(@PathParam("plik") String plik) throws MalformedURLException {
        File file = new File(servletContext.getResource("/" + plik).getFile());

        ResponseBuilder response = Response.ok(file);
        return response.build();

    }

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) throws MalformedURLException {

        String uploadPath = servletContext.getResource("/").getFile();
        String fileName = "";

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get("file");

        for (InputPart inputPart : inputParts) {

            try {
                MultivaluedMap<String, String> header = inputPart.getHeaders();
                fileName = getFileName(header);

                InputStream inputStream = inputPart.getBody(InputStream.class, null);

                fileName = uploadPath + fileName;

                writeFile(inputStream, fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return Response.status(200).entity("Zaladowalem : " + fileName).build();

    }

    /**
     * Content-Disposition: form-data; name="file"; filename="aaa.PNG"
     **/
    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "lipajakas";
    }

    private void writeFile(InputStream inputStream, String fileName) throws IOException {
        FileOutputStream fop = new FileOutputStream(fileName);
        int readed = 0;
        while (readed >=0) {
            readed = inputStream.read();
            fop.write(readed);
            fop.flush();
        }
        fop.close();
    }

}
