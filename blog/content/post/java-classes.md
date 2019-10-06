---
title: "Classes"
date: 2019-09-19T11:28:25+10:00

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

In Object-Oriented Programming, programmers focus on user-defined data types called **classes**.

Each class contains **attributes** and **methods** that can manipulate data.

An instance of a class is called an **object**.

**Encapsulation** is the privatisation of its attributes and methods, where its properties are exposed to other objects only if explicitly set.

---

- The filename containing the class must match the name of the class.
- Use the relevant [access modifiers](../java-access-modifiers)
- Apply inheritance when relevant
- Use getter and setter methods
- [Constructor methods](#constructors)
- Polymorphism
- Use `this` generously
- Use the object keywords (static, final)

# Constructors

When a class is created, it is often useful to assign values to its attributes straight away during initialisation. This can be achieved through constructor methods.

Constructor methods are named as `public` type-less methods that have the same name as its class.

Consider a class definition for a circle...

## The no-arg constructor

If no values need to be supplied during object initialisation, the no-argument constructor is used (nothing between the parentheses `()`).

```java
class Circle {
  int x, y, r;
  public Circle() {
    this.x = 0;
    this.y = 0;
    this.r = 1;
  }
}
```

Calling `new Circle()` would create a circle with a default radius of `1` at position `(0,0)`

## Argument constructors

If we need to pass values during the object initialisation, we can create another constructor method, this time adding in our arguments into the parentheses

```java
class Circle {
  int x, y, r;
  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
}
```

## Overloading

We can use both types of constructors at the same time due to the magic of function overloading - Just stick them together!

```java
class Circle {
  int x, y, r;

  public Circle() {
    this.x = 0;
    this.y = 0;
    this.r = 1;
  }

  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
}
```

#### Even further!

Looks a bit redundant eh?  
If we added in other attributes, it would be a pain to maintain all of the constructor methods - so instead we could make our constructors call other constructor methods!

To do this, we call the `this()` method

```java
class Circle {
  int x, y, r;

  public Circle() {
    this(0, 0, 1); // Woah!
  }

  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }
}
```

## All methods can be overloaded

You can have two functions with the same name, that accept a different set of parameters.  
This allows your code to become more flexible, as you can pass different values, or perhaps even leave some out, so you can set it later!

## Inside a class

- Variable declarations outside of the `constructor` are **global**
- Variable declarations inside a `constructor` are **specific to that instance**

## Variable Shadowing

In programming, variable shadowing is the 'code smell' of using a variable name that has the same name as an attribute in its parent class.

Due to the [dynamic binding](../dynamic-binding) nature of Java, the variable declared in the parent class would then be inaccessible! Oh noes!

## Inheritance

[See here](../inheritance)
