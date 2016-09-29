package pl.com.sages.jrest.plainhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Zadanie:
 * 1. Zmianić klase, tak aby metoda invoke przyjmowała parametr format daty
 *    i wywoływała zdalną usługę z odpowiednim parametrem.
 */

public class JavaRESTClient {

    public static void invoke(String format) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://localhost:81/date?format="+format);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            System.out.println("Response Code:");
            System.out.println(connection.getResponseCode());
            System.out.println("Response Message:");
            System.out.println(connection.getResponseMessage());
            System.out.println("Headers:");
            System.out.println(connection.getHeaderFields());
            System.out.println("Response Entity:");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    public static void main(String[] args) {

        JavaRESTClient.invoke("YYYY");
    }

}
