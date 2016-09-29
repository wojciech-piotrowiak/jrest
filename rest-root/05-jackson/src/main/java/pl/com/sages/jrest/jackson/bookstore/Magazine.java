package pl.com.sages.jrest.jackson.bookstore;

public class Magazine extends Item {

    String month;
    String year;

    public Magazine() {
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month
     *            the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year
     *            the year to set
     */
    public void setYear(String year) {
        this.year = year;
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
        result = prime * result + ((month == null) ? 0 : month.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        Magazine other = (Magazine) obj;
        if (month == null) {
            if (other.month != null) {
                return false;
            }
        } else if (!month.equals(other.month)) {
            return false;
        }
        if (year == null) {
            if (other.year != null) {
                return false;
            }
        } else if (!year.equals(other.year)) {
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
        return "Magazine [month=" + month + ", year=" + year + "]";
    }

}
