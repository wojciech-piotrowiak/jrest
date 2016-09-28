package pl.com.sages.jrest.plainhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Zadanie:
 * 1. Zmianić program by reagował na scieżkę /date i zwracał klientowi dodatkow aktualną datę serwera
 * 2. Dodać obsługę parametru (metody GET) o nazwie format, aby klient mogł okreslić jak ma wygladać odpowiedź.
 *    Hint,przyda się StringBuffer oraz metody split i contains z klasy String ;)
 */
public class JavaRESTServer {

    private static final int fNumberOfThreads = 100;
    private static final Executor fThreadPool = Executors.newFixedThreadPool(fNumberOfThreads);

    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(81)) {
            while (true) {
                final Socket connection = socket.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        HandleRequest(connection);
                    }
                };
                fThreadPool.execute(task);
            }
        }
    }

    private static void HandleRequest(Socket s) {
        try {
            BufferedReader in;
            PrintWriter out;
            String request;

            String webServerAddress = s.getInetAddress().toString();
            System.out.println("New Connection:" + webServerAddress);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            request = in.readLine();
            while (request != null && !request.equals("")) {
                System.out.println("--- Client request: " + request);
                request = in.readLine();
            }

            out = new PrintWriter(s.getOutputStream(), true);
            out.println("HTTP/1.1 200");
            out.println("Content-type: text/html");
            out.println("Server-name: myRESTserver");
            String response = "<html>\n" + "<head>\n" + "<title>My REST Server</title></head>\n" + "<h1>Hello from My REST Server!</h1>\n" + "</html>\n";
            out.println("Content-length: " + response.length());
            out.println("");
            out.println(response);
            out.flush();
            out.close();
            s.close();
        } catch (IOException e) {
            System.out.println("Failed respond to client request: " + e.getMessage());
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }

}
