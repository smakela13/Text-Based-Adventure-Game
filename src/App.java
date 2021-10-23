import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // System objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

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

        System.out.println("Welcome to the Darkness!");

        GAME:
        while (gameOn) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
    }
}
