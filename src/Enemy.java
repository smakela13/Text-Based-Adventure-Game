import java.util.Random;

public final class Enemy {
   final Random rand;

   // Enemy variables
   private static String[] allEnemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
   private String[] enemies;
   private static final int MAX_ENEMY_HEALTH = 100;
   private static final int ENEMY_MAX_ATTACK_DAMAGE = 30;
   private final String enemyType;
   private int enemyHealth;
   private static final int HEALTH_POTION_DROP_PERCENTAGE = 25;
   private final int enemyDroppedHealthPotions;
   private static final int HEALTH_POTION_HEAL_AMOUNT = 30;

   // Enemy's constructor that handles the enemy's type, health, and health potions
   private Enemy(Random rand) {
      this(rand,
         Enemy.allEnemies,
         Enemy.allEnemies[rand.nextInt(Enemy.allEnemies.length)], 
         rand.nextInt(MAX_ENEMY_HEALTH), 
         rand.nextInt(100) < HEALTH_POTION_DROP_PERCENTAGE ? 1 : 0);
   }

   // Enemy's default constructor
   public Enemy() {
      this(new Random());
   }

   // Enemy constructor that are assigned and tests if valid conditions are met
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

      if (enemyHealth < 0 || enemyHealth > MAX_ENEMY_HEALTH) {
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
      int enemyDamageDealt = rand.nextInt(ENEMY_MAX_ATTACK_DAMAGE);
      
      // Enemy deals damage to Player or doesn't hit the Player
      if (enemyDamageDealt == 0) {
         System.out.printf("\tThe %s missed!%n%n", enemyType);
      } else {
         System.out.printf("\tThe %s deals %d damage to you in return.%n%n", enemyType, enemyDamageDealt);
      }
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
      return MAX_ENEMY_HEALTH;
   }

   public int getEnemyMaxAttackDamage() {
      return ENEMY_MAX_ATTACK_DAMAGE;
   }

   public int getHealthPotionDropPercentage() {
      return HEALTH_POTION_DROP_PERCENTAGE;
   }

   public int getEnemyDroppedHealthPotions() {
      return enemyDroppedHealthPotions;
   }

   public int getHealthPotionHealAmount() {
      return HEALTH_POTION_HEAL_AMOUNT;
   }
}
