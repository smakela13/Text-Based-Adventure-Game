import java.util.Random;

public final class Player {
   final Random rand = new Random();

   // Player variables
   private int health;
   private static final int MAX_ATTACK_DAMAGE = 50;
   private int healthPotions;
   private static final int HEALTH_POTION_HEAL_AMOUNT = 30;
   
   // Player's default constructor
   public Player() {
      this(100, 1);
   }

   // Player constructor that assigns value to health and health potions and tests if valid conditions are met
   public Player(int health, int healthPotions) {
      if (health < 0) {
         throw new IllegalArgumentException("Player health must be greater than 0");
      }
      this.health = health;

      if (healthPotions < 0) {
         throw new IllegalArgumentException("Player health potions cannot be negative");
      }
      this.healthPotions = healthPotions;
   }

   // Player (potentially) takes damage from the enemy
   public void takeDamage(int damage) {
      this.health -= damage;
   }

   // Checks if player is dead
   public boolean isDead() {
      return this.health <= 0;
   }

   // Checks if player has health potions
   public boolean hasHealthPotions() {
      return this.healthPotions > 0;
   }

   // Player uses health potion, if they have any
   public boolean useHealthPotion() {
      if (!hasHealthPotions()) {
         return false;
      }
      this.health += HEALTH_POTION_HEAL_AMOUNT;
      this.healthPotions--;
      return true;
   }

   // Player potentially receives health potions from enemy's death
   public void receiveHealthPotion() {
      this.healthPotions++;
   }

   // Player's getters and setters
   public int getHealth() {
      return health;
   }

   public static int getMaxAttackDamage() {
      return MAX_ATTACK_DAMAGE;
   }

   public int getHealthPotions() {
      return healthPotions;
   }

   public static int getHealthPotionHealAmount() {
      return HEALTH_POTION_HEAL_AMOUNT;
   }
}
