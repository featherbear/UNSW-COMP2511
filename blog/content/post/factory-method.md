---
title: "Factory Method"
date: 2019-11-17T20:23:36+11:00
categories: ["Design Patterns", "Creational Patterns"]
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

> Provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created

The Factory Method is a creational design pattern that allows objects to be created without specifying the exact class of the object.


-> Allows multiple objects of different classes to be created

This is done by moving object initialisation inside a method, and using that method to get the object.

For example,

Changing

```java
class Thing {
  private int i;
  private int j;
  
  Thing(int a, int b) {
    i = a;
    j = b;
  }
}

//

new Thing(1,2);
```

to 

```java
class Thing {
  private int i;
  private int j;
  
  private Thing(int a, int b) {
    i = a;
    j = b;
  }

  public static Thing create(int a, int b) {
    return new Thing(a, b);
  }
}

// 

Thing.create(1, 2)
```

This way, we could also make the `create` method **abstract**, allowing subclasses to fill in the functionality

```java
abstract class Thing {
  private int i;
  private int j;

  private Thing(int a, int b) {
    i = a;
    j = b;
  }

  // Static methods can't be abstract
  public abstract Thing create(int a, int b);
}

```

---

![](https://refactoring.guru/images/patterns/diagrams/factory-method/structure-2x.png)