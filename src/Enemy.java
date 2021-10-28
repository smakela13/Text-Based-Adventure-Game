import java.util.Random;

public class Enemy {
   final Random rand = new Random();
   // Enemy variables
   String[] enemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
   int maxEnemyHealth = 100;
   int enemyMaxAttackDamage = 30;
   private String enemyType;
   private int enemyHealth;
   int healthPotionDropPercentage = 25;
   int enemyDroppedHealthPotions = 1;
   int healthPotionHealAmount = 30;

   // Enemy constructor (needs to be implemented)

   // Enemy appears to Player
   public void selectRandomEnemy() {
      setEnemyType(enemies[rand.nextInt(enemies.length)]);
      System.out.printf("\t~* You found a %s! *~%n", enemyType);
   }

   // Enemy's health revealed to Player
   public void discoverEnemyHealth() {
      this.enemyHealth = rand.nextInt(maxEnemyHealth);
      System.out.printf("\tThe %s has %d health.%n", enemyType, enemyHealth);
   }

   // Enemy (potentially) deals damage to Player
   public int damageDealtEnemy() {
      int enemyDamageDealt = rand.nextInt(enemyMaxAttackDamage);
      System.out.printf("\tThe %s deals %d damage to you in return.%n", enemyType, enemyDamageDealt);
      // Return damage dealt to the round logic
      // Round logic will then use this to deal damage to the player
      return enemyDamageDealt;
   }

   // Enemy (potentially) takes damage from Player (needs to be implemented here)
   // Enemy's health is updated (needs to be implemented here)
   public int damageTakenEnemy(int enemyDamageTaken) {
      this.enemyHealth -= enemyDamageTaken;
      System.out.printf("\tThe %s deals %d damage to you in return.%n", enemyType, enemyDamageTaken);
      
      return enemyDamageTaken;
   }

   // Enemy (potentially) kills Player (needs to be implemented here)

   // Enemy (potentially) dies and drops a health potion
   public void enemyDefeatedPotionDropChance() {
      System.out.printf("\tYou have defeated the %s!%n", enemyType);

      int potionDropChance = rand.nextInt(100);
      if (potionDropChance < healthPotionDropPercentage) {
         enemyDroppedHealthPotions++;
         System.out.printf("\tThe %s dropped a health potion!%n You now have %d health potions.%n", enemyType,
            enemyDroppedHealthPotions);
      }
   }

   // Enemy's getters and setters
   public String getEnemyType() {
      return enemyType;
   }

   public void setEnemyType(String enemyType) {
      this.enemyType = enemyType;
   }

   public int getEnemyHealth() {
      return enemyHealth;
   }

   public void setEnemyHealth(int enemyHealth) {
      this.enemyHealth = enemyHealth;
   }
   
}
