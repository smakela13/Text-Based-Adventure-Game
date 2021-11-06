import java.util.Scanner;
import java.util.HashMap;

class InputHandler {
   private Scanner scanner;

   // Constructor for InputHandler
   public InputHandler(Scanner scanner) {
      this.scanner = scanner;
   }

   // Method prompts user for input, then returns result to allow the game to continue
   public InputOption promptUser(InputOption[] options, String prompt) {
      if (options == null || options.length <= 0) {
         return null;
      }

      System.out.println(prompt);
      
      HashMap<Character, InputOption> optionMap = new HashMap<>();

      for (InputOption option : options) {
         System.out.printf("\t(%s) %s%n", option.getAlias(), option.getPrompt());
         optionMap.put(option.getAlias(), option);
      }

      InputOption result = null;

      do {
         String choice = scanner.nextLine().trim();
         if (choice.length() == 1) {
            result = optionMap.get(choice.charAt(0));
         }
      } while (result == null);

      return result;
   }
}

// InputOption class
class InputOption {
   private final char alias;
   private final String prompt;

   // InputOption's Constructor
   public InputOption(char alias, String prompt) {
      this.alias = alias;
      this.prompt = prompt;
   }

   // Getters for InputOption
   public char getAlias() {
      return alias;
   }

   public String getPrompt() {
      return prompt;
   }
}
