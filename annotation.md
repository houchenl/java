
# 注解

注解就像标签，为代码添加解释说明，并可提供数据。  
其它地方通过代码的注解，可以了解代码功能，并且通过注解内容，可以获得额外信息。  

## 定义注解

使用 `@interface` 定义注解。  
```java
public @interface MyAnnotation { }
```

### 元注解
元注解是 `jdk` 中内置的注解类型，来用解释说明其它注解，通常是自定义注解。  
元注解有五种：`@Retention`、`@Documented`、`@Target`、`@Inherited`、`@Repeatable`  

**@Retention**  
`@Retention` 解释说明注解的存续时间：  
* `RetentionPolicy.SOURCE` 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视
* `RetentionPolicy.CLASS` 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中
* `RetentionPolicy.RUNTIME` 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们

**@Target**  
指定了注解运用的地方。当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。  
@Target 有下面的取值：  
* `ElementType.ANNOTATION_TYPE`: 可以给一个注解进行注解
* `ElementType.CONSTRUCTOR`: 可以给构造方法进行注解
* `ElementType.FIELD`: 可以给属性进行注解
* `ElementType.LOCAL_VARIABLE`: 可以给局部变量进行注解
* `ElementType.METHOD`: 可以给方法进行注解
* `ElementType.PACKAGE`: 可以给一个包进行注解
* `ElementType.PARAMETER`: 可以给一个方法内的参数进行注解
* `ElementType.TYPE`: 可以给一个类型进行注解，比如类、接口、枚举

**@Inherited**  
Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。  
```java
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface Test {}

@Test
public class A {}

public class B extends A {}
```
注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。  

### 注解的属性
注解只有属性，没有方法。注解的属性在定义时以“无形参的方法”形式进行声明，方法名定义了该属性的名字，返回值定义了该属性的类型。  
```java
public @interface Test {
    int id();
    String msg();
    RetentionPolicy value();
    ElementType[] value();
}
```

属性可以使用default定义默认值。  
```java
public @interface Test {
    int id() default -1;
    String value() default "message";
}
```

## 使用注解

注解的没有默认值的属性，在使用时，必须为其指定值。有默认值的属性，可以不为其指定值，也可以指定。  
```java
@interface Test {
    int id();
    String msg() default "default";
}

@Test(msg="client")
class Client {

}
```

如果注解的属性都有默认值，或者注解没有属性，可以直接使用注解名，不为属性指定值。 `@Test` 或 `@Test()`   
```java
@interface Test {
    int id() default -1;
    String msg() default "default";
}

@Test
class Client {

}
```

如果注解属性只有value，使用时可以直接指定值，不指定属性名。  
```java
public @interface Test {
    String value();
}

@Test("client")
public class Client {

}
```

## 提取注解内容
获取代码上使用的注解中的内容，使用3个方法：  

`isAnnotationPresent()` 判断代码是否添加了某注解  
```java
boolean isAnnotationPresent = Client.class.isAnnotationPresent(MyTypeAnnotation.class);
```

`getAnnotation()` 获取注解的实例  
```java
MyTypeAnnotation annotation = Client.class.getAnnotation(MyTypeAnnotation.class);
```

`getAnnotations()` 获取代码上添加的所有注解  
```java
Annotation[] annotations = method.getAnnotations();
```

获取类型上的注解，首先获取类型的class，然后调用class的上述方法获取它们使用的注解的实例。  
获取属性和方法上的注解，首先通过反射获取 `Method` 和 `Field` 的实例，然后，调用上述方法获取它们使用的注解的实例。  

获取到注解的实例后，就可以读取注解的属性值。  
```java
String name = annotation.value();
```
