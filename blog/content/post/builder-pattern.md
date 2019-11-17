---
title: "Builder Pattern"
date: 2019-11-17T20:42:22+11:00
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

> The builder pattern lets users construct complex objects step by step. Allows users to produce types and representations of an object using the same construction code

* Extract the object construction code out of the object's class and into another class.
* Doesn't allow objects to access the product until it is built
* `Director` class defines the order of which steps are executed
* `Builder` provides the implementation

Kinda like using setters to set the attributes of an object, and encapsulating that into an object where the result can only be accessed via a public method.

---

![](https://refactoring.guru/images/patterns/diagrams/builder/structure-2x.png)

