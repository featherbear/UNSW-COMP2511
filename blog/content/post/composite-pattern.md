---
title: "Composite Pattern"
date: 2019-10-15T15:20:02+11:00
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

An object that contains other objects that behaves as if were those objects.

_i.e. a directory that contains files_

## Implementation Choices

### Type Safety

Only define child-related operations in the Composite class

### Uniformity

Include all child-related operations in the Component interface

![](https://refactoring.guru/images/patterns/diagrams/composite/structure-en-2x.png)

