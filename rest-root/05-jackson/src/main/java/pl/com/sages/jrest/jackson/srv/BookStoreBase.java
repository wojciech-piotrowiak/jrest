package pl.com.sages.jrest.jackson.srv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pl.com.sages.jrest.jackson.Jacek;
import pl.com.sages.jrest.jackson.bookstore.Bookstore;
import pl.com.sages.jrest.jackson.bookstore.Item;
import pl.com.sages.jrest.jackson.bookstore.Magazine;

public class BookStoreBase {

	private static Bookstore bookstore;
	private static List<Item> items;

	private BookStoreBase() {
	}

	static {
		 ObjectMapper m2 = new ObjectMapper();
		try {
			    bookstore = m2.readValue(Jacek.class.getResourceAsStream("Bookstore.json"), Bookstore.class);
			   items=new ArrayList<Item>();
			   items.addAll(bookstore.getItems());
			 

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("wczytano:" + bookstore);

	}

	public static void addMagazine(Magazine magazine) {
		items.add(magazine);
	}

	public static List<Item> getItems() {
		return items;
	}

	public static List<Magazine> getMagazines() {
		List<Magazine> m = new ArrayList<>();
		for (Item item : items) {
			if (item instanceof Magazine)
				m.add((Magazine) item);
		}
		return m;
	}

}
