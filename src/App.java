import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // System objects and variables
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String stylizedLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        // Enemy variables
        String[] enemies = {"Vampire", "Zombie", "Werewolf", "Ghoul", "Mage", "Ghost", "Mummy", "Revenant", "Hunter"};
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 30;

        // Player variables
        int playerHealth = 100;
        int playerAttackDamage = 50;
        int playerHealthPotions = 30;
        int playerHealthPotionHealAmount = 30;
        int playerHealthPotionDropPercentage = 25;

        // Game running boolean
        boolean gameOn = true;

        System.out.println("\t~* Welcome to the Darkness! *~");

        GAME:
        while (gameOn) {
            System.out.println(stylizedLine);

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t~* You have found a " + enemy + "! *~\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour health is " + playerHealth + ".");
                System.out.println("\tThe " + enemy + "'s health is " + enemyHealth + ".\n");
                System.out.println(stylizedLine);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack!");
                System.out.println("2. Drink a health potion.");
                System.out.println("3. Run!");

                String choice = input.nextLine();
                if (choice.equals("1")) {
                    int damageDealt = rand.nextInt(playerAttackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;

                    System.out.println(stylizedLine);
                    System.out.println("\tYou dealt " + damageDealt + " damage to the " + enemy + ".");
                    System.out.println("\tThe " + enemy + " dealt " + damageTaken + " damage to you in return.\n");

                    if (playerHealth < 1) {
                        System.out.println("\tYou have taken too much damage.");
                        break GAME;
                    }
                } else if (choice.equals("2")) {
                    if (playerHealthPotions > 0) {
                        playerHealth += playerHealthPotionHealAmount;
                        playerHealthPotions--;
                        System.out.println("\tYou have healed yourself for " + playerHealthPotionHealAmount + " health."
                                + "\n\t You now have " + playerHealth + " health." + "\n\t You now have "
                                + playerHealthPotions + " health potions.\n");
                    } else {
                        System.out.println("\tYou have no health potions left. Defeat enemies to find more!");
                    }
                } else if (choice.equals("3")) {
                    System.out.println("\tYou have run away from the " + enemy + ".");
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
            System.out.println("\t ## The " + enemy + " has been defeated!");
            System.out.println("\tYou have " + playerHealth + " health left.");
            if (rand.nextInt(100) < playerHealthPotionDropPercentage) {
                playerHealthPotions++;
                System.out.println("\tThe " + enemy + " has dropped a health potion!");
                System.out.println("\tYou now have " + playerHealthPotions + " health potions.");
            } 
            System.out.println(stylizedLine);
            System.out.println("\tDo you want to keep playing?");
            System.out.println("\t1. Continue deeper into the city.");
            System.out.println("\t2. Live to fight another day.");

            String choice = input.nextLine();

            while (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("\tPlease enter a valid choice.");
                choice = input.nextLine();
            }
                if (choice.equals("1")) {
                    System.out.println("You continue your fight through the city.");
                } else if (choice.equals("2")) {
                    System.out.println("You head home, successful in your battles, but you keep an eye on your rearview mirror. Just in case.");
                    break;
                }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        System.out.println("Thanks for playing!");
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        
    }
}