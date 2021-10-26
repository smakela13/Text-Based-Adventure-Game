import java.util.Random;

public class Enemy {
   final Random rand = new Random();
   // Enemy variables
   String[] enemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
   int maxEnemyHealth = 100;
   int enemyMaxAttackDamage = 30;
   private String enemyType;

   // Enemy constructor
   public Enemy() {
      // Randomly selects an enemy
      setEnemyType(enemies[rand.nextInt(enemies.length)]);
   }

   public String getEnemyType() {
      return this.enemyType;
   }

   public void setEnemyType(String enemyType) {
      this.enemyType = enemyType;
   }

   // Enemy appears to Player
   // Enemy dealing damage
   // Enemy taking damage
   // Enemy's health is updated
   // Enemy either dies or kills player
   // Enemy has a chance to drop a health potion and/or item
   

}
