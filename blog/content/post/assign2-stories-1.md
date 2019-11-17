---
title: "Assignment Two - User Stories (rev 1)"
date: 2019-10-24T10:54:30+11:00
---

# Epic Stories

- As a player I want to interact with the game to complete the level and win.

# User Stories

> **1 point = 2 hours**  
**Priorities: High, Medium, Low**

- As a player, I want to activate exits to complete the level (High, 5 points)
  - If all goals have been completed, the exit will be activated
  - Exits can also be activated by corresponding switches
  - When the player steps on the exit, they will be taken to the next level
  - If there no more levels the game is completed and the game over screen will be shown
- As a player, I want to move my character so that I can interact with the game objects (High, 10 points)
  - Player entity cannot move through a wall
  - Player entity cannot move through a boulder
  - Player entity cannot move through an enemy
  - Pressing the keyboard (Up, Down, Left, Right) will move the character
  - If a player collides with an enemy and is not invincible, they will die and the level will be reset
- As a player, I want to complete goals to finish the levels (High, 4 points)
  - Composite goals (AND, OR) have other goal requirements which must be fulfilled
  - When all goals are completed, an event will be triggered - like the Exit tile being activated
- As a player, I want to interact with switches to complete the level (Medium, 4 points)
  - Switches can be activated by boulders being placed on top
  - When a boulder is moved off an activated switched the switch is deactivated
  - When a switch is activated, an event will be triggered
  - An event will be a variation of a door being opened, a portal being activated, enemies being spawned or an exit being activated
- As a player, I want to push boulders to complete the level (Medium, 4 points)
  - Boulders can be pushed by the adjacent player in the direction the player is facing
  - Boulders can be pushed through floor switches, portals, enemies, items (treasure, keys, swords, invincibility potions)
  - Boulders cannot be pushed through walls, exits, doors, other boulders
  - Boulders cannot be used to push other boulders
  - Boulders cannot teleport through portals
  - Boulders will kill enemies if pushed unto them
  - When a boulder is pushed on top of a floor switch, the switch will be activated
  - When a boulder is pushed off a floor switch, the switch will be deactivated
- As a player, I want to pick up items to use to complete the level (Medium, 4 points)
  - The player can pick up swords, invincibility potions, keys and treasure
  - When an invincibility potion is picked up, it is automatically activated
  - When an item is picked up, it is removed from the map
- As a player, I want to open doors to move around the map (Medium, 4 points)
  - Doors can be opened by corresponding keys
  -  Doors can be opened by corresponding switches
  - If the player has the corresponding key for the door, when the door tile is stepped on the door will unlock
  - When a key is used on its corresponding door, the key is removed from the player
  - A player can carry only one key at a time
  - A player cannot move through a locked door
  - A player can move through an unlocked door
- As a player, I want to collect treasure to complete the level (Medium, 2 points)
  - If enough treasure has been collected for a treasure goal, that goal will be fulfilled
- As a player, I want to defeat all enemies to complete the level (Medium, 10 points)
  - Enemies will move towards the player
  - Enemies will run from the player when they are invincible
  - If an enemy collides with a player that is not invincible or holding a sword, the player is killed
  - If an enemy collides with a player that is invincible or holding a sword, the enemy is killed.
- As a player, I want to use swords to defeat enemies to complete the level (Medium, 5 points)
  - If the player has a sword and moves into an enemy, the enemy is defeated
  - Each kill uses up one durability
  - A sword has a durability of 5 uses
  - When the sword runs out of durability, it is removed from the player
  - Only one sword can be carried at once
- As a player, I want to use invincibility potions to complete the level (Low, 4 points)
  - When an invincibility potion is picked up it is immediately activated
  - When an invincibility potion is activated, the player is given 10 moves of invincibility
  - When the player's invincibility duration is over, their invincibility status will be reset (Player's state will be restored)
  - When an invincible player moves into an enemy, the enemy is defeated immediately
  - When a player is invincible, enemies will run from the player
- As a player, I want to use portals so I can jump to locations on the map (Low, 6 points)
  - Portals can be toggled (activated/deactivated) by switches
  - Portals will teleport players to the corresponding portals
  - Portals will not interact with enemies
  - If a player teleports to a portal whose tile is occupied by an enemy, the enemy is TP-killed
- As a player, I want to restart the level so I can try it from the start again (Low, 2 points)
  - When the `R` key is pressed, the level is reset back to the start