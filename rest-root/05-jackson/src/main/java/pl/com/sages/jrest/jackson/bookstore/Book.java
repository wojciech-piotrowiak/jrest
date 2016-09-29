package pl.com.sages.jrest.jackson.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Book extends Item {

    protected String remark;
    protected String edition;

    List<Author> authors;

    public Book() {
        authors = new ArrayList<Author>();
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition
     *            the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors
     *            the authors to set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((authors == null) ? 0 : authors.hashCode());
        result = prime * result + ((edition == null) ? 0 : edition.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        if (authors == null) {
            if (other.authors != null) {
                return false;
            }
        } else if (!authors.equals(other.authors)) {
            return false;
        }
        if (edition == null) {
            if (other.edition != null) {
                return false;
            }
        } else if (!edition.equals(other.edition)) {
            return false;
        }
        if (remark == null) {
            if (other.remark != null) {
                return false;
            }
        } else if (!remark.equals(other.remark)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Book [remark=" + remark + ", edition=" + edition + ", authors=" + authors + "]";
    }

}
