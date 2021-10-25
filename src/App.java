import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // System objects and variables
        final Scanner input = new Scanner(System.in);
        final Random rand = new Random();
        String stylizedLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        // Player variables
        int playerHealth = 100;
        int playerMaxAttackDamage = 50;
        int playerHealthPotions = 1;
        int playerHealthPotionHealAmount = 30;
        int playerHealthPotionDropPercentage = 25;

        // Enemy variables
        String[] enemies = { "Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter" };
        int maxEnemyHealth = 100;
        int enemyMaxAttackDamage = 30;

        // Game running boolean
        boolean gameOn = true;

        System.out.println("\t~* Welcome to the Darkness! *~");

        GAME: while (gameOn) {
            System.out.println(stylizedLine);

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            String enemyFoundString = String.format("\t~* You have found a %s! *~", enemy);
            System.out.println(enemyFoundString);

            while (enemyHealth > 0) {
                String playerHealthString = String.format("\tYour health is %d.", playerHealth);
                System.out.println(playerHealthString);
                String enemyHealthString = String.format("\tThe %s's health is %d.", enemy, enemyHealth);
                System.out.println(enemyHealthString);
                System.out.println(stylizedLine);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack!");
                System.out.println("2. Drink a health potion.");
                System.out.println("3. Run!");

                String choice = input.nextLine().trim();
                if (choice.equals("1")) {
                    int damageDealt = rand.nextInt(playerMaxAttackDamage);
                    int damageTaken = rand.nextInt(enemyMaxAttackDamage);

                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;

                    System.out.println(stylizedLine);
                    String damageDealtString = String.format("\tYou dealt %d damage to the %s.", damageDealt, enemy);
                    System.out.println(damageDealtString);
                    String damageTakenString = String.format("\tThe %s dealt %d damage to you in return.", enemy, damageTaken);
                    System.out.println(damageTakenString);

                    if (playerHealth < 1) {
                        System.out.println("\tYou have taken too much damage.");
                        break GAME;
                    }
                } else if (choice.equals("2")) {
                    if (playerHealthPotions > 0) {
                        playerHealth += playerHealthPotionHealAmount;
                        playerHealthPotions--;
                        String healingHealthPotionDrankString = String.format("\tYou drank a health potion.%n You have healed yourself for %d.%n Your health is now %d.%n You now have %d health potions.", playerHealthPotionHealAmount, playerHealth, playerHealthPotions);
                        System.out.println(healingHealthPotionDrankString);
                    } else {
                        System.out.println("\tYou have no health potions left. Defeat enemies to find more!");
                    }
                } else if (choice.equals("3")) {
                    String ranAwayString = String.format("\tYou ran away from the %s.", enemy);
                    System.out.println(ranAwayString);
                    continue GAME;
                } else {
                    System.out.println("\tPlease enter a valid choice.");
                }
            }

            if (playerHealth < 1) {
                System.out.println("\tYou limp into the shadows weak and bloody.");
                break;
            }
            System.out.println(stylizedLine);
            String enemyDefeatedString = String.format("\tYou have defeated the %s!", enemy);
            System.out.println(enemyDefeatedString);
            String playerHealthString = String.format("\tYour health is %d.", playerHealth);
            System.out.println(playerHealthString);
            if (rand.nextInt(100) < playerHealthPotionDropPercentage) {
                playerHealthPotions++;
                String healthPotionDroppedString = String.format("\tThe %s dropped a health potion!%n You now have %d health potions.", enemy, playerHealthPotions);
                System.out.println(healthPotionDroppedString);
            }
            System.out.println(stylizedLine);
            System.out.println("\tDo you want to keep playing?");
            System.out.println("\t1. Continue deeper into the city.");
            System.out.println("\t2. Live to fight another day.");

            String choice = input.nextLine().trim();

            while (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("\tPlease enter a valid choice.");
                choice = input.nextLine().trim();
            }
            if (choice.equals("1")) {
                System.out.println("You continue your fight through the city.");
            } else if (choice.equals("2")) {
                System.out.println(
                        "You head home, successful in your battles, but you keep an eye on your rearview mirror. Just in case.");
                gameOn = false;
            }
        }
        input.close();

        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("Thanks for playing!");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
    }
}