---
title: "Code Smells"
date: 2019-11-13T01:15:51+11:00

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

* Bloaters - Code, methods and classes that are too big.
* OO Absusers - Things that violate OO design
  * i.e. `switch` instead of polymorphism
  * ie. Refused Bequest - Subclass does not adequately nor logically extends its super class
* Change Preventers - Rigid code
* Dispensables - Pointless and/or unnecessary code
  * Excessive comments
  * Data classes - ehh....
  * Duplicate code
* Couplers - Excessive coupling
