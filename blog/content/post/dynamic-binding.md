---
title: "Dynamic Binding"
date: 2019-09-25T16:11:23+10:00

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

In a very simple sense, when a piece of code is compiled, the compiler sets up all the information that it knows. For example, the types of the methods and variables. _These are statically bound._

However, when you have a given class that extends another class, the compiler doesn't store the parent class in the class file for the child class. **Instead**, when the code actually runs, the parent class information is loaded, and then the child class information is superimposed on top.

This is what is meant by dynamic binding - where information is only set when needed.

---

On a more technical level:

| Static                                                        | Dynamic                               |
| :------------------------------------------------------------ | :------------------------------------ |
| Occurs during compile time                                    | Occurs during runtime                 |
| Used by `private`, `final` and `static` methods and variables | Used by virtual (redefinable) methods |
| Use class information                                         | Use the object                        |
| Bonds overloaded methods                                      | Bonds overriden                       |

_- Information from [here](https://javarevisited.blogspot.in/2012/03/what-is-static-and-dynamic-binding-in.html)_
