package maxdsc.quests;

import java.util.Scanner;
import maxdsc.quests.divider.Divider;

/** Start programm. */
public final class Main {

  private Main() {
    throw new UnsupportedOperationException();
  }

  /**
   * Запускает программу.
   *
   * @param args - Аргументы командной строки.
   */
  public static void main(final String[] args) {
    if (args.length == 1) {
      String arg = args[0];
      Scanner input = new Scanner(System.in);
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

      } else if (arg.equals("3")) {

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
