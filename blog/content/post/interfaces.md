---
title: "Interfaces"
date: 2019-10-06T20:44:14+11:00

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

# Interfaces

Interfaces are groups of functions that can be assigned to classes of similar behaviour, but whose inherited classes are different.  
While you can only inherit (`extends`) one class, you may inherit (`implements`) as many interfaces as you like.

An interface does not (usually) contain functions, rather just the function signature.  
In the class that implements a given interface, the actual function logic is implemented there.

In fact, you could consider an interface as an [abstract class](../abstract-classes)

Note: When you implement an interface method, you must supply the `@Override` annotation

## Rationale

Interfaces can be considered as the C/C++ `.h` header files of Java.  
Without needing to know of how a class implements a method, we know that a class that implements an interface will have the appropriate behaviour when calling an interface method

## default

(Java 8)

An interface can technically contain a function body if you define it as a `default` function.  
This is the function that will be called if the implementing class does not have a body for interface function.

## static

Like static methods in classes, you can create static methods in your interface

## Variables

Variables defined in an interface are implicitly `static` and `final`, making them constant.  
You cannot change the value of the variables

---

> What if I forget to implement a function from the interface???

Computer: \***Screams in Java compiler error**\*

Don't worry, your compiler will prevent you from compiling and notify you.  
(Unless you defined `default` methods, in which case I will personally scream at you)
