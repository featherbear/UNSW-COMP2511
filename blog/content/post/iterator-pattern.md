---
title: "Iterator Pattern"
date: 2019-10-29T16:31:24+11:00
categories: ["Design Patterns", "Behavioural Patterns"]
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

The iterator pattern provides a way to access the elements of an aggregate object, without needing to know its underlying mechanism

# Implementation

Create a class that implements the `Iterator<ItemType>` interface, as an inner class in the class that holds the items. This allows the iterator to access the internal data structures.

Then create a function that returns this class, of its interface's type

![](https://refactoring.guru/images/patterns/diagrams/iterator/structure-2x.png)