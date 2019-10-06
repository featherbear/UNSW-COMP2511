---
title: "Javadocs"
date: 2019-10-06T19:42:52+11:00

description: "Writing maintainable code!"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

There are three types of code documentation:

- Internal - Comments found inside the code (i.e. `// Calculate the price of the purchase`)
- External - Comments found outside of the code (i.e. in a user manual)
- Intrinsic - Comments deduced from code
  - Often through sensible naming of variables or functions
  - i.e. `int price = 150;`

---

One form of _internal documentation_ are Javadocs, where through writing specially formatted comments, your IDE is able to use those comments for code completion, type checking, etcetera.

Javadocs can also be made _external_ through a Javadoc generator, like Doxygen.

In Eclipse, you can generate a Javadoc comment field by selecting a method / class, then pressing Alt + Shift + J (Windows) or Command + Shift + J (Mac). You can also generate a Javadoc website through `Project -> Generate Javadoc`

# Syntax

A Javadoc comment is a multiline comment, with the first line having two asterisks compared to one.

```java
/**
  * This is a Javadoc comment
  */
```

You can add comments for parameters with the **@param** prefix

```java
/**
  * Does nothing with arg1
  * @param arg1 - first argument
  */
```

You can add the return comment with the **@return** prefix

```java
/**
  * @return True
  */
```

---

Javadoc comments are completely arbitrary from the code they are concerned about.  
It is your job to make sure that the order of comments are in the same order of the method's / class' signature.
