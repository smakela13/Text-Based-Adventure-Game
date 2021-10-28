import java.util.Random;

public class Enemy {
   final Random rand = new Random();
   // Enemy variables
   String[] enemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
   int maxEnemyHealth = 100;
   int enemyMaxAttackDamage = 30;
   private String enemyType;
   int healthPotionDropPercentage = 25;
   int enemyDroppedHealthPotions = 1;
   int healthPotionHealAmount = 30;

   // Enemy constructor (needs to be implemented)

   // Enemy appears to Player
   public void selectRandomEnemy() {
      setEnemyType(enemies[rand.nextInt(enemies.length)]);
      String enemyFoundString = String.format("\t~* You found a %s! *~", enemyType);
      System.out.println(enemyFoundString);
   }

   // Enemy's health revealed to Player
   public void discoverEnemyHealth() {
      int enemyHealth = rand.nextInt(maxEnemyHealth);
      String enemyHealthString = String.format("\tThe %s has %d health.", enemyType, enemyHealth);
      System.out.println(enemyHealthString);
   }

   // Enemy (potentially) deals damage to Player
   public void damageDealtEnemy() {
      int enemyDamageDealt = rand.nextInt(enemyMaxAttackDamage);
      String enemyDamageDealtString = String.format("\tThe %s deals %d damage to you in return.", enemyType,
            enemyDamageDealt);
      System.out.println(enemyDamageDealtString);
   }

   // Enemy (potentially) takes damage from Player
   // public void damageTakenEnemy() {

   // }

   // Enemy's health is updated (needs to be implemented here)

   // Enemy (potentially) kills Player (needs to be implemented here)

   // Enemy (potentially) dies and drops a health potion
   public void enemyDefeatedPotionDropChance() {
      String enemyDefeatedString = String.format("\tYou have defeated the %s!", enemyType);
      System.out.println(enemyDefeatedString);

      int potionDropChance = rand.nextInt(100);
      if (potionDropChance < healthPotionDropPercentage) {
         enemyDroppedHealthPotions++;
         String healthPotionDroppedString = String.format(
               "\tThe %s dropped a health potion!%n You now have %d health potions.", enemyType,
               enemyDroppedHealthPotions);
         System.out.println(healthPotionDroppedString);
      }
   }

   // Enemy's getters and setters
   public String getEnemyType() {
      return enemyType;
   }

   public void setEnemyType(String enemyType) {
      this.enemyType = enemyType;
   }
}
