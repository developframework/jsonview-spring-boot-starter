添加依赖包：

```xml
<dependency>
  <groupId>com.github.developframework</groupId>
  <artifactId>jsonview-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```

使用`@EnableJsonview`注解开启Jsonview功能

```java
@SpringBootApplication
@EnableJsonview
public class MyApplication {
	
  	public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

使用注解`@EnableJsonview`自动化完成对`JsonviewResponseReturnValueHandler`和`DataModelReturnValueHandler`的注册。在spring-boot的application.properties总配置项中可以使用

```properties
jsonview.locations=classpath*:jsonview/*.xml #指定扫描路径
jsonview.objectmapper.usedefault=true #采用默认的ObjectMapper对象
```
