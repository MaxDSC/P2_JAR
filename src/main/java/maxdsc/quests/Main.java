package maxdsc.quests;

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
      if (arg.equals("1")) {

      } else if (arg.equals("2")) {

      } else if (arg.equals("3")) {

      } else if (arg.equals("4")) {

      } else if (arg.equals("5")) {

      } else {
        System.out.println("QUEST not found");
      }
    } else {
      System.out.print("Missing args or there is more than one");
    }
  }
}
