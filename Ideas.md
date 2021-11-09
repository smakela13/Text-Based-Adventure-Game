# Ideas

- Definitely want to incorporate movement into the game: 
   - "You are in a dark room. There is a door to your right and left."
   - "Which one do you take?"
- Make the enemy health greater than 25 as a base state
   - Allow corpses to be found and possible loot if the random roll is a 0.
   - This can happen by doing two random rolls.
- Have different player classes
- Allow player to level up
- Allow player to choose a weapon
- Incorporate different enemy stats based on their names/types
- Introduce different locations for the player to travel to in the city
   - City/Nightclub 
   - "Dungeon" running (with loot) 
- Continue to refine the game's text format
- Add a story line
- Add colors to the console text
- Consequences for running away
- Display game stats using a static method
- Permadeath or no (wake up bleeding/wounded in hotel room, % of money/loot taken)

Suggestions:
- Print logic should be abstracted from running logic
- Choice detection logic can shared
- Character as a class or abstract to stem for other "actors"
   - Damage dealing and logic around that to another class
- Save and load functionality.
- Stopping me from doing unit tests:
   - Can test damageTakenEnemy(), enemyDefeatedPotionDropChance()
   - add interface to scanner obj 
- InputHandler.java notes:
   - add message when user enters invalid input
   - bring stylized line in
   - move over other menus
   - set up classes into packages

When adding Swing:
- "Attack"/"Dungeon" text overlay/placement with enemy info as well.
   - Have multiple "layouts"/"layers" to use. Combined with screen clearing gives a illusion of "live program" instead of "line feed program"
   - Screen clearing used. Clean screen after selection made.
- UI or "bar" or a section on the side that displays "player" stats. 
