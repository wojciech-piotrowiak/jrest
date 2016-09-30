package pl.com.sages.jrest.jaxrs;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.util.List;
//import java.util.Map;

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
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.ResponseBuilder;

//import org.jboss.resteasy.annotations.GZIP;
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class Echo {


    public String say(String who,
                      String howMany,
                      String agent) {
        System.out.println("Who=" + who);
        System.out.println("count=" + howMany);
        StringBuilder something = new StringBuilder();
        something.append(who);
        if (howMany != null) {
            for (int i = 1; i < Integer.parseInt(howMany); i++) {
                something.append(" ");
                something.append(who);
            }
        }
        return "I'm knight who say : " + something.toString() + "!! and your browser is:" + agent;
    }

    public String say(String who) {
        System.out.println("Who=" + who);
        return "I'm knight who say !: " + who + " z tej innej";
    }

    public String echo(String who, String what) {
        return "My name is " + who + " and I'm knight who say !: " + what;
    }

}
