## Project for simple JAVA Fundamentals

####Maven Execute plugin (*exec-maven-plugin*)
```
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>1.2.1</version>
            <executions>
                <execution>
                    <id>first-execution</id>
                    <goals>
                        <goal>java</goal>
                    </goals>
                    <configuration>
                        <mainClass>com.mycompany.FooServer</mainClass>
                    </configuration>
                </execution>
                <execution>
                    <id>second-execution</id>
                    <goals>
                        <goal>java</goal>
                    </goals>
                    <configuration>
                        <mainClass>com.mycompany.BarServer</mainClass>
                    </configuration>
                </execution>
            </executions>
        </plugin>
</build> 
```
To Execute with above configuration 
``` mvn exec:java@first-execution ``` or ```mvn exec:java@second-execution```
