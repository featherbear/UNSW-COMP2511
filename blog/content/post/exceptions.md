---
title: "Exceptions"
date: 2019-10-22T14:10:36+11:00

description: ""
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

Exceptions are useful to programmatically handle both foreseen, and (somewhat) unforeseen errors.

```java
try {
  doSomething()
} catch (ExceptionThing err) {
  System.out.println("Nope!");
} finally {
  System.out.println("Anyways...");
}
```

# Throwing Exceptions

`throw new SomeExceptionClass(...)`

# Everything is an `Exception`

That is, `Exception` is the base class of all exceptions.

We could technically catch every single possible exception with `... } catch (Exception e) { ... }`

```java
try {
  doSomething();
} catch (Exception e) {
  // pass
}
```

Note: This is discouraged, as you lose scope of which exception was raised.

# Defining Custom Exceptions

To define a custom Java exception, we need to extend the abstract `Exception` class

```java
public class MyException extends Exception {
    private String message;

    public MyException(String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message
    }
}
```

We can then throw, and catch this exception.

```java
void doThing() {
  throw new MyException("Uh oh!");
}

void doOtherThing() {
  try {
    doOtherThing();
  } catch (MyException e) {
    System.out.println(e.getMessage());
  }
}
```

# Delegating raised exceptions to other code

Consider the function

```java
void tryDoIt() {
  OpenFile("test.txt");
}
```

If `OpenFile` has the possibility to throw an exception (i.e. `FileNotFoundException`), then we will have to acknowledge that possibility in our code

```java
void tryDoIt() {
  try {
    OpenFile("test.txt");
  } catch (FileNotFoundException e) {
    System.out.println("File not found!!!");
  }
}
```

If we wanted to catch the exception **outside** of our `tryDoIt` function, we would have to reraise the exception.


```java
void tryDoIt() {
  try {
    OpenFile("test.txt");
  } catch (FileNotFoundException e) {
    throw e;
  }
}
```

However in Java, we can add a hint to the method definition that it may throw the `FileNotFoundException`


```java
void tryDoIt() throws FileNotFoundException {
  OpenFile("test.txt");
}
```

By using the `throws` keyword, we can delegate the handling of the exception to another function.

# Exceptions and Inheritance

Inherited classes must not throw more exceptions than those defined by their parent - only subsets.