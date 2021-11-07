import java.util.Random;
import java.util.Scanner;

enum GameLoopState {
    PLAYER_DIED, PLAYER_RAN, ENEMY_DIED
}

class Foo {
    public static GameLoopState fightLoop(Scanner input, Random rand, Enemy enemy, Player player, String stylizedLine) {
        while (enemy.getEnemyHealth() > 0) {
            System.out.printf("\tYour health is %d.%n", player.getHealth());

            enemy.discoverEnemyHealth();

            System.out.println(stylizedLine);
            InputOption[] options = {
                new InputOption('a', "Attack!"),
                new InputOption('d', "Drink a health potion."),
                    new InputOption('r', "Run!") 
            };
            InputHandler inputHandler = new InputHandler(input);
            InputOption chosenOption = inputHandler.promptUser(options, "\tWhat would you like to do?");

            switch (chosenOption.getAlias()) {
            case 'a':
                int damageDealt = rand.nextInt(Player.getMaxAttackDamage());
                int damageTaken;

                System.out.println(stylizedLine);
                System.out.printf("\tYou dealt %d damage to the %s.%n", damageDealt, enemy.getEnemyType());

                damageTaken = enemy.damageDealtEnemy();
                enemy.damageTakenEnemy(damageDealt);
                player.takeDamage(damageTaken);

                if (player.isDead()) {
                    System.out.println("\tYou have taken too much damage.");
                    return GameLoopState.PLAYER_DIED;
                }
                break;
            case 'd':
                if (player.hasHealthPotions()) {
                    player.useHealthPotion();
                    System.out.println(stylizedLine);
                    System.out.printf("\tYou drank a health potion.%n%n \tYour health is now %d.%n \tYou have %d health potions.%n",
                    player.getHealth(), player.getHealthPotions());
                } else {
                    System.out.println(stylizedLine);
                    System.out.println("\tYou have no health potions left. Defeat enemies to find more!");
                }
                continue;
            case 'r':
                System.out.println(stylizedLine);
                System.out.printf("\tYou ran away from the %s!%n%n", enemy.getEnemyType());
                return GameLoopState.PLAYER_RAN;
            default:
                continue;
            }
        }
        return GameLoopState.ENEMY_DIED;
    }
}

public class App {
    public static void main(String[] args) {
        // System objects and variables
        final Scanner input = new Scanner(System.in);
        final Random rand = new Random();
        String stylizedLine = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        final Player player = new Player();

        // Game running boolean
        boolean gameOn = true;

        System.out.println("\n\t~* Welcome to the Darkness! *~");

        while (gameOn) {
            System.out.println(stylizedLine);

            Enemy enemy = new Enemy();
            enemy.selectRandomEnemy();

            GameLoopState result = Foo.fightLoop(input, rand, enemy, player, stylizedLine);

            if (result == GameLoopState.PLAYER_DIED) {
                System.out.println("\tYou limp into the shadows weak and bloody.");
                break;
            } else if (result == GameLoopState.ENEMY_DIED && enemy.enemyDefeatedPotionDropChance() > 0) {
                player.receiveHealthPotion();
            }

            System.out.printf("\tYour health is %d.%n", player.getHealth());            
            System.out.println(stylizedLine);
            System.out.println("\tDo you want to keep playing?");
            System.out.println("\t(a) Adventure deeper into the city.");
            System.out.println("\t(l) Live to fight another day.");

            String choice = input.nextLine().trim();

            switch (choice) {
                case "a":
                    System.out.println("\tAdvance your fight through the city.");
                    break;
                case "l":
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