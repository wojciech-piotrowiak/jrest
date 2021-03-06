//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.29 at 04:22:55 PM CEST 
//


package pl.com.sages.jrest.jaxb.bookstore;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Month" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="Year" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="ISBN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Price" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title"
})
@XmlRootElement(name = "Magazine")
public class Magazine
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlAttribute(name = "Month")
    protected Byte month;
    @XmlAttribute(name = "Year")
    protected Short year;
    @XmlAttribute(name = "ISBN")
    protected String isbn;
    @XmlAttribute(name = "Price")
    protected Byte price;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setMonth(Byte value) {
        this.month = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setYear(Short value) {
        this.year = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISBN(String value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPrice(Byte value) {
        this.price = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle);
        }
        {
            Byte theMonth;
            theMonth = this.getMonth();
            strategy.appendField(locator, this, "month", buffer, theMonth);
        }
        {
            Short theYear;
            theYear = this.getYear();
            strategy.appendField(locator, this, "year", buffer, theYear);
        }
        {
            String theISBN;
            theISBN = this.getISBN();
            strategy.appendField(locator, this, "isbn", buffer, theISBN);
        }
        {
            Byte thePrice;
            thePrice = this.getPrice();
            strategy.appendField(locator, this, "price", buffer, thePrice);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Magazine)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Magazine that = ((Magazine) object);
        {
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle)) {
                return false;
            }
        }
        {
            Byte lhsMonth;
            lhsMonth = this.getMonth();
            Byte rhsMonth;
            rhsMonth = that.getMonth();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "month", lhsMonth), LocatorUtils.property(thatLocator, "month", rhsMonth), lhsMonth, rhsMonth)) {
                return false;
            }
        }
        {
            Short lhsYear;
            lhsYear = this.getYear();
            Short rhsYear;
            rhsYear = that.getYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear)) {
                return false;
            }
        }
        {
            String lhsISBN;
            lhsISBN = this.getISBN();
            String rhsISBN;
            rhsISBN = that.getISBN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "isbn", lhsISBN), LocatorUtils.property(thatLocator, "isbn", rhsISBN), lhsISBN, rhsISBN)) {
                return false;
            }
        }
        {
            Byte lhsPrice;
            lhsPrice = this.getPrice();
            Byte rhsPrice;
            rhsPrice = that.getPrice();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "price", lhsPrice), LocatorUtils.property(thatLocator, "price", rhsPrice), lhsPrice, rhsPrice)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle);
        }
        {
            Byte theMonth;
            theMonth = this.getMonth();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "month", theMonth), currentHashCode, theMonth);
        }
        {
            Short theYear;
            theYear = this.getYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear);
        }
        {
            String theISBN;
            theISBN = this.getISBN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "isbn", theISBN), currentHashCode, theISBN);
        }
        {
            Byte thePrice;
            thePrice = this.getPrice();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "price", thePrice), currentHashCode, thePrice);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
