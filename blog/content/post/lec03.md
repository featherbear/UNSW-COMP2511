---
title: "Lecture 03"
date: 2019-09-24T14:11:23+10:00

description: "Inheritance and Abstract Classes"
categories: ["Lectures", "Java"]

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

# Inside a class

- Variable declarations outside of the `constructor` are **global**
- Variable declarations inside a `constructor` are **specific to that instance**

## Constructors

- Constructors have a "_no-type_" return
- Constructors have the same name as their class

## Methods can be overloaded

You can have two functions with the same name, that accept a different set of parameters.  
This allows your code to become more flexible, as you can pass different values, or perhaps even leave some out, so you can set it later!

# Variable Shadowing

In programming, variable shadowing is the 'code smell' of using a variable name that has the same name as an attribute in its parent class.

Due to the _dynamic binding_ nature of Java, the variable declared in the parent would then be inaccessible! Oh noes!

# Abstract Classes

Abstract classes are classes than **cannot be instantiated**.  
One might create an abstract class to act as a sort of "template" class, to which other classes inherit.

```java
abstract class AbstractClass {
  abstract private String secretString;
}

// new AbstractClass() // won't work!
```

# Steps to implement the `.equals(Object obj)    function

- Check null
- Check class
- Check property
