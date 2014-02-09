/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.rbecker.propertymapper;

import eu.rbecker.propertymapper.annotation.Property;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Becker <robert at rbecker.eu>
 */
public class PropertiesMapperTest {

    private class AnnotatedTestObject {

        @Property("test.String")
        private String testString;
        @Property("test.int")
        private int testPrimitiveInt;
        @Property("test.Integer")
        private Integer testInteger;
        @Property("test.long")
        private long testPrimitiveLong;
        @Property("test.Long")
        private Long testLong;
        @Property("test.float")
        private float testPrimitiveFloat;
        @Property("test.Float")
        private Float testFloat;
        @Property("test.double")
        private double testPrimitiveDouble;
        @Property("test.Double")
        private Double testDouble;
        @Property("test.boolean")
        private boolean testPrimitiveBoolean;
        @Property("test.Boolean")
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
