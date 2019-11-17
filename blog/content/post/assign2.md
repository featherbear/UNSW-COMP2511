---
title: "Assignment Two - Dungeon Game"
description: "Yay more reused assignments"
date: 2019-11-17T19:30:31+11:00

hiddenFromHomePage: false
postMetaInFooter: false

flowchartDiagrams:
  enable: false
  options: ""

sequenceDiagrams: 
  enable: false
  options: ""

---

The second assignment for this course was the this-is-not-a-Java-course™️ Dungeon Game in Java.  

In the spirit of "You will work with other people in real programming jobs", this assignment was a pair group project. (_But like, you'll be working with people who know what they're doing, so it's really not the same experience... I think..._).

The project consisted of three parts.

# Milestone One - Planning and User Stories

> As a player... I want to play the game... because I'm bored and don't want to do my homework?

It went something along those lines.. It's abit hard to write user stories for a game. You play games for no real benefit... It's just 'fun'. 

Here are the revisions of the created user stories:

* [Revision 3 (Latest)](../assign2-stories-3)
* [Revision 2](../assign2-stories-2)
* [Revision 1](../assign2-stories-1)

# Milestone Two - Backend Implementation

This section was the bulk of the project - getting everything coded and working.  
This involved employing design patterns such as the State pattern, Strategy pattern, Composite pattern, Observer pattern, Event Emitter pattern, etc. In addition, unit testing through JUnit was made to test the functionality of the code.

I was disappointed in the tardiness of my group partner, resorting to completing some of their parts, or to simplify the specifications so that their backlog could be finished in time. Unfortunately my helping hand wasn't enough, and they didn't have everything done before the deadline.

# Milestone Three - Frontend and Extensions

This was the somewhat 'creative' section of the assignment, where we were given the freedom to prettify and add functionality to the game. We had a working frontend as part of the second milestone, so we could just focus here on the extensions (And waiting for my partner's milestone two backlog to be completed...).

We had initially envisioned for some cool extensions: Multi-player functionality, and a Level Builder. But... given the lack of time (#trimesters) we settled on the following extensions:

* Win Screen
* Lose Screen
* Start Screen
* Level Selector
* Goal Overlay
* Inventory Toolbar
* Colour Coded Items
* Switch-activated doors and portals
* Randomised Portal Teleporation
* Saws
* [DungeonConsole](https://featherbear.github.io/blog/post/dungeon-console/)

My personal favourite is [DungeonConsole](https://featherbear.github.io/blog/post/dungeon-console/) - which, while not an extension but a 'port', it was a fun thing to do while waiting for my partner to do their part. [[GitHub]](https://github.com/featherbear/UNSW-COMP2511-ass2-DungeonConsole/)

---

# Teamwork and Contribution

Especially during the time nearing the due date of the second milestone, I was quite disappointed in my partner's contribution. At that point of time they had only completed about 3 of 7 tasks which had all been allocated a long time ago.

Their quality of code was also quite unsatisfactory.  
Code wasn't formatted, variable naming conventions weren't used, OO design principles (The core of this course) weren't adhered to, inadequate git commit naming and activity (eh), tightly coupled code, bugs, and unsafe refactoring. (At least there were no syntax errors and it compiled...).

I especially found the last observation frustrating - At least one functionality would break for each set of commits that my partner made.  

Having written code in one file that can be adapted by other files, my partner had copied that code into other files, however they did not remove the class-specific functionality and logic, which caused unexpected or broken behaviour.  

Another example was in reviewing their code after they had completed it half an hour before the due time of the third milestone. Movement functionality was refactored from classes into their parent class `MovableEntity`. However it was not done well.

* The `private` method `move` was moved into the super class, preventing child classes from using that method.
* The extra functionality in the player's `move` method was not put back, allowing the player to move even when dead.

The first issue made the code very unmanageable, whilst the second issue **broke functionality**. It was very stressful to debug, locate and fix these introduced bugs with the clock ticking down. All it takes to avoid these issues is careful consideration and testing of the code.

Though, I guess my tests weren't conclusive enough as the tests still passed...

I had effectively carried this project, doing 80-90% of the entire assignment.

<div id="wrap">
<iframe id="statisticsPage" src="statistics.html" frameborder="0" width="100%" height="600px"></iframe>
</div>

[[statistics.html]](./statistics.html)

---

Nevertheless, personally I found the assignment quite interesting!  
Making a program which you can interact with and showcase to others is quite enticing.  
Making [DungeonConsole](https://featherbear.github.io/blog/post/dungeon-console/) was also nice as it gave me a break from the actual assignment (And it actually helped me discover some bugs).

Whilst I had written the majority of the backend without reliance of JavaFX, there were some useful classes (namely the `BooleanProperty` and `IntegerProperty` classes). If I have time to kill, I might implement my own property change listeners so I can remove JavaFX as a dependency on the backend, and only for the JavaFX UI.

![](demo.gif)