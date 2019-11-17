---
title: "Decorator Pattern"
date: 2019-11-13T01:06:24+11:00
categories: ["Design Patterns", "Structural Patterns"]
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

The decorator pattern 'decorates' additional functionality to an object during runtime.  
This is in line with the Open-Closed Principle, as the original code does not need to be changed.

The decorator pattern is a structural pattern, and prefers a composition of an inheritance of its class.  
Through this we can decorate an object multiple times - `A(A(A(A(A(B)))))`

For example, adding extra cost (ie +50 cents) to an object that has a cost attribute

---

![](https://refactoring.guru/images/patterns/diagrams/decorator/structure-2x.png)