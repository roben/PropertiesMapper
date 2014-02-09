package eu.rbecker.propertiesmapper;

import eu.rbecker.propertiesmapper.annotation.MappedProperty;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Becker <robert at rbecker.eu>
 */
public class PropertiesMapperTest {

    private class AnnotatedTestObject {

        @MappedProperty("test.String")
        private String testString;
        @MappedProperty("test.int")
        private int testPrimitiveInt;
        @MappedProperty("test.Integer")
        private Integer testInteger;
        @MappedProperty("test.long")
        private long testPrimitiveLong;
        @MappedProperty("test.Long")
        private Long testLong;
        @MappedProperty("test.float")
        private float testPrimitiveFloat;
        @MappedProperty("test.Float")
        private Float testFloat;
        @MappedProperty("test.double")
        private double testPrimitiveDouble;
        @MappedProperty("test.Double")
        private Double testDouble;
        @MappedProperty("test.boolean")
        private boolean testPrimitiveBoolean;
        @MappedProperty("test.Boolean")
        private Boolean testBoolean;

    }

    public PropertiesMapperTest() {
    }

    /**
     * Test of mapPropertiesToObject and mapObjectToProperties methods, of class PropertiesMapper.
     */
    @Test
    public void testPropertiesMapper() throws Exception {
        System.out.println("mapPropertiesToObject");
        Properties sourceProperties = createTestProperties();
        Properties targetProperties = new Properties();

        Object annotatedObject = new AnnotatedTestObject();
        // testPropertiesMapper p1 -> object
        PropertiesMapper.mapPropertiesToObject(sourceProperties, annotatedObject);
        // testPropertiesMapper object -> p2
        PropertiesMapper.mapObjectToProperties(annotatedObject, targetProperties);
        System.out.println("sourceProperties = " + sourceProperties);
        System.out.println("targetProperties = " + targetProperties);
        // compare p1 and p2
        if (!sourceProperties.equals(targetProperties)) {
            fail("Source and target properties are not equal!");
        }
    }

    private Properties createTestProperties() {
        Properties result = new Properties();
        result.setProperty("test.String", "hello");
        result.setProperty("test.int", String.valueOf(Integer.MAX_VALUE));
        result.setProperty("test.Integer", String.valueOf(Integer.MAX_VALUE));
        result.setProperty("test.long", String.valueOf(Long.MAX_VALUE));
        result.setProperty("test.Long", String.valueOf(Long.MAX_VALUE));
        result.setProperty("test.float", String.valueOf(Float.MAX_VALUE));
        result.setProperty("test.Float", String.valueOf(Float.MAX_VALUE));
        result.setProperty("test.Double", String.valueOf(Double.MAX_VALUE));
        result.setProperty("test.double", String.valueOf(Double.MAX_VALUE));
        result.setProperty("test.Boolean", String.valueOf(Boolean.FALSE));
        result.setProperty("test.boolean", String.valueOf(Boolean.FALSE));
        return result;
    }


}
