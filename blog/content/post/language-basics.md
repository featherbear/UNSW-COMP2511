---
title: "Language Basics"
date: 2019-10-06T20:16:19+11:00

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

# Language Basics

## Control Structures

- Loops
- If-else
- Switch

Same as C!

```java
for (int i = 0; i < someArray.length; i++) {
  // ...
}
```

### Object iteration

```java
for (String s : someStrings) {
  System.out.println(s)
}
```

## Concatenation

We can concatenate a Number and a String through the magic of polymorphism!

```java
System.out.println("I am " + 12 + " years old.");
```

## Data Types

- `String`
- `Boolean`
- `Arrays` have a length, with `<Array>.length`

## Packages

- `package` to declare a namespace
- `import` to import

# Niches

## Every file is a _class_

Every file is stored in a class file, even if that file is not related to an object

## The class name must be the same as the file name

If your code has

```java
class Foo { ... }
```

You **_must_** name that file `Foo.java`

## Program entry point

All entry points (places where the program can start) follow the syntax of the

```java
public static void main(String[] args) {
  // ...
}
```
