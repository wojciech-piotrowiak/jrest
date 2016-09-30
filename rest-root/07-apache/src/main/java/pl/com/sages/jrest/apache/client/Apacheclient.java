package pl.com.sages.jrest.apache.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class Apacheclient {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/jaxrs/rest/bookstore/books/1");
        CloseableHttpResponse response = httpclient.execute(httpGet);

        try {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);
        } finally {
            response.close();
        }

        HttpPut httpPut = new HttpPut("http://localhost:8080/jaxrs/rest/bookstore/books/3");
        HttpParams params = httpPut.getParams();
        params.setParameter("title", "W pustyni i w Puszczy");
        httpPut.setParams(params);
        response = httpclient.execute(httpPut);

        try {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);
        } finally {
            response.close();
        }

    }

}
