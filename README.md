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
   - Have different player classes
   - Allow player to level up
   - Allow player to choose a weapon
   - Incorporate different enemy stats based on their names/types
   - Introduce different locations for the player to travel to in the city
   - Continue to refine the game's text format
   - Add a story line
   - Add colors to the console text
   - Consequences for running away

   Suggestions:
   - This needs to be broken out of main, this will quickly be unmaintainable
   - Player should be an object
   - Print logic should be abstracted from running logic
   - Choice detection logic can shared 
   - Should make use of final variables
   
   - Character as a meta class or abstract or base class to stem for other "actors"
   - Player info out of App to it's own class
   - Screen clearing used. Clean screen after selection made.
   - UI or "bar" or a section on the side that displays "player" stats. Move that away from the main text logic. Cleaner.
   - Damage dealing and logic around that to another class (Character meta class maybe)?
   - Choices/actions should be more deterministic. Not just 1/2/3. At least coming from TextBased games. (a)ttack, (d)rink potion, (f)lee etc... makes memorization easier.
   - "Attack"/"Dungeon" text overlay/placement with enemy info as well.
   - Text sections must be broken out. Suggestion to have multiple "layouts"/"layers" to use. Have text from some things fill to some layouts, and other text added to other layouts. Combined with screen clearing gives a illusion of "live program" instead of "line feed program"
   - Item drop logic should be tied to Enemy class (since they drop it).
   - Input handling should be ideally split to InputHandler class that is initialized at start.
   - More things. City/Town, Dungeon running (with loot), bars!, permadeath or no (wake up bleeding, wounded in town, % of gold taken) decisions etc.
   - Save and load functionality.