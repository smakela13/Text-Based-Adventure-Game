import java.util.Random;

final public class Enemy {
   final Random rand;

   // Enemy variables
   private static String[] allEnemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
   private String[] enemies;
   private final static int maxEnemyHealth = 100;
   private final int enemyMaxAttackDamage = 30;
   private final String enemyType;
   private int enemyHealth;
   private final static int healthPotionDropPercentage = 25;
   private final int enemyDroppedHealthPotions;
   private final int healthPotionHealAmount = 30;

   private Enemy(Random rand) {
      this(rand,
         Enemy.allEnemies,
         Enemy.allEnemies[rand.nextInt(Enemy.allEnemies.length)], 
         rand.nextInt(maxEnemyHealth), 
         rand.nextInt(100) < healthPotionDropPercentage ? 1 : 0);
   }

   public Enemy() {
      this(new Random());
   }

   Enemy(Random rand, String[] enemies, String enemyType, int enemyHealth, int enemyDroppedHealthPotions) {
      if (rand == null) {
         throw new IllegalArgumentException("rand cannot be null");
      }
      this.rand = rand;
      
      if (enemies == null || enemies.length == 0) {
         throw new IllegalArgumentException("enemies cannot be null or invalid");
      }
      this.enemies = enemies;

      if (enemyType == null || enemyType.trim().isEmpty()) {
         throw new IllegalArgumentException("enemyType cannot be null or empty");
      }
      this.enemyType = enemyType;

      if (enemyHealth < 0 || enemyHealth > maxEnemyHealth) {
         throw new IllegalArgumentException("enemyHealth cannot be invalid");
      }
      this.enemyHealth = enemyHealth;

      if (enemyDroppedHealthPotions < 0) {
         throw new IllegalArgumentException("enemyDroppedHealthPotions cannot be negative");
      }
      this.enemyDroppedHealthPotions = enemyDroppedHealthPotions;
   }

   // Enemy appears to Player
   public void selectRandomEnemy() {
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
      
      if (enemyDroppedHealthPotions > 0) {
         System.out.printf("\tThe %s dropped a health potion!%n%n", enemyType);
      }
      return enemyDroppedHealthPotions;
   }

   // Enemy's getters and setters
   public String getEnemyType() {
      return enemyType;
   }

   public int getEnemyHealth() {
      return enemyHealth;
   }

   public void setEnemyHealth(int enemyHealth) {
      this.enemyHealth = enemyHealth;
   }

   public String[] getEnemies() {
      return enemies;
   }

   public void setEnemies(String[] enemies) {
      this.enemies = enemies;
   }

   public int getMaxEnemyHealth() {
      return maxEnemyHealth;
   }

   public int getEnemyMaxAttackDamage() {
      return enemyMaxAttackDamage;
   }

   public int getHealthPotionDropPercentage() {
      return healthPotionDropPercentage;
   }

   public int getEnemyDroppedHealthPotions() {
      return enemyDroppedHealthPotions;
   }

   public int getHealthPotionHealAmount() {
      return healthPotionHealAmount;
   }
}
