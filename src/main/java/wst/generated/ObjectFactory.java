
package wst.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the namespace.webservice._new package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FieldAge_QNAME = new QName("http://new.webservice.namespace", "age");
    private final static QName _FieldWeight_QNAME = new QName("http://new.webservice.namespace", "weight");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: namespace.webservice._new
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://new.webservice.namespace", name = "age", scope = Field.class)
    public JAXBElement<Integer> createFieldAge(Integer value) {
        return new JAXBElement<Integer>(_FieldAge_QNAME, Integer.class, Field.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://new.webservice.namespace", name = "weight", scope = Field.class)
    public JAXBElement<Integer> createFieldWeight(Integer value) {
        return new JAXBElement<Integer>(_FieldWeight_QNAME, Integer.class, Field.class, value);
    }

}
