PropertyMapper
==============

A java library to map the values from java.util.Properties objects to abitrary Object fields using annotations and reflection.

The library has no external dependencies and can be build using ant and Java 1.5.

Supported field types are String, Long, Integer, Double, Float, Boolean and their primitive equivalents.

Usage example (based on a simple TinkerForge configuration):

config.properties - A .properties file containing data:
```java
tinker.daemon.host=10.1.2.3
tinker.daemon.port=4223
tinker.display.uid=aa1
tinker.temperature.uid=bb2
```

TinkerConfig.java - An object to hold the property values
```java
public class TinkerConfig {
    @Property("tinker.daemon.host")
    private String brickDaemonHost;
    
    @Property("tinker.daemon.port")
    private Integer brickDaemonPort;
    
    @Property("tinker.temperature.uid")
    private String temperaturBrickletUid;
    
    @Property("tinker.display.uid")
    private String displayBrickletUid;
...
}
```

And finally, to map the contents of the properties file:
```java
Properties p = loadProperties(); // you still need to do this by yourself, don't care where the properties come from
PropertyMapper.mapProperties(p, myAnnotatedObject); // Values from the p are written to myConfigObject based on the @Property annotations

```
