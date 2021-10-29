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
   int enemyDroppedHealthPotions = 0;
   int healthPotionHealAmount = 30;

   // Enemy appears to Player
   public void selectRandomEnemy() {
      this.enemyHealth = rand.nextInt(maxEnemyHealth);
      setEnemyType(enemies[rand.nextInt(enemies.length)]);
      
      System.out.printf("\t~* You found a %s! *~%n", enemyType);
   }

   // Enemy's health revealed to Player
   public void discoverEnemyHealth() {
      System.out.printf("\tThe %s has %d health.%n", enemyType, enemyHealth);
   }

   // Enemy (potentially) deals damage to Player
   public int damageDealtEnemy() {
      int enemyDamageDealt = rand.nextInt(enemyMaxAttackDamage);
      System.out.printf("\tThe %s deals %d damage to you in return.%n", enemyType, enemyDamageDealt);
      // Fight logic will use damage dealt to injure to the player
      return enemyDamageDealt;
   }

   // Enemy (potentially) takes damage from Player and enemy's health is updated
   public int damageTakenEnemy(int enemyDamageTaken) {
      this.enemyHealth -= enemyDamageTaken;
      
      return enemyHealth;
   }

   // Enemy dies and (potentially) drops a health potion
   public int enemyDefeatedPotionDropChance() {
      System.out.printf("\tYou defeated the %s!%n", enemyType);

      int potionDropChance = rand.nextInt(100);
      
      if (potionDropChance < healthPotionDropPercentage) {
         this.enemyDroppedHealthPotions++;
         System.out.printf("\tThe %s dropped a health potion!%n%n \tYou now have %d health potions.%n", enemyType,
            enemyDroppedHealthPotions);
      }
      return enemyDroppedHealthPotions;
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
