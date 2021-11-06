# Text-Based Adventure Game

## Table of Contents

* [Description](#description)
* [Usage](#usage)
* [Credits](#credits)
* [Ideas](#ideas)

## Description

The game is written using Java and will explore a city with all sorts of supernatural enemies.

## Usage

Coming soon.

## Credits

Created by [Soma Mäkelä](https://github.com/smakela13).

## Ideas

Definitely want to incorporate this type of movement into the game: 
   "You are in a dark room. There is a door to your right and left."
   "Which one do you take?"

Other ideas:
- Make the enemy health greater than 25 as a base state
   - Allow corpses to be found and possible loot if the random roll is a 0.
   - This can happen by doing two random rolls.
- Have different player classes
- Allow player to level up
- Allow player to choose a weapon
- Incorporate different enemy stats based on their names/types
- Introduce different locations for the player to travel to in the city
- Continue to refine the game's text format
- Add a story line
- Add colors to the console text
- Consequences for running away
- Display game stats using a static method

Suggestions:
- This needs to be broken out of main, this will quickly be unmaintainable
- Print logic should be abstracted from running logic
- Choice detection logic can shared 

More Suggestions:
- Character as a meta class or abstract or base class to stem for other "actors"
- Screen clearing used. Clean screen after selection made.
- UI or "bar" or a section on the side that displays "player" stats. Move that away from the main text logic. Cleaner.
- Damage dealing and logic around that to another class (Character meta class maybe)?
- "Attack"/"Dungeon" text overlay/placement with enemy info as well.
- Text sections must be broken out. Suggestion to have multiple "layouts"/"layers" to use. Have text from some things fill to some layouts, and other text added to other layouts. Combined with screen clearing gives a illusion of "live program" instead of "line feed program"
- Input handling should be ideally split to InputHandler class that is initialized at start.
- More things. City/Town, Dungeon running (with loot), bars!, permadeath or no (wake up bleeding, wounded in town, % of gold taken) decisions etc.
- Save and load functionality.

Stopping me from doing unit tests:
- Put print in other places
- Can test damageDealtEnemy(), damageTakenEnemy(), enemyDefeatedPotionDropChance(), getEnemyType()
- Data class that just holds values getters and setters, otherwise no setters
- make classes final until they need to inherit
- add interface to scanner obj 

InputHandler.java notes:
- add message when user enters invalid input
- bring stylized line in
- move over other menus
- set up classes into packages
