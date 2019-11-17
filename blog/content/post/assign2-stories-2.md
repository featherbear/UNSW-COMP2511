---
title: "Assignment Two - User Stories (rev 2)"
date: 2019-11-3T19:41:30+11:00
---

# Epic Stories

- As a player I want to explore the game world to feel accomplished
- As a player I want to face enemies and fight them to challenge my skills and have fun.
- As a player I want to use items to improve my player's capabilities

# User Stories

> **1 point = 2 hours**  
**Priorities: High, Medium, Low**

- As a player, I want to activate exits to complete the level (High, 5 points)
  - Exits can be activated by dependent goals
  - When the player steps on an activated exit, the game is completed and the game over screen will be shown
- As a player, I want to move my character so that I can interact with the game objects (High, 10 points)
  - Player entity cannot move through a wall
  - Player entity cannot move through a boulder
  - Player entity cannot move through an enemy
  - Pressing the keyboard (Up, Down, Left, Right) will move the character one adjacent tile
- As a player, I want to complete goals to finish the levels (High, 4 points)
  - Composite goals (AND, OR) have other goal requirements which must be fulfilled
  - When all goals are completed, the game is completed
- As a player, I want to interact with switches to complete the level (Medium, 4 points)
  - Switches can be activated by boulders being placed on top
  - When a boulder is moved off an activated switched the switch is deactivated
  - When a switch is activated, a goal may be progressed
- As a player, I want to push boulders to complete the level (Medium, 4 points)
  - Boulders can be pushed by the adjacent player in the direction the player is facing
  - Boulders can be pushed through floor switches, portals (will not teleport), open doors, exits, enemies, items (treasure, keys, swords, invincibility potions)
  - Boulders cannot be pushed through walls, closed doors, other boulders
  - Boulders cannot be used to push other boulders
  - Boulders cannot teleport through portals
  - Boulders will kill enemies if pushed unto them
  - When a boulder is pushed on top of a floor switch, the switch will be activated
  - When a boulder is pushed off a floor switch, the switch will be deactivated
- As a player, I want to open doors to move around the map (Medium, 4 points)
  - Doors can be opened by corresponding keys
  - If the player has the corresponding key for the door, when the door tile is stepped on the door will unlock
  - When a key is used on its corresponding door, the key is removed from the player
  - A player can carry only one key at a time
  - A player cannot move through a locked door
  - A player can move through an unlocked door
  - When a key is picked up, it is removed from the map
- As a player, I want to collect treasure to complete the level (Medium, 2 points)
  - If enough treasure has been collected for a treasure goal, that goal will be fulfilled
  - When treasure is picked up, it is removed from the map
- As a player, I want to defeat all enemies to complete the level (Medium, 10 points)
  - Enemies will move towards the player in the same direction the player moved
  - Enemies will move adjacent to their position by one step
  - Enemies will run from the player when they are invincible
  - If an enemy collides with a player (not holding a sword or invincibility potion), the player is killed
- As a player, I want to use swords to defeat enemies to complete the level (Medium, 5 points)
  - If the player has a sword and moves into an enemy, the enemy is defeated
  - Each kill uses up one durability
  - A sword has a durability of 5 uses
  - When the sword runs out of durability, it is removed from the player
  - Only one sword can be carried at once
- As a player, I want to use invincibility potions to complete the level (Low, 4 points)
  - When an invincibility potion is picked up it is immediately activated
  - When an invincibility potion is picked up, it is removed from the map
  - When an invincibility potion is activated, the player is given 10 moves of invincibility
  - When the player's invincibility duration is over, their invincibility status will be reset (Player's state will be restored)
  - When the player is invincible, any collisions with enemies will kill the enemy
  - When the player is invincible, enemies will flee from the player
- As a player, I want to use portals so I can jump to locations on the map (Low, 6 points)
  - Portals will teleport players to the corresponding portals
  - Portals will not interact with enemies or other entities
  - If a player teleports to a portal whose tile is occupied by an enemy, the enemy is TP-killed
  - If the destination portal is obstructed by an entity other than an enemy, the teleportation is blocked
- As a player, I want to restart the level so I can try it from the start again (Low, 2 points)
  - When the `R` key is pressed, the level is reset back to the start