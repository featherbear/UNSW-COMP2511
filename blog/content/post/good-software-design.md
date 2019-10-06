---
title: "Good Software Design"
date: 2019-10-06T21:02:03+11:00

description: "Code smells"
hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams:
  enable: false
  options: ""
---

# Good Software Design

Software will always change.  
Technology will change, versions will get updated, frameworks will change, computers with better/worse hardware will be used.  
With the constant change of specifications and requirements - it is important to write maintainable, reusable and performant code.

## The Ideal System

- Loose coupling - Low interdependence of modules
- High cohesion - Modules are logically separated, and still work well with each other

## Design Smells / Code Smells

- **Rigidity** - Complicated to change one small thing (causes a series of changes for dependent modules)
  - e.g. Library system - Adding a new category requires changes to a lot of cde
- **Fragility** - Code breaks because of a single change
  - e.g. 3D shape - Modifying the length of one side requires manual modification to its surface area and volume properties.
- **Immobility** - Non-modular code that is hard to reuse in other systems
  - e.g. A class that relies on case-specific objects
- **Viscosity** - Hard to implement without 'hacking' it together
- **Opacity** - Confusing and hard to understand
- **Needless Complexity**

- Duplicate code
- Long function bodies
- Large class
- Long parameter list
- Divergent change (When one class is commonly changed in different ways for different reasons)
- Shotgun surgery (When a lot of classes are changed for one reason)

## Design Principles

- [SOLID](../solid)
- Separation of Concerns (SOC)
- Less Fragile Systems (Maintainable, Reusable and Extensible code)
- Pragmatic Programming (Don't Repeat Yourself, Keep It Simple Stupid)
- Design Patterns (GOF)

### Warning - Don&apos;t over do it

These 'principles' are more like 'tools', rather than 'rules'.
Don't apply design principles if there are no code smells present.  
Otherwise you will result in your code having needless complexity.

## Principle of Least Knowledge / Law of Demeter

"one dot only".  
(Two is okay I guess)

Only interact with immediate objects (i.e Objects contained inside the class)

_In practical application_ - Rather than chaining functions in one line, add extra methods in neighbouring classes that can return the next object

A method in an object should only invoke methods of:

- the object itself
- objects passed in as parameters
- objects instantiated within the method
- component objects
- NOT of those returned

## Liskov Substitution Principle

[See here](../solid#liskov-substitution-principle)

Favour composition (wrapper) over inheritance
