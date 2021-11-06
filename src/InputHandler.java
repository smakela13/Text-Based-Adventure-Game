import java.util.Scanner;
import java.util.HashMap;

class InputHandler {
   private Scanner scanner;

   public InputHandler(Scanner scanner) {
      this.scanner = scanner;
   }

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

class InputOption {
   private final char alias;
   private final String prompt;

   public InputOption(char alias, String prompt) {
      this.alias = alias;
      this.prompt = prompt;
   }

   public char getAlias() {
      return alias;
   }

   public String getPrompt() {
      return prompt;
   }
}
