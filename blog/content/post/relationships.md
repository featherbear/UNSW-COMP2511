---
title: "Relationships"
date: 2019-10-06T20:00:27+11:00

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

# Containment Relationships

## Uses

No ownership between classes, and they have their own lifetimes

## Aggregation

If the parent class is deleted, the child class still exists

## Composition

A 'death relationship'.  
If the parent dies, the child dies (welp)

---

# Inheritance Relationships

## Is-A

An "is a" relationship functions by extending a class to produce another.

e.g. "A circle **is a** shape"

## Has-A

A "has a" relationship functions by containing an object of a class within another class.

e.g. "A room **has a** chair"
