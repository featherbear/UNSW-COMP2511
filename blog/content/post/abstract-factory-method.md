---
title: "Abstract Factory Method"
date: 2019-11-17T20:37:23+11:00
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

Similar to the factory method, the abstract factory method allows us produce families of _related objects_ without needing to specify their concrete class.

This is done by creating another layer of abstraction during the creation of objects, by making a factory for each family.

Each factory then produces its own 'style/line' of product for its family.

---

![](https://refactoring.guru/images/patterns/diagrams/abstract-factory/structure-2x.png)