---
title: "SOLID"
date: 2019-10-06T21:26:06+11:00

description: "Good Software Design"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

# SOLID

# **S**ingle responsibility principle

A class should only have one responsibility

# **O**pen-closed principle

Code should be open for extension, but closed for modification.  
_(Aka freely extensible, but should not need modification of the original code)_

# **L**iskov substitution principle

Objects in a program should be replaceable with instances of their (super/sub) types without altering the correctness of that program.

e.g. Board <- Board3D

<!-- Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program. -->

# **I**nterface segregation principle

Many client-specific interfaces are better than one general-purpose interface

# **D**ependency inversion principle

Depend upon abstractions rather than concretions
