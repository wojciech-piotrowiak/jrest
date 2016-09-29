package pl.com.sages.jrest.jaxrs.bookstore;

import java.util.List;

public class Bookstore {

    protected List<Item> items;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BookstoreAPI [items=" + items + "]";
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
