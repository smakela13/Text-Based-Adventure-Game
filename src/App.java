import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // System objects and variables
        final Scanner input = new Scanner(System.in);
        final Random rand = new Random();
        String stylizedLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        // Enemy variables
        int maxEnemyHealth = 100;

        // Player variables
        int playerHealth = 100;
        int playerMaxAttackDamage = 50;
        int playerHealthPotions = 1;
        int playerHealthPotionHealAmount = 30;

        // Game running boolean
        boolean gameOn = true;

        System.out.println("\t~* Welcome to the Darkness! *~");

        GAME: while (gameOn) {
            System.out.println(stylizedLine);

            Enemy enemy = new Enemy();
            enemy.selectRandomEnemy();
            int enemyHealth = rand.nextInt(maxEnemyHealth);

            while (enemyHealth > 0) {
                System.out.println();
                System.out.printf("\tYour health is %d.%n", playerHealth);
                
                enemy.discoverEnemyHealth();
                
                System.out.println(stylizedLine);
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Drink a health potion.");
                System.out.println("\t3. Run!");

                String choice = input.nextLine().trim();
                
                switch (choice) {
                case "1":
                    int damageDealt = rand.nextInt(playerMaxAttackDamage);
                    int damageTaken;

                    System.out.println(stylizedLine);
                    System.out.printf("\tYou dealt %d damage to the %s.%n", damageDealt, enemy.getEnemyType());

                    damageTaken = enemy.damageDealtEnemy();
                    enemyHealth = enemy.damageTakenEnemy(damageDealt);
                    playerHealth -= damageTaken;

                    if (playerHealth < 1) {
                        System.out.println("\tYou have taken too much damage.");
                        break GAME;
                    }
                    break;
                case "2":
                    if (playerHealthPotions > 0) {
                        playerHealth += playerHealthPotionHealAmount;
                        playerHealthPotions--;
                        System.out.printf("\tYou drank a health potion.%n You have healed yourself for %d.%n Your health is now %d.%n You now have %d health potions.%n", playerHealthPotionHealAmount, playerHealth, playerHealthPotions);
                    } else {
                        System.out.println("\tYou have no health potions left. Defeat enemies to find more!");
                    }
                    break;
                case "3":
                    System.out.printf("\tYou ran away from the %s!%n", enemy);
                    continue GAME;
                default:
                    System.out.println("\tPlease enter a valid input.");
                    break;
                }
            }

            if (playerHealth < 1) {
                System.out.println("\tYou limp into the shadows weak and bloody.");
                break;
            }
            System.out.println(stylizedLine);
            if (enemyHealth < 1) {
                playerHealthPotions += enemy.enemyDefeatedPotionDropChance();
            }
            System.out.printf("\tYour health is %d.%n", playerHealth);            
            System.out.println(stylizedLine);
            System.out.println("\tDo you want to keep playing?");
            System.out.println("\t1. Continue deeper into the city.");
            System.out.println("\t2. Live to fight another day.");

            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\tYou continue your fight through the city.");
                    break;
                case "2":
                    System.out.println("\tYou live to fight another day.");
                    gameOn = false;
                    break;
                default:
                    System.out.println("\tPlease enter a valid choice.");
                    break;
            }
        }
        input.close();

        System.out.println(stylizedLine);
        System.out.println("\tThanks for playing!");
        System.out.println(stylizedLine);
    }
}