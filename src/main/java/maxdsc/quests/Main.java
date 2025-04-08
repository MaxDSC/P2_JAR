package maxdsc.quests;

import java.util.Scanner;
import maxdsc.quests.divider.Divider;
import maxdsc.quests.encrypt.Decode;
import maxdsc.quests.fibonacci.Fibonacci;

/** Start programm. */
public final class Main {

  private Main() {
    throw new UnsupportedOperationException();
  }

  /**
   * Запускает программу.
   *
   * @param args - Аргументы командной строки от команды java, могут быть от 1 до 5. Каждый аргумент
   *     выполняет определенный квест.
   */
  public static void main(final String[] args) {
    Scanner input = new Scanner(System.in);

    if (args.length == 1) {
      String arg = args[0];
      boolean err = false;
      if (arg.equals("1")) {
        if (input.hasNextInt()) {
          int num = input.nextInt();
          Divider div = new Divider(num);
          div.getLargestAndPrime();
        } else {
          err = true;
        }

      } else if (arg.equals("2")) {

        String mode = input.nextLine();
        String line = input.nextLine();
        Decode encryprtStr = new Decode(line);
        if (mode.equals("0")) {
          encryprtStr.encode();
        } else if (mode.equals("1")) {
          encryprtStr.decode();
        } else {
          err = true;
        }

      } else if (arg.equals("3")) {

        if (input.hasNextInt()) {
          int n = input.nextInt();
          Fibonacci fib = new Fibonacci(n);
          fib.printResultToConsole();
        } else {
          err = true;
        }

      } else if (arg.equals("4")) {

      } else if (arg.equals("5")) {

      } else {
        System.out.println("QUEST not found");
      }

      if (err) {
        System.out.print("Error");
      }

    } else {
      System.out.print("Missing args or there is more than one");
    }
  }
}
