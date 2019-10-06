---
title: "Java Introduction"
date: 2019-09-17T15:13:25+10:00

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

# Java

## Is Platform Independent

Common compilers translate source code into platform-specific code (specific to the processor on that computer (ARM, x86, x64, MIPS, etc). However this can make programs hard to be portable between different platforms and systems.

The Java language addresses this issue by **implementing intermediate 'byte code'** - Where the source code (`.java`) is compiled into Java byte-code.

The _Java Virtual Machine_, installed on the target system, then interprets the byte-code and translates it into its own platform-specific code.

## Has automatic memory management

Automated Garbage Collection (GC) is implemented within Java, so that you don't have to manually clean up the memory.

## Is not-as-low-level-as-other-languages

There are a few things we cannot do, like garbage-collection of memory.

## Is multithreaded

...out of the box  
...when implemeneted

---

## Static Methods (Class methods)

Class methods are functions that belong to the class, rather than an instance of that class.

## Initialising classes

To initialise a class, we must prepend the `new` keyword

For example,

```java
class MyObject {}
```

```java
class MyProgram {
  public static void main(String[] args) {
    MyObject obj = new MyObject();
  }
}
```

## Access Modifiers

- `public` - Any
- `protected` - Any subclass in any package
- `-` (default) Any subclass within that package
- `private` - Only that class
