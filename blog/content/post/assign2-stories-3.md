---
title: "Assignment Two - User Stories (rev 3)"
date: 2019-11-17T16:33:30+11:00
---

> **1 point = 2 hours**  
**Priorities: High, Medium, Low**

# > ES1 - As a player I want to explore the game world to feel accomplished

## US1 - As a player, I want to activate exits to complete the level (High, 5 points)
- Exits can be activated by dependent goals
- When the player steps on an activated exit, the game is completed and the game over screen will be shown

## US2 - As a player, I want to move my character so that I can interact with the game world (High, 10 points)
- Player entity cannot move through a wall
- Player entity cannot move through a boulder
- Player entity cannot move through an enemy
- Pressing the keyboard (Up, Down, Left, Right) will move the character one adjacent tile

## US11 - As a player, I want to use portals so I can jump to locations on the map (Low, 6 points)
- Stepping on portals will teleport players to the corresponding portals
- Portals will not interact with enemies or other entities
- If a player teleports to a portal whose tile is occupied by an enemy, the enemy is TP-killed (killed by teleportation blocking)
- If the destination portal is obstructed by an entity other than an enemy, the teleportation is blocked

## US12 - As a player, I want to restart the level so I can try it from the start again (Low, 2 points)
- When the R key is pressed, the level is reset back to the start

# > ES2 - As a player I want to face enemies and fight them to challenge my skills and have fun

## US8 - As a player, I want to defeat enemies to complete the level. (Medium, 10 points)
- Enemies will move towards the player in the same direction the player moved
- Enemies will move adjacent to their position by one step
- Enemies will run from the player when they are invincible
- If an enemy collides with a player (not holding a sword or invincibility potion), the player is killed

## US9 - As a player, I want to use swords to defeat enemies to complete the level (Medium, 5 points)
- If the player has a sword and moves into an enemy, the enemy is defeated
- Each kill uses up one durability
- A sword has a durability of 5 uses
- When the sword runs out of durability, it is removed from the player
- Only one sword can be carried at once
- When a sword is picked up, it is removed from the map

## US10 - As a player, I want to use invincibility potions to complete the level (Low, 4 points)
- When an invincibility potion is picked up it is immediately activated
- When an invincibility potion is picked up, it is removed from the map
- When an invincibility potion is activated, the player is given 10 moves of invincibility
- When the player&#39;s invincibility duration is over, their invincibility status will be reset (Player&#39;s state will be restored)
- When the player is invincible, any collisions with enemies will kill the enemy
- When the player is invincible, enemies will flee from the player

# > ES3 - As a player I want to use items to improve my player&#39;s capabilities

## US3 - As a player, I want to complete goals to finish the levels. (High, 4 points)
- Composite goals (AND, OR) have other goal requirements which must be fulfilled
- When all goals are completed, the game is completed

## US4 - As a player, I want to interact with switches to complete the level (Medium, 4 points)
- Switches can be activated by boulders being placed on top
- When a boulder is moved off an activated switched the switch is deactivated
- When a switch is activated, a goal may be progressed

## US5 - As a player, I want to push boulders to complete the level (Medium, 4 points)
- Boulders can be pushed by the adjacent player in the direction the player is facing
- Boulders can be pushed through floor switches, portals (will not teleport), open doors, exits, enemies, items (treasure, keys, swords, invincibility potions)
- Boulders cannot be pushed through walls, closed doors, other boulders
- Boulders cannot be used to push other boulders
- Boulders cannot teleport through portals
- Boulders will kill enemies if pushed unto them
- When a boulder is pushed on top of a floor switch, the switch will be activated
- When a boulder is pushed off a floor switch, the switch will be deactivated

## US6 - As a player, I want to open doors to move around the map (Medium, 4 points)
- Doors can be opened by corresponding keys
- If the player has the corresponding key for the door, when the door tile is stepped on the door will unlock
- When a key is used on its corresponding door, the key is removed from the player
- A player can carry only one key at a time
- A player cannot move through a locked door
- A player can move through an unlocked door
- When a key is picked up, it is removed from the map

## US7 - As a player, I want to collect treasure to complete the level (Medium, 2 points)
- If enough treasure has been collected for a treasure goal, that goal will be fulfilled
- When treasure is picked up, it is removed from the map

Extensions
===

# > ES4 - As a player I want to have a seamless UI experience so I can enjoy the game

## US13 - As a player, I want to see a Win Screen so I know when I have completed the level.
- When the level is completed, a win screen will be shown

## US18 - As a player, I want to see the Lose Screen when I die so I know to try again
- When the player dies, the lose screen will appear

## US14 - As a player, I want to see the available levels so I can choose which level to play
- The available levels will be shown in a list
- Clicking on a level entry will select that level
- When the Play button is pressed, if a level has been selected, the game will load for that level
- A Random button will allow a map to be selected at random

## US15 - As a player I want to see what items I have so I can complete goals to win the game
- When an item is added to the player&#39;s inventory (pickup), the item will be shown on the toolbar
- Items with a durability/use will have a text showing the remaining uses
- Items with a remaining use of 1 will not show their text
- Items that can be picked up multiple times will show a count when more than one of that item is picked up (ie Treasure)
- When an item is used up, the item will be removed from the toolbar

## US16 - As a player, I want to see colour-coded items, so I know which items on the map are needed to complete the game.
- Keys and Doors are the same colour for a given ID
- Portals are the same colour for a given ID
- Switches and Doors are the same colour for a given ID

## US20 - As a player I want to see a start page so I know how to win the game and have fun
- When the game first starts, a start page will show the controls
- The start screen will not show if the player restarts the game
- When the play button is clicked, the game will start
- There will be a background of the game

## US21 - As a player, I want to see what goals are left to complete so I can win and enjoy the game.
- Goals will be displayed on the top left corner of the screen
- Goals will be displayed in a list format
- Completed goals will be removed from the list
- Composite goals that have only one child will be shown as just the child goal

# > ES5 - As a player I want to have extra game functionality so I can further enjoy the game

## US17 - As player, I want to randomly teleport between matching portals so I can jump between locations
- Three or more portals with the same ID will teleport players to a random portal of the same ID

## US19 - As a player, I want to avoid saw blades so I can win the game
- Saws will move in either a vertical or horizontal direction
- Saws will move by one tile per turn
- When a saw reaches a blocked path (Boulder and Wall), it will move the opposite direction
- Saws will kill enemies and players in the way
- Saws can overlap each other
- If a saw moves into a player who is invincible, the saw is stopped but will continue moving in the direction when cleared

## US22 - As a player, I want to activate doors and portals through switches, so that I can challenge myself and have fun.
- A switch may have an ID
- Multiple switches can have the same ID
- When a switch is activated, doors and portals with that ID are activated
- When all switches of an ID are deactivated, doors and portals with that ID are deactivated
- Doors that have been opened by a key will not be closed by a deactivated set of switches