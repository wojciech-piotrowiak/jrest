package pl.com.sages.jrest.jackson.srv;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.com.sages.jrest.jackson.bookstore.Item;
import pl.com.sages.jrest.jackson.bookstore.Magazine;

public class JSONSerwlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/json; charset=utf-8");
		response.setHeader("Content-Encoding", "UTF-8");


		List<Magazine> subList = BookStoreBase.getMagazines();
		ObjectMapper om = new ObjectMapper();
		String valueAsString = om.writeValueAsString(subList);

		response.getWriter().write(valueAsString);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/json; charset=utf-8");
		response.setHeader("Content-Encoding", "UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");

		BufferedReader reader = request.getReader();
		String line = "";
		String result = "";
		while ((line = reader.readLine()) != null) {
			result = java.net.URLDecoder.decode(line, "UTF-8");
			System.out.println("Zdekodowany request" + result);
		}
		if (!result.equals("")) {
			ObjectMapper om = new ObjectMapper();
			Magazine magazine = om.readValue(result, Magazine.class);
			System.out.println("wczytano:" + magazine);

			BookStoreBase.addMagazine(magazine);
			

			String valueAsString = om.writeValueAsString(BookStoreBase.getMagazines());

			System.out.println("Odsyłam: "+valueAsString);
			response.getWriter().write(valueAsString);
		} else {
			response.getWriter().write("500");
		}

	}

}
