package pl.com.sages.jrest.plainhttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Problemy:
 * - wszystko ręcznie
 * - parsowanie..
 * - mało czytelnie
 * - łatwo o błędy
 * - raj dla hackerów
 * - i co jeszcze?
 *
 * popróbować ze spacjami i innymi złymi formatami
 *
 * Wnioski?
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
            Boolean showDate = false;
            String format = "";

            String webServerAddress = s.getInetAddress().toString();
            System.out.println("New Connection:" + webServerAddress);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            request = in.readLine();
            while (request != null && !request.equals("")) {
                System.out.println("--- Client request: " + request);
                if (request.contains("/date")) {
                    showDate = true;
                    if (request.contains("?format=")) {
                        String[] strings = request.split("[?=\\s]");
                        for (int i = 0; i < strings.length; i++) {
                            System.out.println(strings[i]);
                            if (strings[i].contains("format")) {
                                format = strings[i + 1];
                            }
                        }
                        System.out.println("Found format: " + format);
                    }
                }
                request = in.readLine();
            }

            out = new PrintWriter(s.getOutputStream(), true);
            out.println("HTTP/1.1 200");
            out.println("Content-type: text/html");
            out.println("Server-name: myRESTserver");
            StringBuffer responseBuffer = new StringBuffer();
            responseBuffer.append("<html>\n");
            responseBuffer.append("<head>\n");
            responseBuffer.append("<title>My REST Server</title></head>\n");
            responseBuffer.append("<body>");
            responseBuffer.append("<h1>Hello from My REST Server!</h1>\n");
            if (showDate) {
                responseBuffer.append("<h3> Current server date:");
                if (format.equals("")) {
                    responseBuffer.append(new Date());
                } else {
                    responseBuffer.append(new SimpleDateFormat(format).format(new Date()));
                }
                responseBuffer.append("</h3>\n");
            }
            responseBuffer.append("</body>\n");
            responseBuffer.append("</html>\n");
            String response = responseBuffer.toString();
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