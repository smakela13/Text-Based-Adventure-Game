import java.util.Random;

public class Player {
   final Random rand = new Random();

   // Player variables
   private int health;
   private static final int MAX_ATTACK_DAMAGE = 50;
   private int healthPotions;
   private static final int HEALTH_POTION_HEAL_AMOUNT = 30;
   
   public Player() {
      this(100, 1);
   }

   public Player(int health, int healthPotions) {
      this.health = health;
      this.healthPotions = healthPotions;
   }

   public void takeDamage(int damage) {
      this.health -= damage;
   }

   public boolean isDead() {
      return this.health <= 0;
   }

   public boolean hasHealthPotions() {
      return this.healthPotions > 0;
   }

   public boolean useHealthPotion() {
      if (!hasHealthPotions()) {
         return false;
      }
      this.health += HEALTH_POTION_HEAL_AMOUNT;
      this.healthPotions--;
      return true;
   }

   public void receiveHealthPotion() {
      this.healthPotions++;
   }

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
