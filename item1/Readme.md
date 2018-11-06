## Item 1: Consider static factory methods instead of constructors

The traditional way for a class to allow a client to obtain an instance is to provide a public constructor. There is another technique that should be a part of every programmer’s toolkit. A class can provide a public static factory method, which is simply a static method that returns an instance of the class. Here’s a simple example from Boolean (the boxed primitive class for boolean). This method translates a boolean primitive value into a Boolean object reference:

`public static Boolean valueOf(boolean b) {`

	return b ? Boolean.TRUE : Boolean.FALSE;
`}`

**Advantages**

- unlike constructors, they have names. -> Code readability (Method name can describe what object it is returning)

  - For example, the constructor `BigInteger(int, int, Random)`, which returns a `BigInteger` that is probably prime, would have been better expressed as a static factory method named `BigInteger.probablePrime`. (This method was added in Java 4.)

  - A class can have only a single constructor with a given signature. Programmers have been known to get around this restriction by providing two constructors whose parameter lists differ only in the order of their parameter types. This is a really bad idea

- Unlike constructors, they are not required to create a new object each time they’re invoked. -> Caching

  The `Boolean.valueOf(boolean)` method illustrates this technique: it never creates an object. 

- Unlike constructors, they can return an object of any sub-type of their return type.

- The class of the returned object can vary from call to call as a function of the input parameters.

- A fifth advantage of static factories is that the class of the returned object need not exist when the class containing the method is written.

  - Such flexible static factory methods form the basis of service provider frameworks, like the Java Database Connectivity API (JDBC). A service provider framework is a system in which providers implement a service, and the system makes the implementations available to clients, decoupling the clients from the implementations.

  - There are 4 essential components in a service provider framework:

    1. a service interface, which represents an implementation; 

    2. a provider registration API, which providers use to register implementations;

       `DriverManager.registerDriver` 

    3. a service access API, which clients use to obtain instances of the service

       `DriverManager.getConnection`

    4. The service access API may allow clients to specify criteria for choosing an implementation

       `Driver` is the service provider interface

**Disadvantage**

- The main limitation of providing only static factory methods is that classes without public or protected constructors cannot be sub-classed.
- second shortcoming of static factory methods is that they are hard for programmers to find. They do not stand out in API documentation in the way that constructors do.

**Common Names for static factory methods:**

- **from**—A type-conversion method that takes a single parameter and eturns a corresponding instance of this type.

  `Date d = Date.from(instant);`

- **of**—An aggregation method that takes multiple parameters and returns an instance of this type that incorporates them.

  `Set faceCards = EnumSet.of(JACK, QUEEN, KING);`

- **instance or getInstance**

  `StackWalker luke = StackWalker.getInstance(options);`

- **create or newInstance**—Like instance or getInstance, except that the method guarantees that each call returns a new instance.

  `Object newArray = Array.newInstance(classObject, arrayLen);`

- **getType**—Like getInstance, but used if the factory method is in a different class. Type is the type of object returned by the factory method.
  `Image image = Files.getImage(path);`

- **newType**—Like newInstance, but used if the factory method is in a different class. Type is the type of object returned by the factory method.

  `BufferedReader br = Files.newBufferedReader(path);`

- **type**—A concise alternative to getType and newType.

  `List litany = Collections.list(legacyLitany);`

