package eu.rbecker.propertiesmapper.annotation;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Robert Becker <robert at rbecker.eu>
 */
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MappedProperty {
    String value();
}
